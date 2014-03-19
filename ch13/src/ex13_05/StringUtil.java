package ex13_05;

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
    
    /** pull out all the delimit Strings
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
    
    /** read line of the form "Type Value\n" and add it to an Arraylist.
     * Type is wrapper class names, and value is a type's constructor can decode.
     * @param tvp a series of the form
     * @return an ArrayList<Object>
     */
    public static ArrayList<Object> processTypeValuePair(String tvp) {
        String[] lines = tvp.split("\n");
        ArrayList<Object> retArrayList = new ArrayList<>();
        for (String str : lines) {
            String[] pair = str.split(" ");
            if (pair.length != 2) {
                throw new IllegalArgumentException();
            }
            retArrayList.add(convertToValue(pair[0], pair[1]));
        }
        return retArrayList;
    }
    
    private static Object convertToValue(String type, String value) {
        switch (type) {
        case "Byte":
            return Byte.valueOf(value);
        case "Short":
            return Short.valueOf(value);
        case "Integer":
            return Integer.valueOf(value);
        case "Long":
            return Long.valueOf(value);
        case "Float":
            return Float.valueOf(value);
        case "Double":
            return Double.valueOf(value);
        case "Character":
            return value.charAt(0);
        case "Boolean":
            return Boolean.valueOf(value);
        default:
            System.err.println("Unknown type: " + type);
            return null;
        }
    }
    
    public static String delimitNumeral(String numeral) {
        StringBuilder nBuilder = new StringBuilder(numeral);
        char delimiter = ',';
        int numOfDigit = numeral.length();
        if (numOfDigit > 3) {
            int offset = numOfDigit % 3;
            if (offset == 0) {
                offset = 3;
            }
            while (offset < numOfDigit) {
                nBuilder.insert(offset, delimiter);
                offset += 4;
                numOfDigit++;
            }
        }
        return nBuilder.toString();
    }
   
}
