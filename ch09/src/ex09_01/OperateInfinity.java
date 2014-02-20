package ex09_01;

/**
 * 課題9.1 2つの無限大のオペランドに対して演算を行い、結果を表示する
 */
public class OperateInfinity {

	public static void main(String[] args) {
		double x = Double.POSITIVE_INFINITY;
		double y = Double.POSITIVE_INFINITY;
		
		System.out.println("x and y are both positive infinity.");
		System.out.println("x+y = " + (x+y));
		System.out.println("x-y = " + (x-y));
		System.out.println("x*y = " + (x*y));
		System.out.println("x/y = " + (x/y));
		
		System.out.println();
		
		y = -y;
		System.out.println("x is a positive infinity and y is a negative.");
		System.out.println("x+y = " + (x+y));
		System.out.println("x-y = " + (x-y));
		System.out.println("x*y = " + (x*y));
		System.out.println("x/y = " + (x/y));
	}

}
