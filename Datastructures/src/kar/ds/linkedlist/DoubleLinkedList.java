package kar.ds.linkedlist;

import java.lang.reflect.Array;
import java.util.List;

public class DoubleLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int noOfNodes = 0;

	public DoubleLinkedList(){
	}
	
	public DoubleLinkedList(List<T> dataList) {
		for(T data : dataList)
			insert(data);
	}
	
	public DoubleLinkedList(T[] dataArray) {
		for(T data : dataArray)
			insert(data);
	}
	
	public boolean isEmpty() {
		return noOfNodes == 0 && head == null && tail == null ? true : false;
	}
	
	private void removeNode(Node<T> node) {
		if(node == head && node == tail) {
			head = tail = null;
		}else if(node == head) {
			head = node.nextNode;
			if(head != null)
				head.previousNode = null;
		}else if(node == tail) {
			tail = tail.previousNode;
			tail.nextNode = null;
		}else {
			Node<T> leftNode = node.previousNode;
			Node<T> rightNode = node.nextNode;
			//if(leftNode != null) {
				leftNode.nextNode = rightNode;
			//}
			if(rightNode != null) {
				rightNode.previousNode = leftNode;
			}
			//node.leftNode.rightNode = node.rightNode;
			//node.rightNode.leftNode = node.leftNode;
		}
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
			head = tail = new Node<>(null, data, null);
		}else {
			Node<T> lastNode = tail;
			Node<T> newLastNode = new Node<T>(lastNode, data, null);
			tail = lastNode.nextNode = newLastNode;
		}
		noOfNodes++;
	}
	
	public boolean insertAt(int index, T data) {
		boolean isSuccess = false;
		if(isEmpty()) {
			head = tail = new Node<T>(null, data, null);
			isSuccess = true;
		}else if(index == 0){
			Node<T> newNode = new Node<T>(null, data, head);
			head.previousNode = newNode;
			head = newNode;
			isSuccess = true;
		}else {
			Node<T> nodeAtGivenIndex = getNodeAt(index);
			if(nodeAtGivenIndex != null) {
				Node<T> nodeBeforeGivenIndex = nodeAtGivenIndex.previousNode;
				Node<T> newNodeAtGivenIndex = new Node<T>(nodeBeforeGivenIndex, data, nodeAtGivenIndex);
				if(nodeBeforeGivenIndex != null)
					nodeBeforeGivenIndex.nextNode = newNodeAtGivenIndex;
				nodeAtGivenIndex.previousNode = newNodeAtGivenIndex;
				isSuccess = true;
			}
		}
		
		if(isSuccess)
			noOfNodes++;
		
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
		Node<T> currentNode = head;
		while(currentNode != null) {
			if(data == currentNode.data) {
				removeNode(currentNode);
				noOfNodes--;
				isSuccess = true;
				break;
			}else {
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
			removeNode(nodeToDelete);
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
	
	@SuppressWarnings("unchecked")
	public T[] traverseForward() {
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
		return (T[]) out;
	}
	
	@SuppressWarnings("unchecked")
	public T[] traverseReverse() {
		if(isEmpty())
			return null;
		
		Node<T> currentNode = tail;
		T[] out = null;
		if(currentNode != null)
			out = (T[]) Array.newInstance(currentNode.data.getClass(), noOfNodes);
		int i = 0;
		while(currentNode != null) {
			out[i] = currentNode.data;
			currentNode = currentNode.previousNode;
			i++;
		}
		return (T[]) out;
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
