package ex22_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.io.StreamTokenizer.*;

public class CSVReader {
    public static List<String[]> readCSVTable(Reader source) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(source);
        tokenizer.resetSyntax();
        tokenizer.wordChars(20, 126); // almost ascii char 
        tokenizer.whitespaceChars(',', ',');
        tokenizer.eolIsSignificant(true);
        
        List<String[]> list = new ArrayList<>();
        List<String> subList = new ArrayList<>();
        
        while (tokenizer.nextToken() != TT_EOF) {
            switch (tokenizer.ttype) {
            case TT_WORD:
                subList.add(tokenizer.sval);
                break;
            case TT_EOL:
                list.add(subList.toArray(new String[0]));
                subList = new ArrayList<>();
            default:
               //nop
            }
        }
        return list;
    }
    
    public static void main(String[] args) throws IOException {
        FileReader source = new FileReader(new File("../ch22/src/ex22_10/test.csv"));
        List<String[]> list = readCSVTable(source);
        
        list.forEach(s -> { 
            List<String> l = Arrays.asList(s);
            System.out.println(l.stream().collect(Collectors.joining("|")));
        });
    }
}
