package kar.ds.linkedlist;

import java.lang.reflect.Array;
import java.util.List;

public class SingleLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int noOfNodes = 0;

	public SingleLinkedList(){
	}
	
	public SingleLinkedList(List<T> dataList) {
		for(T data : dataList)
			insert(data);
	}
	
	public SingleLinkedList(T[] dataArray) {
		for(T data : dataArray)
			insert(data);
	}
	
	public boolean isEmpty() {
		return noOfNodes == 0 && head == null && tail == null ? true : false;
	}
	
	private Node<T> getNodeAt(int index) {
		if(index < 0 || isEmpty() || index >= noOfNodes)
			return null;
		
		if(index == 0)
			return head;
		
		if(index == noOfNodes - 1)
			return tail;
		
		int currentIndex = 0;
		Node<T> currentNode = head;
		while(currentIndex != index) {
			currentIndex++;
			currentNode = currentNode.nextNode;
		}
		return currentNode;
	}
	
	public void insert(T data) {
		if(isEmpty()) {
			head = tail = new Node<T>(null, data, null);
		}else {
			Node<T> lastNode = tail;
			Node<T> newNode = new Node<T>(null, data, null);
			tail = lastNode.nextNode = newNode;
		}
		noOfNodes++;
	}
	
	public boolean insertAt(int index, T data) {
		boolean isSuccess = false;
		if(isEmpty()) {
			head = tail = new Node<T>(null, data, null);
			isSuccess = true;
		}else if(index == 0) {
			Node<T> newNode = new Node<T>(null, data, head);
			head = newNode;
			isSuccess = true;
		}else {
			Node<T> nodeAtGivenIndex = getNodeAt(index);
			if(nodeAtGivenIndex != null) {
				Node<T> nodeAtPreviousIndex = getNodeAt(index - 1);
				Node<T> newNode = new Node<T>(null, data, nodeAtGivenIndex);
				nodeAtPreviousIndex.nextNode = newNode;
				isSuccess = true;
			}
		}
		
		if(isSuccess) {
			noOfNodes++;
		}
		return isSuccess;
	}
	
	public boolean update(T data, int index) {
		if(isEmpty())
			return false;
		
		boolean isSuccess = false;
		Node<T> nodeAtGivenIndex = getNodeAt(index);
		if(nodeAtGivenIndex != null) {
			nodeAtGivenIndex.data = data;
			isSuccess = true;
		}
		return isSuccess;
	}
	
	public boolean delete(T data) {
		boolean isSuccess = false;
		Node<T> previousNode = null;
		Node<T> currentNode = head;
		while(currentNode != null) {
			if(data == currentNode.data) {
				previousNode.nextNode = currentNode.nextNode;
				noOfNodes--;
				isSuccess = true;
				break;
			}else {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
			}
		}
		return isSuccess;
	}
	
	public T deleteAt(int index) {
		if(isEmpty())
			return null;
		
		Node<T> nodeToDelete = getNodeAt(index);
		if(nodeToDelete != null) {
			if(nodeToDelete == head && nodeToDelete == tail) {
				head = tail = null;
			} else if(nodeToDelete == head) {
				head = head.nextNode;
			} else {
				Node<T> previousNode = getNodeAt(index - 1);
				if(nodeToDelete == tail)
					tail = previousNode;
				if(previousNode != null)
					previousNode.nextNode = nodeToDelete.nextNode;
			}
			noOfNodes--;
		}
		return nodeToDelete != null ? nodeToDelete.data : null;
	}
	
	public T getDataAt(int index) {
		T data = null;
		Node<T> node = getNodeAt(index);
		if(node != null) {
			data = node.data;
		}
		return data;
	}
	
	public int getSize() {
		return noOfNodes;
	}
	
	public T[] traverse() {
		if(isEmpty())
			return null;
		
		Node<T> currentNode = head;
		T[] out = null;
		if(currentNode != null)
			out = (T[]) Array.newInstance(currentNode.data.getClass(), noOfNodes);
		int i=0;
		while(currentNode != null) {
			out[i] = currentNode.data;
			currentNode = currentNode.nextNode;
			i++;
		}
		return out;
	}
	
	@Override
	public String toString() {
		Node<T> currentNode = head;
		String out = "";
		while(currentNode != null) {
			out = out + currentNode + " -> ";
			currentNode = currentNode.nextNode;
		}
		out = out + "NULL";
		return out;
	}
	
}
