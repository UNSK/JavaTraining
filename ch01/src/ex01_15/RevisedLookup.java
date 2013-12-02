package ex01_15;

/**
 * {@link Lookup}にテーブルから追加、削除を加えたインターフェース
 */
public interface RevisedLookup extends Lookup {
	/**
	 * @param name 追加したい名前
	 * @param value 追加したい値
	 * @return 成功するとtrue，失敗するとfalseを返す
	 */
	boolean add(String name, Object value);
	
	/**
	 * @param name 削除したい名前
	 * @return 成功するとtrue，失敗するとfalseを返す
	 */
	boolean remove(String name);
}
