package ex13_03;

import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * count region in a String
     * @param str to be checked
     * @param other count string region
     * @return count
     */
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
    
    /**
     * pull out all the delimit Strings
     * @param from input String
     * @param start delimited by
     * @param end delimited to end
     * @return array of String
     */
    public static String[] delimitedString(
            String from, char start, char end) {

        List<String> strList = new ArrayList<>();
        StringBuilder str = new StringBuilder(from);
        int startPos, endPos;
        while ((startPos = str.indexOf((String.valueOf(start)))) != -1) {
            if((endPos = str.indexOf((String.valueOf(end)))) == -1) {
                strList.add(str.substring(startPos));
                break;
            } else if (startPos > endPos) {
                break;
            }
            strList.add(str.substring(startPos, endPos + 1));
            str.delete(0, endPos + 1);
        }
        return strList.toArray(new String[0]);       
    }
}
