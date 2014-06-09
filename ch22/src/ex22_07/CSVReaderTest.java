package ex22_07;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {

    FileReader source;
    
    @Before
    public void setUp() throws Exception {
        source = new FileReader(new File("../ch22/src/ex22_07/test.csv"));
    }
    
    @After
    public void tearDown() throws IOException {
        source.close();
    }
    
    @Test
    public void readCSVTest1() throws IOException {
        List<String[]> list = CSVReader.readCSVTable(source);
        assertTrue(list.stream().allMatch(s -> s.length == 4));
    }

    @Test
    public void readCSVTestMin() throws IOException {
        List<String[]> list = CSVReader.readCSVTable(source, 1);
        assertTrue(list.stream().allMatch(s -> s.length == 1));
        String[] expecteds = {"00"};
        assertArrayEquals(expecteds, list.get(0)); 
    }
    
    @Test
    public void readCSVTestMax() throws IOException {
        List<String[]> list = CSVReader.readCSVTable(source, 8);
        list.forEach(s -> { 
            List<String> l = Arrays.asList(s);
            System.out.println(l.stream().collect(Collectors.joining("|")));
        });
        assertTrue(list.stream().allMatch(s -> s.length == 8));
        String[] expecteds = {"00", "01", "02", "03", "04", "05", "06", "07"};
        assertArrayEquals(expecteds, list.get(0));
    }
    
    @Test(expected = IOException.class)
    public void readCSVFailTest() throws IOException {
        CSVReader.readCSVTable(source, 10);
    }

}
