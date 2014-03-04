package ex11_02;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 *
 */
public class AttrTest {

    @Test
    public void test() {
        Attr<Integer> intAttr = new Attr<>("one", 1);
        assertThat(intAttr.getName(), is("one"));
        assertThat(intAttr.getValue(), is(1));
        
        assertThat(intAttr.setValue(2), is(1));
        assertThat(intAttr.getValue(), is(2));
    }

}
