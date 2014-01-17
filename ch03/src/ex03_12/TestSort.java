package ex03_12;

/**
 *
 */
public class TestSort {
	
	public static void main(String[] args) {
		Object[] stringData = {
			"delta", "bravo", "echo", "charlie", "alpha"
		};
		SortHarness sort = new SimpleSort();
		System.out.println("-- Sort String");
		SortMetrics metrics = sort.sort(stringData);
		System.out.println("Metrics: " + metrics);
		for (Object value : stringData) {
			System.out.println(value);
		}
		
		sort = new SimpleSort();
		Vehicle zero = new Vehicle("zero"); // id = 0
		Vehicle one = new Vehicle("one"); // id = 1
		Vehicle two = new Vehicle("two"); // id = 2
		Object[] vehicleData = {
				two, zero, one
		};
		System.out.println("-- Sort Vehicle");
		metrics = sort.sort(vehicleData);
		System.out.println("Metrics: " + metrics);
		for (Object value : vehicleData) {
			System.out.println(value);
		}
	}
}
