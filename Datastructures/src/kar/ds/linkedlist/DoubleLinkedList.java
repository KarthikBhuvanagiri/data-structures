package kar.ds.linkedlist;

import java.util.List;

public class DoubleLinkedList {

	private Node head;
	private Node tail;
	private int noOfNodes = 0;

	public DoubleLinkedList(){
	}
	
	public DoubleLinkedList(List dataList) {
		for(Object data : dataList)
			insert(data);
	}
	
	public DoubleLinkedList(Object[] dataArray) {
		for(Object data : dataArray)
			insert(data);
	}
	
	public boolean isEmpty() {
		return noOfNodes == 0 && head == null && tail == null ? true : false;
	}
	
	private void removeNode(Node node) {
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
			Node leftNode = node.previousNode;
			Node rightNode = node.nextNode;
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
	
	private Node getNodeAt(int index) {
		if(index < 0 || isEmpty() || index >= noOfNodes)
			return null;
		
		if(index == 0)
			return head;
		
		if(index == noOfNodes - 1)
			return tail;
		
		int currentIndex = 0;
		Node currentNode = head;
		while(currentIndex != index) {
			currentIndex++;
			currentNode = currentNode.nextNode;
		}
		return currentNode;
	}
	
	public void insert(Object data) {
		if(isEmpty()) {
			head = tail = new Node(null, data, null);
		}else {
			Node lastNode = tail;
			Node newLastNode = new Node(lastNode, data, null);
			tail = lastNode.nextNode = newLastNode;
		}
		noOfNodes++;
	}
	
	public boolean insertAt(int index, Object data) {
		boolean isSuccess = false;
		if(isEmpty()) {
			head = tail = new Node(null, data, null);
			isSuccess = true;
		}else if(index == 0){
			Node newNode = new Node(null, data, head);
			head.previousNode = newNode;
			head = newNode;
			isSuccess = true;
		}else {
			Node nodeAtGivenIndex = getNodeAt(index);
			if(nodeAtGivenIndex != null) {
				Node nodeBeforeGivenIndex = nodeAtGivenIndex.previousNode;
				Node newNodeAtGivenIndex = new Node(nodeBeforeGivenIndex, data, nodeAtGivenIndex);
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
	
	public boolean update(Object data, int index) {
		if(isEmpty())
			return false;
		
		boolean isSuccess = false;
		Node nodeAtGivenIndex = getNodeAt(index);
		if(nodeAtGivenIndex != null) {
			nodeAtGivenIndex.data = data;
			isSuccess = true;
		}
		return isSuccess;
	}
	
	public boolean delete(Object data) {
		boolean isSuccess = false;
		Node currentNode = head;
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
	
	public boolean deleteAt(int index) {
		if(isEmpty())
			return false;
		
		boolean isSuccess = false;
		Node nodeToDelete = getNodeAt(index);
		if(nodeToDelete != null) {
			removeNode(nodeToDelete);
			noOfNodes--;
			isSuccess = true;
		}
		return isSuccess;
	}
	
	public Object getDataAt(int index) {
		Object data = null;
		Node node = getNodeAt(index);
		if(node != null) {
			data = node.data;
		}
		return data;
	}
	
	public int getSize() {
		return noOfNodes;
	}
	
	public Object[] traverseForward() {
		if(isEmpty())
			return null;
		
		Node currentNode = head;
		Object[] out = new Object[noOfNodes];
		int i=0;
		while(currentNode != null) {
			out[i] = currentNode.data;
			currentNode = currentNode.nextNode;
			i++;
		}
		return out;
	}
	
	public Object[] traverseReverse() {
		if(isEmpty())
			return null;
		
		Node currentNode = tail;
		Object[] out = new Object[noOfNodes];
		int i = 0;
		while(currentNode != null) {
			out[i] = currentNode.data;
			currentNode = currentNode.previousNode;
			i++;
		}
		return out;
	}
	
	@Override
	public String toString() {
		Node currentNode = head;
		String out = "";
		while(currentNode != null) {
			out = out + currentNode + " -> ";
			currentNode = currentNode.nextNode;
		}
		out = out + "NULL";
		return out;
	}
	
}
