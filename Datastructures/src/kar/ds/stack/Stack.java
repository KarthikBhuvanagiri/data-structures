package kar.ds.stack;

import kar.ds.linkedlist.SingleLinkedList;

public class Stack<T> extends SingleLinkedList<T> {
	
	public void push(T data) {
		super.insert(data);
	}
	
	public T pop() {
		return super.deleteAt(getSize() - 1);
	}
	
	public T peek() {
		return super.getDataAt(getSize() - 1);
	}

	@Override
	public void insert(T data) {
		throw new StackException("Cannot insert into the stack!");
	}
	
	@Override
	public boolean insertAt(int index, T data) {
		throw new StackException("Cannot insert at random location in the stack!");
	}

	@Override
	public boolean update(T data, int index) {
		throw new StackException("Cannot update at random location in the stack!");
	}

	@Override
	public boolean delete(T data) {
		throw new StackException("Cannot delete element at random location in the stack!");
	}

	@Override
	public T deleteAt(int index) {
		throw new StackException("Cannot delete at random location in the stack!");
	}

	@Override
	public T getDataAt(int index) {
		throw new StackException("Cannot get element at random location in the stack!");
	}

}
