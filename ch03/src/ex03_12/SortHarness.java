package ex03_12;

import ex03_11.SortMetrics;

/**
 * どのようなオブジェクト型もソートできるクラス
 */
public abstract class SortHarness {
	/** ソート対象 */
	private Object[] values;
	/** メトリクス */
	private final SortMetrics curMetrics = new SortMetrics();
	/** セキュリティホール対策にsortメソッドが一度しか呼ばれないように制限するためのフラグ */
	private static boolean isCalled = false;
	
	/**
	 * 全ソートするために呼び出される
	 * @param data ソート対象
	 * @return　メトリクス
	 */
	public final SortMetrics sort(Object[] data) {
		if (!isCalled) {
			isCalled = true;
			values = data;
			curMetrics.init();
			doSort();
		}
			return getMetrics();
	}
	
	/**
	 * @return　メトリクスのコピー
	 */
	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}
	
	/**
	 * @return　要素の数
	 */
	protected final int getDataLength() {
		return values.length;
	}
	
	/**
	 * 要素を調べるため
	 * @param i　index
	 * @return 要素の値
	 */
	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}
	
	/**
	 * 要素を比較する
	 * @param i　index
	 * @param j index
	 * @return 比較結果、等しければ0。 もしくは(i < j ? -1 : 1)
	 */
	protected final int compare(int i, int j) {
		curMetrics.CompareCnt++;
		if (values[i] instanceof Comparable
				&& values[j] instanceof Comparable) {
			Comparable o1 = (Comparable) values[i];
			Comparable o2 = (Comparable) values[j];
			return o1.compareTo(o2);
		} else { //ComparableにキャストできなかったらhashCodeで比較する
			int hash1 = values[i].hashCode();
			int hash2 = values[j].hashCode();
			if (hash1 == hash2) {
				return 0;
			} else {
				return (hash1 < hash2 ? -1 : 1);
			}
		}
	}
	
	/**
	 * 要素の交換
	 * @param i index
	 * @param j index 
	 */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp; 
	}
	
	/**
	 * 拡張したクラスが実装するソート本体
	 */
	protected abstract void doSort();
}
