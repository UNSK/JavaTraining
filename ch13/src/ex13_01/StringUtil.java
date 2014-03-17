package ex13_01;

public class StringUtil {
    
    /**
     * count character in a String
     * @param str to be checked
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
}
