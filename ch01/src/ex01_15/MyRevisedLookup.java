package ex01_15;

import java.util.ArrayList;

/**
 * {@link RevisedLookup}を実装したクラス
 */
public class MyRevisedLookup implements RevisedLookup {
	/**
	 * 名前を格納する配列
	 */
	private ArrayList<String> name_ = new ArrayList<String>();
	
	/**
	 * name_に対応する値を格納する配列
	 */
	private ArrayList<Object> value_ = new ArrayList<Object>();
	
	@Override
	public Object find(String name) {
		for (int i = 0; i < name_.size(); i++) {
			if (name_.get(i).equals(name)) {
				return value_.get(i);
			}
		}
		// 見つからなかった
		return null;
	}

	@Override
	public boolean add(String name, Object value) {
		if (this.find(name) != null) { //すでに名前が存在している
			return false;
		} else {
			name_.add(name);
			value_.add(value);
			return true;
		}
	}

	@Override
	public boolean remove(String name) {
		if (this.find(name) == null) { //名前が存在しない
			return false;
		} else {
			value_.remove(name_.indexOf(name));
			name_.remove(name);
			return true;
		}
	}
	
	/**
	 * 名前を追加するメソッド（初期設定用）
	 * @param name 追加する名前
	 */
	public void addName(String name) {
		name_.add(name);
	}
	
	/**
	 * 値を追加するメソッド（初期設定用）
	 * @param value 追加したい値
	 */
	public void addValue(Object value) {
		value_.add(value);
	}

}
