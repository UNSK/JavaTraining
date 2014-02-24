package ex10_04;

/**
 * 課題9.2　ビット操作演算子のみで渡されたintの1の数を求めるプログラムの作成
 * 課題10.4 countShiftをwhileで書き換え
 */
public class BitCount {

	/** Shiftして1か判定 */
	public static int countShift(int num) {
		int count = 0;
		//for (int i = 0; i < Integer.SIZE; i++) {
		//	count += (num >> i) & 1;
		//}
		
		/* Integer.SIZEは正数なのでdo-whileでも書くことができる　*/
		int i = 0;
		do {
			count += (num >> i) & 1;
			i++;
		} while (i < Integer.SIZE);
		return count;
	}
	
	/** 最下位ビットを消していく */
	public static int countLeast(int num) {
		int count = 0;
		while (num != 0) {
			num &= num - 1;
			count++;
		}
		return count;
	}
	
	/** ネットで発見 　二分探索の様にして1を足していく*/
	public static int awesomeCount(int num) {
		num = (num & 0x55555555) + ((num & 0xAAAAAAAA) >> 1);
		num = (num & 0x33333333) + ((num & 0xCCCCCCCC) >> 2);
		num = (num & 0x0F0F0F0F) + ((num & 0xF0F0F0F0) >> 4);
		num = (num & 0x00FF00FF) + ((num & 0xFF00FF00) >> 8);
		num = (num & 0x0000FFFF) + ((num & 0xFFFF0000) >> 16);
		return num;
	}
	
	public static void main(String[] args) {
		int input = 0xf0f0f;
		System.out.println(countShift(input));
		System.out.println(countLeast(input));
		System.out.println(awesomeCount(input));
	}

}
