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
	public void add(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String name) {
		// TODO Auto-generated method stub

	}

}
