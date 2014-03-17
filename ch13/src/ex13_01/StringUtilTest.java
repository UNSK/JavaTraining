package ex13_01;

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

}
