package ex22_14;

import java.util.StringTokenizer;

public class FPTokenizer {

    /**
     * @throws NullPointerException
     * @throws NumberFormatException
     */
    public double sumStr(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        
        StringTokenizer tokens = new StringTokenizer(str, " ");
        double ret = 0.0;
        while (tokens.hasMoreTokens()) {
            ret += new Double(tokens.nextToken());
        }
        return ret;
    }
    
    public static void main(String[] args) {
        FPTokenizer tokenizer = new FPTokenizer();
        String str = "0.1 1.1 3.141592 100";
        System.out.println(tokenizer.sumStr(str));
    }

}
