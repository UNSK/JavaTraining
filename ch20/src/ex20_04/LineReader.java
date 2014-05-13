package ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

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
        return builder.toString();
    }

    public static void main(String[] args) {
        LineReader reader = new LineReader(
                new StringReader("foo" + System.lineSeparator() + "bar"));
        try {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}