package ex22_02;

import java.util.HashSet;
import java.util.Set;

public class WhichChars {
    private Set<Character> used = new HashSet<>();
    
    public WhichChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            used.add(str.charAt(i));
        }
    }
    
    @Override
    public String toString() {
        String desc = "[";
        for (char c : used) {
            desc += c;
        }
        return desc + "]";
    }
    
    public static void main(String[] args) {
        String str = "はるはあけぼの　(´・ω・`)　the brown fox jumps...";
        WhichChars whichChars = new WhichChars(str);
        System.out.println(whichChars);
    }
}
