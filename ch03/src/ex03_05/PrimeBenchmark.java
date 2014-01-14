package ex03_05;

import java.util.Arrays;

/**
 * 3.5 素数計算に要する時間を計測するベンチマーククラス
 */
public class PrimeBenchmark extends Benchmark {

	private static final int MAX = 1000000;
	
	@Override
	public void benchmark() {
		boolean[] isPrime = new boolean[MAX];
		Arrays.fill(isPrime, true); // 最初はすべてtrue
		for (int i = 2; i < MAX; i++) { //素数判定なので2から
			if (isPrime[i]) {
				//System.out.println(i); // 表示すると遅い
				for (int j = i + i; j < MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	/**
	 * @param args　counts
	 */
	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		long time = new PrimeBenchmark().repeat(count);
		System.out.println(count + " PrimeBenchmark(s) in " + time + " ns.");
	}

}
