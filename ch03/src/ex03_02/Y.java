package ex03_02;

public class Y extends X {
	protected int yMask = 0xff00;
	
	public Y() {
		System.out.printf("Yコンストラクタ実行前:\t%4x\t%4x\t%4x%n", xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("Yコンストラクタ実行後：\t%4x\t%4x\t%4x%n", xMask, yMask, fullMask);
	}
	
	/** Main method */
	public static void main(String[] args) {
		System.out.printf("Yインスタンス作成前:\t%4x\t%4x\t%4x%n", 0, 0, 0);
		Y y = new Y();
		System.out.printf("Yインスタンス作成後:\t%4x\t%4x\t%4x%n", y.xMask, y.yMask, y.fullMask);
	}
}
