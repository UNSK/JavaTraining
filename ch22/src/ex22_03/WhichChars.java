package ex22_03;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;


public class WhichChars {
    private Map<Byte, BitSet> used = new HashMap<>();
    
    public WhichChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            byte upper = (byte) (c >> 8);
            char lower = (char) (c & 0x00ff);
            BitSet bitSet;
            if (used.containsKey(upper)) {
                bitSet = used.get(upper);  
            } else {
                bitSet = new BitSet();
            }
            bitSet.set(lower);
            used.put(upper, bitSet);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder desc = new StringBuilder();
        desc.append("[");
        for (Map.Entry<Byte, BitSet> e : used.entrySet()) {
            BitSet b = e.getValue();
            for (int i = b.nextSetBit(0); i >= 0; i = b.nextSetBit(++i)) {
                byte[] bytes = {e.getKey(), (byte) i };
                try {
                    desc.append(new String(bytes, "UTF-16"));
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return desc + "]";
    }
    
    public static void main(String[] args) {
        String str = "春はあけぼの　夏は夜 (´・ω・`)　the quick brown fox jumps over the lazy dog.";
        WhichChars whichChars = new WhichChars(str);
        System.out.println(whichChars);
    }
}
