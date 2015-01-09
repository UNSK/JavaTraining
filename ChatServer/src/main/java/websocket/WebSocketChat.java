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
    /** クライアントのデバイス固有値 */
    private String uuid = null;

    /**
     * WebSocket on connect
     * @param session 接続したセッション
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("connect: " + session.hashCode()); //debug TODO delete
        System.out.println("kakunin! yokatta.");
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
    }

    /**
     * WebSocket on message
     * @param message sent by client
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        //性能テスト用に時間計測
        long begin, end;
        System.out.println("message by " + uuid);
        System.out.println("REQ: " + message); //debug TODO delete
        begin = System.currentTimeMillis();
        try {
            JSONObject reqJson = new JSONObject(message);
            //デバイス固有値がリクエストに含まれていたら保存する
            if (reqJson.has("uuid")) {
                this.uuid = reqJson.getString("uuid");
            }
            //json形式なら解析に渡す
            JSONObject resJson = WebSocketController.getInstance().parseJSON(reqJson, uuid);
            //帰ってきたレスポンス用のjsonを送る
//            session.getRemote().sendStringByFuture(resJson.toString());
            session.getBasicRemote().sendText(resJson.toString());
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
     * @return the session
     */
    public Session getSession() {
        return this.session;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        if (uuid != null) {
            return uuid;
        } else {
            return "";
        }
    }

    /**
     * @param uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
