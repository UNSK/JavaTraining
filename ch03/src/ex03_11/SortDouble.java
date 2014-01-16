package ex03_11;

/**
 * 3.11 doubleの値の配列をソートし、SortMetricsに検査結果を保存する
 * セキュリティホール：検査回数がintの範囲を超えてしまうことがあるかもしれない。
 * 				二回目のsortメソッドが呼ばれるとmetricsを上書きしてしまう。
 */
public abstract class SortDouble {
	/** ソート対象 */
	private double[] values;
	/** メトリクス */
	private final SortMetrics curMetrics = new SortMetrics();
	/** セキュリティホール対策にsortメソッドが一度しか呼ばれないように制限するためのフラグ */
	private static boolean isCalled = false;
	
	/**
	 * 全ソートするために呼び出される
	 * @param data ソート対象
	 * @return　メトリクス
	 */
	public final SortMetrics sort(double[] data) {
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
	protected final double probe(int i) {
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
		double d1 = values[i];
		double d2 = values[j];
		if (d1 == d2) {
			return 0;
		} else {
			return (d1 < d2 ? -1 : 1);
		}
	}
	
	/**
	 * 要素の交換
	 * @param i index
	 * @param j index 
	 */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp; 
	}
	
	/**
	 * 拡張したクラスが実装するソート本体
	 */
	protected abstract void doSort();
}
