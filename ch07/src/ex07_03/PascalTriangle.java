package ex07_03;

/**
 * 課題7.3 パスカルの三角形
 */
public class PascalTriangle {
	private int[][] triangle;

	/**
	 *  make Pascal's triangle.
	 *  @param depth of the triangle
	 */
	public void makeTrianle(int depth) {
		triangle = new int[depth][];
		for (int i = 0; i < depth; i++) {
			triangle[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				if ((j == 0) || (j == i)) {
					triangle[i][j] = 1; 
				} else {
					triangle[i][j] = 
							triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
			}
		}
	}
	
	/** display the triangle */
	public void disp() {
		String space = "   ";
		
		for (int i = 0; i < triangle.length; i++) {
			String dispSpace = "";
			for (int k = 0; k < triangle.length - (i + 1); k++) {
				dispSpace += space;
			}
			System.out.printf("%s", dispSpace);
			for (int j = 0; j < triangle[i].length; j++) {
				System.out.printf("%5d ", triangle[i][j]);
			}
			System.out.printf("%n");
		}
	} 
	
	/**
	 * Main method.
	 * @param args arguments
	 */
	public static void main(String[] args) {
		int depth = 12;
		PascalTriangle test = new PascalTriangle();
		test.makeTrianle(depth);
		test.disp();
	}

}
