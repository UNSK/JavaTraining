package ex01_10;
/** 
 * 偶数要素に'*'を付けて、フィボナッチ数列の
 * 50未満の要素を表示する
 */
public class ImprovedArrayFibonacci {
	/**
	 * 配列の最大値：{@value}
	 */
	static final int kMaxIndex = 9;
	
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int[] arrayFibonacci = new int[kMaxIndex];
		MarkEven[] mark = new MarkEven[kMaxIndex];
		
		/* calculate fibonacci */
		arrayFibonacci[0] = lo;
		for (int i = 1; i < kMaxIndex; i++) {
			arrayFibonacci[i] = hi; 
			hi = lo + hi;
			lo = hi - lo;
		}
		
		/* check even */
		for (int i = 0; i < kMaxIndex; i++) {
			mark[i] = new MarkEven();
			mark[i].checkEven(arrayFibonacci[i]);
		}
		
		/* print */
		for (int i = 0; i < kMaxIndex; i++) {
			System.out.print((i + 1) + ": " + arrayFibonacci[i]);
			if (mark[i].isEven()) {
				System.out.println(" *");
			} else {
				System.out.println();
			}
		}
	}
}
