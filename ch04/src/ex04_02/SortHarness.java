package ex04_02;

/**
 * 4.2 練習問題3.12をインターフェースを用いて書き直す
 */
public interface SortHarness {
	
	/**
	 * 全ソートするために呼び出される
	 * @param data ソート対象
	 * @return　メトリクス
	 */
	SortMetrics sort(Object[] data);
	
	/**
	 * 要素を調べるため
	 * @param i　index
	 * @return 要素の値
	 */
	Object probe(int i);
	
	/**
	 * 要素を比較する
	 * @param i　index
	 * @param j index
	 * @return 比較結果、等しければ0。 もしくは(i < j ? -1 : 1)
	 */
	int compare(int i, int j);
	
	/**
	 * 要素の交換
	 * @param i index
	 * @param j index 
	 */
	void swap(int i, int j);
}
