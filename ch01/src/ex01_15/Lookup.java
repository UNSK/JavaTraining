package ex01_15;

/**
 * 値の集合から値を探すインターフェース
 */
public interface Lookup {
	/** 
	 * 値を探すメソッド
	 * @param name 探したい値
	 * @return nameと関連付けされた値、なければnull
	 */
	Object find(String name);
}
