package kar.ds.stack;

import kar.ds.linkedlist.SingleLinkedList;

public class Stack extends SingleLinkedList {
	
	public void push(Object data) {
		super.insert(data);
	}
	
	public Object pop() {
		return super.deleteAt(getSize() - 1);
	}
	
	public Object peek() {
		return super.getDataAt(getSize() - 1);
	}

	@Override
	public boolean insertAt(int index, Object data) {
		throw new StackException("Cannot insert at random location in the stack!");
	}

	@Override
	public boolean update(Object data, int index) {
		throw new StackException("Cannot update at random location in the stack!");
	}

	@Override
	public boolean delete(Object data) {
		throw new StackException("Cannot delete element at random location in the stack!");
	}

	@Override
	public Object deleteAt(int index) {
		throw new StackException("Cannot delete at random location in the stack!");
	}

	@Override
	public Object getDataAt(int index) {
		throw new StackException("Cannot get element at random location in the stack!");
	}

}
