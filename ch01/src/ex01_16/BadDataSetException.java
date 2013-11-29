package ex01_16;

/**
 *
 */

@SuppressWarnings("serial")
public class BadDataSetException extends Exception {
	private String file_name;
	private Exception exception;
	
	/**
	 * コンストラクタ
	 * @param name データの集まりの名前
	 * @param e 問題を通知している例外
	 */
	public BadDataSetException(String name, Exception e) {
		this.file_name = name;
		this.exception = e;
	}
}
