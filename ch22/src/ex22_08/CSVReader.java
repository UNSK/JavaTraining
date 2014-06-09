package ex22_08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVReader {
    
    public static List<String[]> readCSVTable(Readable source, int cellNum) throws IOException {
        if (cellNum < 1) {
            throw new IllegalArgumentException();
        }
        @SuppressWarnings("resource")
        Scanner in = new Scanner(source);
        List<String[]> vals = new ArrayList<String[]>();
        StringBuilder exp = new StringBuilder();
        exp.append("^");
        for (int i = 0; i < cellNum; i++) {
            exp.append("([^,]*),");
        }
        exp.deleteCharAt(exp.length() - 1); //delete comma at end
        exp.append("$");
        Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);
        while (in.hasNextLine()) {
            String line = in.findInLine(pat);
            if (line != null) {
                String[] cells = new String[cellNum];
                MatchResult match = in.match();
                for (int i = 0; i < cellNum; i++) {
                    cells[i] = match.group(i + 1); 
                }
                vals.add(cells);
                in.nextLine();
            } else {
                throw new IOException("input format error");
            }
        }
        
        IOException ex = in.ioException();
        if (ex != null) {
            throw ex;
        }
        
        return vals;
    }
}
