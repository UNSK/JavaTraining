package ex21_01;

import java.io.File;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LineReader extends FilterReader {

    protected LineReader(Reader reader) {
        super(reader);
    }

    public String readLine() throws IOException {
        String eol = System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        int c = 0;
        while ((c != eol.charAt(0)) && (c != -1)) {
            c = read();
            builder.append((char) c);
        }
        if (eol.equals("\r\n")) {
            read(); //　it remain "\n" then read/discard it
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        File f = new File("../ch21/src/ex21_01/alice.txt");
        LineReader reader = new LineReader(new FileReader(f));
        List<String> list = new LinkedList<>();
        String line;
        while (reader.ready()) {
            line = reader.readLine();
            list.add(line);
        }
        reader.close();
        Collections.sort(list);
        for (String s : list) {
            System.out.print(s);
        }
    }
}