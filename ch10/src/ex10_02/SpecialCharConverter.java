package ex10_02;

public class SpecialCharConverter {

	public static String convert(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '\n':
				result += "\\n";
				break;
			case '\t':
				result += "\\t";
				break;
			case '\b':
				result += "\\b";
				break;
			case '\r':
				result += "\\r";
				break;
			case '\f':
				result += "\\f";
				break;
			case '\\':
				result += "\\\\";
				break;
			case '\'':
				result += "\\'";
				break;
			case '\"':
				result += "\\\"";
				break;
			default:
				result += c;
			}
		}
		return result;
	}
}
