package ex03_11;

/**
 *
 */
public class SimpleSortDouble extends SortDouble {

	private boolean flag = false;
	
	@Override
	protected void doSort() {
		double[] cheatData = {0};
		selectionSort();
		/* 
		 * 以下の様にソート後に、正しくないデータを引数に持つSortDoble.sortが呼ばれると
		 * 容易にmetricsを改変できる
		 */
		if (!flag) {
			flag = true;
			super.sort(cheatData);
		}
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
