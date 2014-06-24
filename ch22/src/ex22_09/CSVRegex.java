package ex22_09;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class CSVRegex {
    
    private static final String RESOURCE_DIR = "../ch22/src/ex22_09/";

    public static void main(String[] args) throws IOException {
        File testLong  = new File(RESOURCE_DIR + "testLong.csv");
        File testShort = new File(RESOURCE_DIR + "testShort.csv");
        
        String greedy1       = "(.*),(.*),(.*),(.*),(.*)";
        String notGreedy1    = "(.*?),(.*?),(.*?),(.*?),(.*?)";
        String posessive1    = "(.*+),(.*+),(.*+),(.*+),(.*+)";
        String greedy2       = "([^,]*),([^,]*),([^,]*),([^,]*),([^,]*)";
        String notGreedy2    = "([^,]*?),([^,]*?),([^,]*?),([^,]*?),([^,]*?)";
        String posessive2    = "([^,]*+),([^,]*+),([^,]*+),([^,]*+),([^,]*+)";
        
        FileReader source;
        
        System.out.println("-- greedy1 --");
        System.out.println(greedy1);
        source = new FileReader(testLong);
        System.out.println("Long CSV: " + read(greedy1, source) + " nano sec");
        source = new FileReader(testShort);
        System.out.println("Short CSV: " + read(greedy1, source) + " nano sec");
        System.out.println();
        
        System.out.println("-- not greedy1 --");
        System.out.println(notGreedy1);
        source = new FileReader(testLong);
        System.out.println("Long CSV: " + read(notGreedy1, source) + " nano sec");
        source = new FileReader(testShort);
        System.out.println("Short CSV: " + read(notGreedy1, source) + " nano sec");
        System.out.println();
        
        System.out.println("-- posessive1 --");
        System.out.println(posessive1);
        source = new FileReader(testLong);
        System.out.println("Long CSV: " + read(posessive1, source) + " nano sec");
        source = new FileReader(testShort);
        System.out.println("Short CSV: " + read(posessive1, source) + " nano sec");
        System.out.println();
        
        System.out.println("-- greedy2 --");
        System.out.println(greedy2);
        source = new FileReader(testLong);
        System.out.println("Long CSV: " + read(greedy2, source) + " nano sec");
        source = new FileReader(testShort);
        System.out.println("Short CSV: " + read(greedy2, source) + " nano sec");
        System.out.println();
        
        System.out.println("-- not greedy2 --");
        System.out.println(notGreedy2);
        source = new FileReader(testLong);
        System.out.println("Long CSV: " + read(notGreedy2, source) + " nano sec");
        source = new FileReader(testShort);
        System.out.println("Short CSV: " + read(notGreedy2, source) + " nano sec");
        System.out.println();
        
        System.out.println("-- posessive2 --");
        System.out.println(posessive2);
        source = new FileReader(testLong);
        System.out.println("Long CSV: " + read(posessive2, source) + " nano sec");
        source = new FileReader(testShort);
        System.out.println("Short CSV: " + read(posessive2, source) + " nano sec");
        
        source.close();
    }
    
    /**
     * 
     * @param regex
     * @param source
     * @return elapsed time in nano sec
     */
    public static long read(String regex, Readable source) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(source);
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        long start = System.nanoTime();
        while (in.hasNextLine()) {
            in.findInLine(pattern);
            in.nextLine();
        }
        return System.nanoTime() - start;
    }

}
