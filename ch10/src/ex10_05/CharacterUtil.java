package ex10_05;

/**
 * 課題10.5 2つのcharを引数に取り、それらの文字と文字間の文字を表示するメソッドの実装
 */
public class CharacterUtil {

	public static void printBetween(char c1, char c2) {
		if (c1 > c2) {
			char tmp = c1;
			c1 = c2;
			c2 = tmp;
		}
		for (char c = c1; c <= c2; c++) {
			System.out.print(c);
		}
	}
	
	public static void main(String[] args) {
		printBetween(':', '}');
	}
}
