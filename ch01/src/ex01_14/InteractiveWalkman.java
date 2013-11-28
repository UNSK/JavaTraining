package ex01_14;

/**
 * 双方向コミュニケーション機能を持つウォークマン
 * {@link TwoJacksWalkman}を拡張
 */
public class InteractiveWalkman extends TwoJacksWalkman {
	/**
	 * 会話を行うメソッド
	 */
	public void talk() {
		setJack("now talking (jack)");
		setSubJack("now talking (sub_jack)");
	}
}
