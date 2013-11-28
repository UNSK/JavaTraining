package ex01_15;

/**
 * {@link Lookup}にテーブルから追加、削除を加えたインターフェース
 */
public interface RevisedLookup extends Lookup {
	/**
	 * @param name 追加する値
	 */
	void add(String name);
	/**
	 * @param name 削除する値
	 */
	void remove(String name);
}
