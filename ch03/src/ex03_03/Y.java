package ex03_03;

public class Y extends X {
	protected int yMask = 0xff00;
	
	{
		/*　解答
		 *  初期化ブロックを使うことで、コンストラクタ実行前にマスクの値を設定できる。
		 */
		fullMask |= yMask;
	}
	
	public Y() {
		System.out.printf("Yコンストラクタ実行前:\t%04x\t%04x\t%04x%n", xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("Yコンストラクタ実行後：\t%04x\t%04x\t%04x%n", xMask, yMask, fullMask);
	}
	
	/** Main method */
	public static void main(String[] args) {
		System.out.printf("Yインスタンス作成前:\t%04x\t%04x\t%04x%n", 0, 0, 0);
		Y y = new Y();
		System.out.printf("Yインスタンス作成後:\t%04x\t%04x\t%04x%n", y.xMask, y.yMask, y.fullMask);
	}
}
