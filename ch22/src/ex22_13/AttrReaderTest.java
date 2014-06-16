package ex22_13;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Test;

public class AttrReaderTest {
    Reader source;
    
    @After
    public void tearDown() throws IOException {
        source.close();
    }

    @Test(expected = IOException.class)
    public void readFailTest1() throws IOException {
        source = new StringReader("foo=bar=blah\n");
        AttrReader.read(source);
    }
    
    @Test(expected = IOException.class)
    public void readFailTest2() throws IOException {
        source = new StringReader("=blah\n");
        AttrReader.read(source);
    }
    
    @Test(expected = IOException.class)
    public void readFailTest3() throws IOException {
        source = new StringReader("foo=\n");
        AttrReader.read(source);
    }
    
    @Test
    public void readSuccessTest() throws IOException {
        source = new StringReader("foo=bar\nhoge=fuga\n");
        Attributed attrs = AttrReader.read(source);
        assertThat(attrs.find("foo").getValue(), is("bar"));
        assertThat(attrs.find("hoge").getValue(), is("fuga"));
    }

}
