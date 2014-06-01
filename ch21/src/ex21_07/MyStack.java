package ex21_07;

import java.util.EmptyStackException;
import java.util.List;
import java.util.ArrayList;

public class MyStack<E> {
	private List<E> list = new ArrayList<>();
	
	public boolean empty() {
		return list.isEmpty();
	}
	
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return list.get(0);
	}
	
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		E ret = list.get(0);
		list.remove(0);
		return ret;
	}
	
	public E push(E item) {
		list.add(0, item);
		return item;
	}
	
	public int search(Object o) {
		int ret = list.indexOf(o);
		return ret == -1 ? -1 : ret + 1;
	}
}
