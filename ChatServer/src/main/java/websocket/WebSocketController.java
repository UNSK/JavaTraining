package websocket;



import java.io.IOException;
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
     * @param name
     *            クライアントの名前
     * @return レスポンス（JSON形式)
     */
    public JSONObject parseJSON(JSONObject reqJson, String name) {
        JSONObject resJson = new JSONObject();
        switch (reqJson.getString("tag")) {
        case "message":
            if (reqJson.getString("entity").startsWith("@bot")) {
                String msgToBot = "hubot " + reqJson.getString("entity").split("[\\s　]", 2)[1];
                for (WebSocketChat c : clients) {
                    if (c.getName().equals("BOT")) {
                        try {
                            c.getSession().getBasicRemote().sendText(msgToBot);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
            resJson.put("tag", "message");
            resJson.put("sendFrom", name);
            resJson.put("sendTo", reqJson.getString("sendTo"));
            resJson.put("entity", reqJson.getString("entity"));
            break;
        case "sendName":
            resJson.put("tag", "message");
            resJson.put("sendFrom", "SV");
            resJson.put("sendTo", "all");
            resJson.put("entity", "Hello, " + reqJson.getString("name"));
            break;
        case "list":
            resJson.put("tag", "message");
            resJson.put("sendFrom", "SV");
            resJson.put("sendTo", name);
            String clientNames = "";
            for (WebSocketChat c : clients) {
                clientNames += "\n" + c.getName();
            }
            resJson.put("entity", clientNames);
        default:
            new AssertionError("undefined api tag");
        }
        return resJson;
    }

    /**
     * @return clients クライアントのリストを返す
     */
    public Set<WebSocketChat> getClients() {
        return clients;
    }
}
