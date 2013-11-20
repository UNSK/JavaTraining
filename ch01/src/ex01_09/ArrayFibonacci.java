package ex01_09;

public class ArrayFibonacci {
	public static final int kMaxIndex = 9;
	/** 値が50未満のフィボナッチ数列を表示する. */
	public static void main(final String[] args) {
		int lo = 1;
		int hi = 1;
		int[] arrayFibonacci = new int[kMaxIndex];
		
		arrayFibonacci[0] = lo;
		for (int i = 1; i < kMaxIndex; i++) {
			arrayFibonacci[i] = hi;
			hi = lo + hi;	// 新しいhi
			lo = hi - lo;	/* 新しいloは、（合計 - 古いlo）
							       すなわち、古いhi */
		}
		
		for (int fib : arrayFibonacci) { // 拡張for文
			System.out.println(fib);
		}
 	}
}

