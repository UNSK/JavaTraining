package ex12_01;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class LinkedListTest {

	@Test
	public void getListLengthTest() {
		Object object = new Object();
		LinkedList list1 = new LinkedList(object, null);
		LinkedList list2 = new LinkedList(object, null);
		LinkedList list3 = new LinkedList(object, null);
		LinkedList list4 = new LinkedList(object, null);
		LinkedList.makeLinkedList(list1, list2, list3, list4);
		
		assertThat(list1.getListLength(), is(4));
		assertThat(list2.getListLength(), is(3));
		assertThat(list3.getListLength(), is(2));
		assertThat(list4.getListLength(), is(1));
	}

	@Test
	public void findTest() {
		LinkedList list1 = new LinkedList("foo", null);
		LinkedList list2 = new LinkedList("bar", null);
		
		LinkedList.makeLinkedList(list1, list2);
		
		try {
			assertThat(list1.find("bar"), is(list2));
		} catch (ObjectNotFoundException e) {
			fail(e.toString());
		}
	}
	
	@Test (expected = ObjectNotFoundException.class)
	public void findFailTest() throws ObjectNotFoundException {
		LinkedList list1 = new LinkedList("foobar", null);
		list1.find("hoge");
	}
}
