package ex01_14;

/**
 * ２つ端子を持つウォークマンクラス
 * {@link Walkman}を拡張
 */
public class TwoJacksWalkman extends Walkman {
	/**
	 * ２つ目の端子
	 */
	private Object sub_jack_;

	/**
	 * @param sub_jack ２つ目の端子
	 */
	public void setSubJack(Object sub_jack) {
		this.sub_jack_ = sub_jack;
	}

	/**
	 * @return　Object this.sub_jack_
	 */
	public Object getSubjack() {
		return this.sub_jack_;
	}

	@Override
	public void playMusic() {
		super.playMusic();
		this.sub_jack_ = "now playing (sub_jack)";
	}
}
