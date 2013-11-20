package ex01_10;

public class MarkEven {
	/**
	 * 偶数かどうかを格納する変数
	 */
	private boolean isEven_;
	/**
	 * getter
	 * @return boolean 偶数かどうか
	 */
	public boolean isEven() {
		return isEven_;
	}
	/**
	 * 数字が偶数ならisEven_を真にする
	 * @param num 数字
	 */
	public void checkEven(int num) {
		if (num % 2 == 0) { 
			this.isEven_ = true;
		} else {
			this.isEven_ = false;
		}
	}
}
