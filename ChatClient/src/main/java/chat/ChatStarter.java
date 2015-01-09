package chat;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 */
public class ChatStarter {

    /**
     * @param args
     * @throws IOException
     * @throws DeploymentException
     */
    public static void main(String[] args) throws DeploymentException, IOException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = URI.create("ws://localhost:8080/chat");
        Session session = container.connectToServer(new ChatClient(), uri);
    }

}
