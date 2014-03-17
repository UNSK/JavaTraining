package ex13_02;

public class StringUtil {
    
    /**
     * count character in a String
     * @param str to be searched
     * @param ch count character
     * @return count
     */
    public static int countChar(String str, char ch) {
       int count = 0;
       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == ch) {
               count++;
           }
       }
       return count;
    }
    
    public static int countMachedRegion(String str, String other) {
        int count = 0;
        if (str.length() < other.length()) {
            return 0;
        }
        for (int i = 0; i < str.length() - other.length() + 1; i++) {
            if (str.regionMatches(i, other, 0, other.length())) {
               count++; 
            }
        }
        return count;
    }
}
