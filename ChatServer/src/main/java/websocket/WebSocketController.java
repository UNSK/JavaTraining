package websocket;



import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;


/**
 *  {@link WebSocketChat}から渡される処理を行うSingletonクラス。
 */
public class WebSocketController {
    /** コンストラクタはSingletonパターンのためにprivateにする */
    private WebSocketController() {
    };

    /** 唯一のインスタンス */
    private static WebSocketController instance = new WebSocketController();

    /** クライアントのリスト */
    private Set<WebSocketChat> clients = new HashSet<>();

    /**
     * @return instance このクラスのインスタンスを返す
     */
    public static WebSocketController getInstance() {
        return instance;
    }

    /**
     * クライアントを追加する
     *
     * @param socket リスナクラスのソケット
     */
    public void join(WebSocketChat socket) {
        clients.add(socket);
    }

    /**
     * クライアントを削除する
     *
     * @param socket
     *            リスナークラスのソケット
     */
    public void bye(WebSocketChat socket) {
        clients.remove(socket);
    }

    /**
     * JSONを解析して、Facadeの各メソッドに渡す。
     * @param reqJson
     *            JSONオブジェクト
     * @param uuid
     *            デバイス固有値
     * @return レスポンス（JSON形式)
     */
    public JSONObject parseJSON(JSONObject reqJson, String uuid) {
        return reqJson;
    }

    /**
     * @return clients クライアントのリストを返す
     */
    public Set<WebSocketChat> getClients() {
        return clients;
    }
}
