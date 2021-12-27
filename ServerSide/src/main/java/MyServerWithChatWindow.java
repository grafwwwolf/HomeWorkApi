import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerWithChatWindow { //} {

    private final Integer SERVER_PORT = 8880;
    Socket socket = null;
    DataInputStream dis;
    DataOutputStream dos;

    public MyServerWithChatWindow() {
        startServer();
    }

    private void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {

            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    System.out.println("Клиент подключился");
                    dis = new DataInputStream(socket.getInputStream());
                    dos = new DataOutputStream(socket.getOutputStream());
                    ChatWindow chatWindow = new ChatWindow(dos);
                    chatWindow.chatArea.append("Клиент подключился\n");
                    while (true) {
                        String inputText = dis.readUTF();
                        if (inputText.equalsIgnoreCase("/end")) {
                            System.out.println(inputText);
                            chatWindow.setTakeEnd(false);
                            chatWindow.chatArea.append("Клиент отключился");
                            chatWindow.msgInputField.setText("");
                            chatWindow.msgInputField.setEditable(false);
                            try {
                                dos.writeUTF(inputText);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                closeConnection(dis, dos);
                                break;
                            }
                        }
                        chatWindow.chatArea.append("Сообщение от клиента: " + inputText + "\n");
                        System.out.println(inputText);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(DataInputStream dis, DataOutputStream dos) {
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
    }
}
