package ex13_02;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
 *
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

}
