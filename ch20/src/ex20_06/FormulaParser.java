package ex20_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class FormulaParser {
    
    public void parseFormula(Reader source, HashMap<String, Double> map) throws IOException {
        StreamTokenizer in = new StreamTokenizer(source);
        String key;
        char operand;
        double value;
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD) {
                key = in.sval;
                char c = (char) in.nextToken();
                if (c == '=' || c == '-' || c == '+') {
                    operand = c;
                    if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                        value = in.nval;
                        assign(map, key, operand, value);
                        continue;
                    }
                }
            } 
            throw new IllegalArgumentException();
        }
    }
    
    private void assign(HashMap<String, Double> map, String key, char op, double value) {
        double oldValue = 0;
        if (map.containsKey(key)) {
            oldValue = map.get(key);
        }
        switch (op) {
        case '=':
            map.put(key, value);
            break;
        case '+':
            map.put(key, oldValue + value);
            break;
        case '-':
            map.put(key, oldValue - value);
            break;
        default:
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws IOException {
        FormulaParser parser = new FormulaParser();
        HashMap<String, Double> map = new HashMap<>();
        FileReader reader = new FileReader("../ch20/src/ex20_06/test.txt");
        
        parser.parseFormula(reader, map);
        
        for (Map.Entry<String, Double> e : map.entrySet()) {
            System.out.printf("%5s = %.2f%n", e.getKey(), e.getValue());
        }
    }

}
