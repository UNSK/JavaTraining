package ex03_07;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * 3.7 equalsとhashCodeのテスト。テストファーストで作成
 */
public class ColorAttrTest {

	@Test
	public void equalsTest() {
		ColorAttr colorAttr1 = new ColorAttr("name", "value");
		ColorAttr colorAttr2 = new ColorAttr("name", "value");
		assertThat(colorAttr1.equals(colorAttr2), is(true));
		
		ScreenColor screenColor = new ScreenColor("value");
		colorAttr1 = new ColorAttr("name", screenColor);
		colorAttr2 = new ColorAttr("name", screenColor);
		assertThat(colorAttr1.equals(colorAttr2), is(true));
		
		colorAttr1 = new ColorAttr("hoge");
		colorAttr2 = new ColorAttr("fuga");
		assertThat(colorAttr1.equals(colorAttr2), is(false));
		
		// ColorAttrではないケース
		assertThat(colorAttr1.equals("not ColorAttr"), is(false));
	}
	
	@Test
	public void hashCodeTest() {
		ColorAttr colorAttr1 = new ColorAttr("name", "value");
		ColorAttr colorAttr2 = new ColorAttr("name", "value");
		assertThat(colorAttr1.hashCode(), is(colorAttr2.hashCode()));
		
		ScreenColor screenColor = new ScreenColor("value");
		colorAttr1 = new ColorAttr("name", screenColor);
		colorAttr2 = new ColorAttr("name", screenColor);
		assertThat(colorAttr1.hashCode(), is(colorAttr2.hashCode()));
		
		// 以下は満たす必要は無いらしい
		colorAttr1 = new ColorAttr("hoge");
		colorAttr2 = new ColorAttr("fuga");
		assertThat(colorAttr1.hashCode(), is(not(colorAttr2.hashCode())));
	}

}
