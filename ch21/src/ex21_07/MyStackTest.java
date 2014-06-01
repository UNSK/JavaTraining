package ex21_07;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

	private MyStack<Integer> stack;
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<>();
	}

	@Test
	public void emptyTest() {
		assertTrue(stack.empty());
		stack.push(1);
		assertFalse(stack.empty());
	}
	
	@Test
	public void peekTest() {
		stack.push(0);
		stack.push(1);
		assertThat(stack.peek(), is(1));
		assertThat(stack.peek(), is(1));
	}

	@Test
	public void popTest() {
		stack.push(0);
		stack.push(1);
		assertThat(stack.pop(), is(1));
		assertThat(stack.pop(), is(0));
	}
	
	@Test
	public void searchTest() {
		stack.push(0);
		stack.push(1);
		assertThat(stack.search(0), is(2));
		assertThat(stack.search(5),	is(-1));
	}
}
