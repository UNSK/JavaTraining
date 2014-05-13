package ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindWord {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("need word and file");
        }
        String match = args[0];
        LineNumberReader reader 
            = new LineNumberReader(new FileReader(args[1]));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(match)) {
                System.out.printf("%3d: %s%n", reader.getLineNumber(), line);
            }
        }
        reader.close();
    }
}
