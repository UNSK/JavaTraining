package ex13_06;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;
import static ex13_06.StringUtil.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test code for StringUtil
 */
public class StringUtilTest {

    @Test
    public void countCharTest() {
        assertThat(countChar("abbbc", 'b'), is(3));
        assertThat(countChar("abc", 'x'), is(0));
        assertThat(countChar("aaaaa", 'a'), is(5));
    }
    
    @Test
    public void countMachedRegionTest() {
        assertThat(countMachedRegion("abcabcab", "abc"), is(2));
        assertThat(countMachedRegion("oooooo", "oo"), is(5));
        assertThat(countMachedRegion("abcabcabc", "xyz"), is(0));
    }
    
    
    @Test
    public void delimitedStringTest() {
        String[] case1 = delimitedString("aaa<bbb>ccc<ddd>eeee", '<', '>');
        assertThat(case1.length, is(2));
        assertThat(case1[0], is("<bbb>"));
        assertThat(case1[1], is("<ddd>"));
        
        String[] case2 = delimitedString("foobar", '#', '%');
        assertThat(case2.length, is(0));
        
        String[] case3 = delimitedString("aaa><aaa", '<', '>');
        assertThat(case3.length, is(0));
        
        String[] case4 = delimitedString("low<high", '<', '>');
        assertThat(case4.length, is(1));
        assertThat(case4[0], is("<high"));
    }

    @Test
    public void processTypeValuePairTest() {
        String input = "Integer 123\nBoolean false\n";
        ArrayList<Object> out = processTypeValuePair(input);
        assertThat((Integer) out.get(0), is(123));
        assertThat((Boolean) out.get(1), is(false));
    }
    
    @Test
    public void delimitNumeralTest() {
        assertThat(delimitNumeral("123"), is("123"));
        assertThat(delimitNumeral("1234"), is("1,234"));
        assertThat(delimitNumeral("12345"), is("12,345"));
        assertThat(delimitNumeral("123456"), is("123,456"));
        assertThat(delimitNumeral("1234567"), is("1,234,567"));
    }
    
    @Test
    public void delimitNumeralTest2() {
        assertThat(delimitNumeral("123", '/', 1), is("1/2/3"));
        assertThat(delimitNumeral("1234567", ',', 3), is("1,234,567"));
        assertThat(delimitNumeral("12345", '*', 10), is("12345"));
        
        try {
            delimitNumeral("123", ';', 0);
            fail();
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
}
