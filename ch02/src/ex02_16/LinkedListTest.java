package ex02_16;

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

}
