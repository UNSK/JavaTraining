package ex22_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ScannerTokenizer {
    
    private static final String LINE_SEPARATOR_PATTERN = 
            "\r\n|\n\r\u2028\u2029\u0085";
    
    public static List<String> readWithoutComment(Readable source) {
        Scanner in = new Scanner(source);
        in.useDelimiter("#.*|" + LINE_SEPARATOR_PATTERN);
        
        List<String> list = new ArrayList<>();
        
        while (in.hasNext()) {
            list.add(in.next());
        }
        
        return list;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        FileReader source = 
                new FileReader(new File("../ch22/src/ex22_09/test.py"));
        List<String> list = 
                ScannerTokenizer.readWithoutComment(source);
        
        list.stream().forEach(System.out::println);
    }

}
