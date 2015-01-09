package chat;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 */
@ClientEndpoint
public class ChatClient {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("tsunagatta!");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
    }
}
