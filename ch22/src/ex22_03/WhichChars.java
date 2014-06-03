package ex22_03;

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
//        String desc = "[";
        StringBuilder desc = new StringBuilder();
        desc.append("[");
//        used.forEach((k, v) -> {
//            for (int i = v.nextSetBit(0); i >=0; v.nextSetBit(++i)) {
//                byte[] bytes = {k, (byte) i};
//                desc.append(bytes);
//            }
        // });
        for (Map.Entry<Byte, BitSet> e : used.entrySet()) {
            BitSet b = e.getValue();
            for (int i = b.nextSetBit(0); i >= 0; i = b.nextSetBit(++i)) {
                byte[] bytes = {e.getKey(), (byte) i };
                desc.append(new String(bytes));
            }
        }
        return desc + "]";
    }
    
    public static void main(String[] args) {
        String str = "はるはあけぼの　(´・ω・`)　the brown fox jumps...";
        WhichChars whichChars = new WhichChars(str);
        System.out.println(whichChars);
    }
}
