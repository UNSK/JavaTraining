package ex01_04;

public class Square {
	static final int MAX = 100;

	public static void main(String[] args) {
		int num = 1;
		System.out.println("値が100以下の平方表");
		for (int i = 1; num < MAX; i++) {
			num = i * i;
			System.out.println(num);
		}
	}

}
