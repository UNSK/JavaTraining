/**
 * Copyright (c) 2015 Ricoh Company, ltd.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import chat.ChatClient;

/**
 *
 */
public class ClientController {

    MainGUI view;
    ChatClient endpoint;

    URI serverUri;// = URI.create("ws://localhost:8080/chat");
    Session session;

    public ClientController() {
        view = new MainGUI();
        endpoint = new ChatClient(view);
        //        view.display();
        view.preDisplay();
    }

    public void control() {

        view.getConnectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endpoint.setName(view.getUsernameChooser().getText());
                WebSocketContainer container = ContainerProvider.getWebSocketContainer();
                String address = view.getServerAddress().getText();
                serverUri = URI.create("ws://" + address + ":8080/chat");
                try {
                    session = container.connectToServer(endpoint, serverUri);
                    System.out.println(session);
                } catch (DeploymentException ex) {
                    view.printMessage("[ERROR] failed to connect server.");
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                view.display();
            }
        });

        // send message button action
        view.getSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = view.getSendMessage();
                if (message.isEmpty()) {
                    //nop
                } else if (message.startsWith("\\")) {
                    parseCommand(message);
                } else {
                    endpoint.send(message);
                }
                view.clearMessageBox();
            }
        });
    }

    private void parseCommand(String s) {
        if (s.startsWith("\\whisper")) {
            // \whisper <name> <message>
            String str[] = s.split("[\\s　]", 3);
            String name = str[1];
            String message = str[2];
            endpoint.sendTo(message, name);
        } else if (s.startsWith("\\clock")) {
            view.showClock();
        } else if (s.startsWith("\\list")) {
            endpoint.getClientList();
        } else {
            view.printInfo("invalid command");
        }
    }
}
