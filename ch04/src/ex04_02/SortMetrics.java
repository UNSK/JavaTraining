package ex04_02;

/**
 *　3.11　ソートの検査、交換、比較の回数を保持するクラス
 */
public class SortMetrics implements Cloneable {
	public long probeCnt, CompareCnt, swapCnt;
	
	public void init() {
		probeCnt = CompareCnt = swapCnt = 0;
	}
	
	@Override
	public String toString() {
		return probeCnt + " probes "
				+ CompareCnt + " compares "
				+ swapCnt + " swaps ";
	}
	
	@Override
	public SortMetrics clone() {
		try {
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
