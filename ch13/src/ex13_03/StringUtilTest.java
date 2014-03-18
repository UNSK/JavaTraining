package ex13_03;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
 * Test code for StringUtil
 */
public class StringUtilTest {

    @Test
    public void countCharTest() {
        assertThat(StringUtil.countChar("abbbc", 'b'), is(3));
        assertThat(StringUtil.countChar("abc", 'x'), is(0));
        assertThat(StringUtil.countChar("aaaaa", 'a'), is(5));
    }
    
    @Test
    public void countMachedRegionTest() {
        assertThat(StringUtil.countMachedRegion("abcabcab", "abc"), is(2));
        assertThat(StringUtil.countMachedRegion("oooooo", "oo"), is(5));
        assertThat(StringUtil.countMachedRegion("abcabcabc", "xyz"), is(0));
    }
    
    
    @Test
    public void delimitedStringTest() {
        String[] case1 = StringUtil.delimitedString("aaa<bbb>ccc<ddd>eeee", '<', '>');
        assertThat(case1.length, is(2));
        assertThat(case1[0], is("<bbb>"));
        assertThat(case1[1], is("<ddd>"));
        
        String[] case2 = StringUtil.delimitedString("foobar", '#', '%');
        assertThat(case2.length, is(0));
        
        String[] case3 = StringUtil.delimitedString("aaa><aaa", '<', '>');
        assertThat(case3.length, is(0));
        
        String[] case4 = StringUtil.delimitedString("low<high", '<', '>');
        assertThat(case4.length, is(1));
        assertThat(case4[0], is("<high"));
    }

}
