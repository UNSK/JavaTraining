package ex10_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialCharConverterTest {

	@Test
	public void test() {
		String test = "\n\t\b\r\f\\\'\"";
		assertEquals("\\n\\t\\b\\r\\f\\\\\\'\\\"",
				SpecialCharConverter.convert(test));
	}

}
