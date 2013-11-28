/**
 * 
 */
package ex01_15;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link MyRevisedLookup}クラスのテストコード
 */
public class MyRevisedLookupTest {
	private MyRevisedLookup table;
	
	@Before
	public void setUp() {
		table = new MyRevisedLookup();
		table.addName("one");
		table.addName("three");
		table.addValue(1);
		table.addValue(3);
	}
	
	@Test
	public void findTest() {
		assertEquals(1, table.find("one"));
		assertEquals(3, table.find("three"));
		assertNull(table.find("two"));
	}
	
	@Test
	public void addTest() {
		assertTrue(table.add("two", 2));
		assertEquals(2, table.find("two"));
		assertFalse(table.add("two", 2)); //同じ名前には追加できない
	}
	
	@Test
	public void removeTest() {
		assertTrue(table.remove("one"));
		assertNull(table.find("one"));
		assertFalse(table.remove("Two")); 
	}
}
