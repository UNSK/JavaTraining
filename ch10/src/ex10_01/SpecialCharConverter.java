package ex10_01;

public class SpecialCharConverter {
	
	public static String convert(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '\n') {
				result += "\\n";
			} else if (c == '\t') {
				result += "\\t";
			} else if (c == '\b') {
				result += "\\b";
			} else if (c == '\r') {
				result += "\\r";
			} else if (c == '\f') {
				result += "\\f";
			} else if (c == '\\') {
				result += "\\\\";
			} else if (c == '\'') {
				result += "\\'";
			} else if (c == '\"') {
				result += "\\\"";
			} else {
				result += c;
			}
		}
		return result;
	}
}
