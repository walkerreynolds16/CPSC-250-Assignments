package Assignment5;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {

	private List<T> list = new LinkedList<T>();

	public void enqueue(T value) {
		list.add(value);
	}

	public T dequeue() {
		return list.remove(0);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public T peek() {
		T item = list.remove(0);
		list.add(0, item);
		return item;
	}

	@Override
	public String toString() {
		return list.toString();
	}
}
