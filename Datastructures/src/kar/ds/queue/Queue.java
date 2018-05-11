package kar.ds.queue;

import kar.ds.linkedlist.SingleLinkedList;
import kar.ds.queue.QueueException;

public class Queue<T> extends SingleLinkedList<T> {

	public void enqueue(T data) {
		super.insert(data);
	}
	
	public T dequeue() {
		return super.deleteAt(0);
	}
	
	public T peek() {
		return super.getDataAt(0);
	}
	
	@Override
	public void insert(T data) {
		throw new QueueException("Cannot insert into the queue!");
	}
	
	@Override
	public boolean insertAt(int index, T data) {
		throw new QueueException("Cannot insert at random location in the queue!");
	}

	@Override
	public boolean update(T data, int index) {
		throw new QueueException("Cannot update at random location in the queue!");
	}

	@Override
	public boolean delete(T data) {
		throw new QueueException("Cannot delete element at random location in the queue!");
	}

	@Override
	public T deleteAt(int index) {
		throw new QueueException("Cannot delete at random location in the queue!");
	}

	@Override
	public T getDataAt(int index) {
		throw new QueueException("Cannot get element at random location in the queue!");
	}
}
