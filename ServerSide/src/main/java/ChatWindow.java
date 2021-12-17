import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;

public class ChatWindow extends JFrame {

    JTextField msgInputField;
    JTextArea chatArea;
    private boolean noTakedEnd = true;

    public void setTakeEnd(boolean noTakedEnd) {
        this.noTakedEnd = noTakedEnd;
    }

    public void setMsgInputField(JTextField msgInputField) {
        this.msgInputField = msgInputField;
    }

    public void setChatArea(JTextArea chatArea) {
        this.chatArea = chatArea;
    }

    DataOutputStream dos;

    public ChatWindow(DataOutputStream dos) {
        this.dos = dos;

        setBounds(600, 300, 500, 500);
        setTitle("Сервер");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (noTakedEnd) {
                    try {
                        dos.writeUTF("/end");
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });

        setVisible(true);
    }

    private void sendMessage() {
        String msg = msgInputField.getText();
        if (msg != null && !msg.trim().isEmpty()) {
            try {
                dos.writeUTF(msg);
                chatArea.append("Ваше сообщение: " + msg + "\n");
                msgInputField.setText("");
                msgInputField.grabFocus();
                if (msg.equalsIgnoreCase("/end")) {
//                    System.exit(0);
                    chatArea.append("-------------Вы закрыли соединение-------------\n");
                    msgInputField.setText("");
                    msgInputField.setEditable(false);
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения.");
            }
        }
    }
}
