package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.digitalclock.ClockPanel;


public class MainGUI {

    private String      appName     = "chat";
    private MainGUI     mainGUI;
    private JFrame      newFrame    = new JFrame(appName);
    private JButton     sendButton;
    private JButton     connectButton;
    private JTextField  messageBox;
    private JTextArea   chatBox;
    private JTextField  usernameChooser;
    private JTextField  serverAddress;
    private JFrame      preFrame;

    private ClockPanel clockPanel;
    private boolean clockFlag = false;

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager
//                            .getSystemLookAndFeelClassName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                MainGUI mainGUI = new MainGUI();
//                mainGUI.preDisplay();
//            }
//        });
//    }

    public void preDisplay() {
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setVisible(false);
        preFrame = new JFrame(appName);
        preFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usernameChooser = new JTextField(15);
        serverAddress = new JTextField("localhost", 15);
        JLabel chooseUsernameLabel = new JLabel("username:");
        connectButton = new JButton("Enter Chat Server");
////        connectButton.addActionListener(new enterServerButtonListener());
//        JPanel prePanel = new JPanel(new GridBagLayout());
//
//        GridBagConstraints preRight = new GridBagConstraints();
//        preRight.insets = new Insets(0, 0, 0, 10);
//        preRight.anchor = GridBagConstraints.EAST;
//        GridBagConstraints preLeft = new GridBagConstraints();
//        preLeft.anchor = GridBagConstraints.WEST;
//        preLeft.insets = new Insets(0, 10, 0, 10);
//        // preRight.weightx = 2.0;
//        preRight.fill = GridBagConstraints.HORIZONTAL;
//        preRight.gridwidth = GridBagConstraints.REMAINDER;

        JPanel prePanel = new JPanel(new GridLayout(2, 2));
        prePanel.add(new JLabel("Server address"));
        prePanel.add(serverAddress);
        prePanel.add(chooseUsernameLabel);
        prePanel.add(usernameChooser);


//        prePanel.add(chooseUsernameLabel, preLeft);
//        prePanel.add(usernameChooser, preRight);

        preFrame.add(BorderLayout.CENTER, prePanel);
        preFrame.add(BorderLayout.SOUTH, connectButton);

        preFrame.getRootPane().setDefaultButton(connectButton);

        usernameChooser.requestFocusInWindow();

        preFrame.setSize(300, 100);
        preFrame.setVisible(true);


        //
        // main frame
        //
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendButton = new JButton("Send Message");
//        sendButton.addActionListener(new sendMessageButtonListener());

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Monospaced", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(messageBox, left);
        southPanel.add(sendButton, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        newFrame.getRootPane().setDefaultButton(sendButton);

        clockPanel = new ClockPanel();
        mainPanel.add(BorderLayout.NORTH, clockPanel);
        clockPanel.setVisible(clockFlag); //default: false

        newFrame.add(mainPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(270, 200);
    }

    public void display() {
        if (preFrame != null) {
            preFrame.setVisible(false);
        }
        newFrame.setVisible(true);
    }

//    public void display() {
//        if (preFrame != null) {
//            preFrame.setVisible(false);
//        }
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//
//        JPanel southPanel = new JPanel();
//        southPanel.setBackground(Color.BLUE);
//        southPanel.setLayout(new GridBagLayout());
//
//        messageBox = new JTextField(30);
//        messageBox.requestFocusInWindow();
//
//        sendButton = new JButton("Send Message");
//        sendButton.addActionListener(new sendMessageButtonListener());
//
//        chatBox = new JTextArea();
//        chatBox.setEditable(false);
//        chatBox.setFont(new Font("Monospaced", Font.PLAIN, 15));
//        chatBox.setLineWrap(true);
//
//        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);
//
//        GridBagConstraints left = new GridBagConstraints();
//        left.anchor = GridBagConstraints.LINE_START;
//        left.fill = GridBagConstraints.HORIZONTAL;
//        left.weightx = 512.0D;
//        left.weighty = 1.0D;
//
//        GridBagConstraints right = new GridBagConstraints();
//        right.insets = new Insets(0, 10, 0, 0);
//        right.anchor = GridBagConstraints.LINE_END;
//        right.fill = GridBagConstraints.NONE;
//        right.weightx = 1.0D;
//        right.weighty = 1.0D;
//
//        southPanel.add(messageBox, left);
//        southPanel.add(sendButton, right);
//
//        mainPanel.add(BorderLayout.SOUTH, southPanel);
//
//        newFrame.add(mainPanel);
//        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        newFrame.setSize(470, 300);
//        newFrame.setVisible(true);
//    }


    public String getSendMessage() {
        return messageBox.getText();
    }

    public void clearMessageBox() {
        messageBox.setText("");
        messageBox.requestFocusInWindow();
    }

    public void showReceivedMessage(String s, String name) {
        chatBox.append("<" + name + ">: " );
        chatBox.append(s + "\n");
    }

    public void printInfo(String s) {
        chatBox.append(s + "\n");
    }

    public void printMessage(String s) {
        chatBox.setText(s);
    }

    public void showClock() {
        clockFlag = !clockFlag;
        clockPanel.setVisible(clockFlag);
    }

    /**
     * @return the connectButton
     */
    public JButton getConnectButton() {
        return connectButton;
    }

    /**
     * @return the sendMessage
     */
    public JButton getSendButton() {
        return sendButton;
    }

    /**
     * @return the usernameChooser
     */
    public JTextField getUsernameChooser() {
        return usernameChooser;
    }

    /**
     * @return the serverAddress
     */
    public JTextField getServerAddress() {
        return serverAddress;
    }

//    class sendMessageButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            if (messageBox.getText().length() < 1) {
//                // do nothing
//            } else if (messageBox.getText().equals(".clear")) {
//                chatBox.setText("Cleared all messages\n");
//                messageBox.setText("");
//            } else {
//                chatBox.append("<" + username + ">:  " + messageBox.getText()
//                        + "\n");
//                messageBox.setText("");
//            }
//            messageBox.requestFocusInWindow();
//        }
//    }
//
//    String  username;
//
//    class enterServerButtonListener implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            username = usernameChooser.getText();
//            if (username.length() < 1) {
//                System.out.println("No!");
//            } else {
//                preFrame.setVisible(false);
//
//                display();
//            }
//        }
//
//    }
}