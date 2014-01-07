package ex03_03;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X() {
		System.out.printf("Xコンストラクタ実行前:\t%04x\t%04x\t%04x%n", xMask, 0, fullMask);
		fullMask = xMask;
		System.out.printf("Xコンストラクタ実行後:\t%04x\t%04x\t%04x%n", xMask, 0, fullMask);
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}
}
