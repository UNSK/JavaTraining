package ex03_11;

/**
 *
 */
public class TestSort {
	static double[] testData = {
		5.4, 2.001, 2.43, 6.77, 1.12
	};
	
	public static void main(String[] args) {
		SortDouble sort = new SimpleSortDouble();
		SortMetrics metrics = sort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (double value : testData) {
			System.out.println(value);
		}
	}
}
