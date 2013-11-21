package ex01_12;

public class StringsImprovedFibonacci {
	/**
	 * 配列の大きさ：{@value}
	 */
	public static final int kMaxIndex = 9;
	
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int[] arrayFibonacci = new int[kMaxIndex];
		String[] mark = new String[kMaxIndex];
		
		/* calculate fibonacci */
		arrayFibonacci[0] = lo;
		for (int i = 1; i < kMaxIndex; i++) {
			arrayFibonacci[i] = hi; 
			hi = lo + hi;
			lo = hi - lo;
		}
		
		/* check even */
		for (int i = 0; i < kMaxIndex; i++) {
			if (arrayFibonacci[i] % 2 == 0) {
				mark[i] = " *";
			} else {
				mark[i] = ""; 
			}
		}
		
		/* print */
		for (int i = 1; i < kMaxIndex; i++) {
			System.out.println((i + 1) + ": " + arrayFibonacci[i] + mark[i]);
		}
	}
}
