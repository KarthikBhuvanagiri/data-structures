package kar.ds.queue;

import kar.ds.linkedlist.SingleLinkedList;
import kar.ds.queue.QueueException;

public class Queue extends SingleLinkedList {

	public void enqueue(Object data) {
		super.insert(data);
	}
	
	public Object dequeue() {
		return super.deleteAt(0);
	}
	
	public Object peek() {
		return super.getDataAt(0);
	}
	
	@Override
	public void insert(Object data) {
		throw new QueueException("Cannot insert into the queue!");
	}
	
	@Override
	public boolean insertAt(int index, Object data) {
		throw new QueueException("Cannot insert at random location in the queue!");
	}

	@Override
	public boolean update(Object data, int index) {
		throw new QueueException("Cannot update at random location in the queue!");
	}

	@Override
	public boolean delete(Object data) {
		throw new QueueException("Cannot delete element at random location in the queue!");
	}

	@Override
	public Object deleteAt(int index) {
		throw new QueueException("Cannot delete at random location in the queue!");
	}

	@Override
	public Object getDataAt(int index) {
		throw new QueueException("Cannot get element at random location in the queue!");
	}
}
