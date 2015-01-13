package chat;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.json.JSONObject;

import view.MainGUI;

/**
 *
 */
@ClientEndpoint
public class ChatClient {

    private MainGUI view;
    private Session session;
    private String name = "nanashi";

    public ChatClient(MainGUI view) {
        this.view = view;
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sendName(name);
        System.out.println("tsunagatta!");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);

        JSONObject json = new JSONObject(message);

        view.showReceivedMessage(json.getString("entity"), json.getString("sendFrom"));
    }

    /**
     * send plain text to chat server
     * @param s the message to sent
     */
    public void send(String s) {
        JSONObject json = new JSONObject();
        json.put("tag", "message");
        json.put("type", "plainText");
        json.put("sendTo", "all");
        json.put("entity", s);
        sendServer(json);
    }

    public void sendName(String name) {
        JSONObject json = new JSONObject();
        json.put("tag", "sendName");
        json.put("name", name);
        sendServer(json);
    }

    private void sendServer(JSONObject json) {
        try {
            session.getBasicRemote().sendText(json.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }
}
