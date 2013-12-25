package ex03_02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X() {
		System.out.printf("Xコンストラクタ実行前:\t%4x\t%4x\t%4x%n", xMask, 0, fullMask);
		fullMask = xMask;
		System.out.printf("Xコンストラクタ実行後:\t%4x\t%4x\t%4x%n", xMask, 0, fullMask);
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}
}
