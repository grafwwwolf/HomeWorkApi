import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {

    public Chat() {

        setTitle("Мой МиниЧат");
        setBounds(300, 300, 600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.SOUTH);

        final JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Отправить");
        textPanel.add(messageField, BorderLayout.CENTER);
        textPanel.add(sendButton, BorderLayout.EAST);

        final JTextArea historyPanel = new JTextArea("история сообщений:");
        historyPanel.setEditable(false);
        historyPanel.setLineWrap(true);

        add(new JScrollPane(historyPanel), BorderLayout.CENTER);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (messageField.getText().equals("")) {
                    return;
                }
                String text = historyPanel.getText();
                text = text + "\n" + messageField.getText();
                historyPanel.setText(text);
                messageField.setText("");
            }
        });

        setVisible(true);
    }
}
