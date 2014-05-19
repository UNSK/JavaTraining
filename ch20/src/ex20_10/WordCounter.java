package ex20_10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounter {

    public Map<String, Integer> countWord(File file) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        StreamTokenizer in = new StreamTokenizer(new FileReader(file));
        in.whitespaceChars(46, 46); // period
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD) {
                if (map.containsKey(in.sval)) {
                    map.put(in.sval, map.get(in.sval) + 1);
                } else {
                    map.put(in.sval, 1);
                }
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        WordCounter counter = new WordCounter();
        File file = new File("../ch20/src/ex20_10/alice.txt");
        Map<String, Integer> map = counter.countWord(file);
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Entry<String, Integer> e : entries) {
            System.out.printf("%12s : %d%n", e.getKey(), e.getValue());
        }
    }
}
