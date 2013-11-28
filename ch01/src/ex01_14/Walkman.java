package ex01_14;

/**
 * 端子を一つ持つウォークマンクラス
 */
public class Walkman {
	/**
	 * 端子
	 */
	private Object jack_;
	
	/**
	 * setter
	 * @param jack 端子
	 */
	public void setJack(Object jack) {
		this.jack_ = jack;
	}
	
	/**
	 * getter
	 * @return　Object メンバ変数jack_を返す
	 */
	public Object getJack() {
		return this.jack_;
	}
	
	/**
	 *　端子jackで音楽を再生する
	 */
	public void playMusic() {
		jack_ = "now playing (jack)";
	}
}
