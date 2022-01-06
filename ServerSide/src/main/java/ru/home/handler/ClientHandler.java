package ru.home.handler;

import ru.home.service.MyServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String nickName;
    private boolean isNotDisconnected = true;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    authentication();
                    if (isNotDisconnected) {
                        receiveMessage();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void authentication() throws Exception {
        while (true) {
            String message = dis.readUTF();
            if (message.startsWith("/end")) {
                sendMessage(message);
                isNotDisconnected = false;
                break;

            }
            if (message.startsWith("/start")) {
                String[] arr = message.split("-", 3);
                if (arr.length != 3) {
                    throw new IllegalAccessException();
                }
                final String nick = myServer
                        .getAuthenticationService()
                        .getNickNameByLoginAndPassword(arr[1].trim(), arr[2].trim());
                if (nick != null) {
                    if (!myServer.nickNameIsBusy(nick)) {
                        sendMessage("/start " + nick);
                        this.nickName = nick;
                        myServer.sendMessageToClients(nickName + " присоединился к чату.");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMessage("Your nickName is busy now. Try later.");
                    }
                } else {
                    sendMessage("Wrong login or password");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage() throws IOException, IllegalAccessException {
        while (true) {
            String message = dis.readUTF();
            if (message.startsWith("/")) {
                if (message.startsWith("/end")) {
                    myServer.unSubscribe(this);
                    sendMessage(message);
                    myServer.sendMessageToClients(nickName + " вышел из чата.");
                    return;
                }
                if (message.startsWith("/nick")) {
                    String[] msgArr = message.split("-", 3);
                    if (msgArr.length != 3) {
                        throw new IllegalAccessException();
                    }
                    myServer.sendMessageToClients(this, msgArr[1], msgArr[2]);
                }
                if (message.startsWith("/online")) {
                    myServer.getOnlineUsers(this);
                }
                continue;
            }
            myServer.sendMessageToClients(nickName + ": " + message);
        }
    }

    private void closeConnection() {
//        myServer.unSubscribe(this);
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickName() {

        return nickName;
    }
}
