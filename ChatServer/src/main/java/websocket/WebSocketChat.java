package websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * WebSocketのリスナー
 */
@ServerEndpoint("/chat")
public class WebSocketChat {
    /** 接続したクライアントとのセッション */
    private Session session;
    /** clients name */
    private String name = null;

    /**
     * WebSocket on connect
     * @param session 接続したセッション
     * @throws IOException
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
        System.out.println("connect: " + session.hashCode()); //debug TODO delete
        System.out.println("kakunin! yokatta.");
        //session.getBasicRemote().sendText("hello");
        WebSocketController.getInstance().join(this);
    }

    /**
     * WebSocket on close
     * @param status ステータスコード
     * @param reason 終了した理由
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("close: " + session.hashCode());
        System.out.println("sayonara!");
        WebSocketController.getInstance().bye(this);

        JSONObject json = new JSONObject();
        json.put("tag", "message");
        json.put("sendTo", "all");
        json.put("sendFrom", "SV");
        json.put("entity", "bye, " + name);
        try {
            sendMessage(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * WebSocket on message
     * @param message sent by client
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        //test broadcast
        for(WebSocketChat clients : WebSocketController.getInstance().getClients()) {
            clients.getSession().getBasicRemote().sendText(message);
        }

        //性能テスト用に時間計測
        long begin, end;
        System.out.println("message by " + name);
        System.out.println("REQ: " + message); //debug TODO delete
        begin = System.currentTimeMillis();
        try {
            JSONObject reqJson = new JSONObject(message);
            //デバイス固有値がリクエストに含まれていたら保存する
            if (reqJson.has("name")) {
                this.name = reqJson.getString("name");
            }
            //json形式なら解析に渡す
            JSONObject resJson = WebSocketController.getInstance().parseJSON(reqJson, name);
            //帰ってきたレスポンス用のjsonを送る
//            session.getRemote().sendStringByFuture(resJson.toString());
//            session.getBasicRemote().sendText(resJson.toString());
            sendMessage(resJson);
            System.out.println("RES: " + resJson.toString());
        } catch (JSONException e) {
            session.getBasicRemote().sendText(e.toString());
//            session.getRemote().sendStringByFuture(e.toString());
        } finally {
            end = System.currentTimeMillis();
            System.out.println("elapsed " + (end - begin) + " milli-sec");
            System.out.println();
        }

    }

    /**
     * send message to client
     * @param json
     * @throws IOException
     */
    private void sendMessage(JSONObject json) throws IOException {
        String sendTo = json.getString("sendTo");
        if (sendTo.equals("all")) {
            for(WebSocketChat clients : WebSocketController.getInstance().getClients()) {
                clients.getSession().getBasicRemote().sendText(json.toString());
            }
        } else {
            for(WebSocketChat clients : WebSocketController.getInstance().getClients()) {
                if (sendTo.equals(clients.getName())) {
                    clients.getSession().getBasicRemote().sendText(json.toString());
                }
            }
        }
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return this.session;
    }

    /**
     * @return the uuid
     */
    public String getName() {
        if (name != null) {
            return name;
        } else {
            return "";
        }
    }

    /**
     * @param name to set
     */
    public void setUuid(String name) {
        this.name = name;
    }
}
