package ex03_12;

/**
 *
 */
public class SimpleSort extends SortHarness {
	
	@Override
	protected void doSort() {
		selectionSort();
	}
	
	private void selectionSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++) {
				if (compare(i, j) > 0) {
					swap(i, j);
				}
			}
		}
	}

}
