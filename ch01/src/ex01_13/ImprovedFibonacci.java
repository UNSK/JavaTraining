package ex01_13;

public class ImprovedFibonacci {

	static final int kMaxIndex = 9;
	
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;
		
		System.out.printf("9: %d%n", lo);
		for (int i = kMaxIndex; i >= 2; i--) {
			if (hi % 2 == 0) {
				mark = " *";
			} else {
				mark = "";
			}
			System.out.printf("%d: %d%s%n", (i - 1), hi, mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}