package kar.ds.linkedlist;

import java.util.List;

public class SingleLinkedList {

	private Node head;
	private Node tail;
	private int noOfNodes = 0;

	public SingleLinkedList(){
	}
	
	public SingleLinkedList(List dataList) {
		for(Object data : dataList)
			insert(data);
	}
	
	public SingleLinkedList(Object[] dataArray) {
		for(Object data : dataArray)
			insert(data);
	}
	
	public boolean isEmpty() {
		return noOfNodes == 0 && head == null && tail == null ? true : false;
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
			Node newNode = new Node(null, data, null);
			tail = lastNode.nextNode = newNode;
		}
		noOfNodes++;
	}
	
	public boolean insertAt(int index, Object data) {
		boolean isSuccess = false;
		if(isEmpty()) {
			head = tail = new Node(null, data, null);
			isSuccess = true;
		}else if(index == 0) {
			Node newNode = new Node(null, data, head);
			head = newNode;
			isSuccess = true;
		}else {
			Node nodeAtGivenIndex = getNodeAt(index);
			if(nodeAtGivenIndex != null) {
				Node nodeAtPreviousIndex = getNodeAt(index - 1);
				Node newNode = new Node(null, data, nodeAtGivenIndex);
				nodeAtPreviousIndex.nextNode = newNode;
				isSuccess = true;
			}
		}
		
		if(isSuccess) {
			noOfNodes++;
		}
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
		Node previousNode = null;
		Node currentNode = head;
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
	
	public boolean deleteAt(int index) {
		if(isEmpty())
			return false;
		
		boolean isSuccess = false;
		Node nodeToDelete = getNodeAt(index);
		if(nodeToDelete != null) {
			if(nodeToDelete == head && nodeToDelete == tail) {
				head = tail = null;
			} else if(nodeToDelete == head) {
				head = head.nextNode;
			} else {
				Node previousNode = getNodeAt(index - 1);
				if(previousNode != null)
					previousNode.nextNode = nodeToDelete.nextNode;
			}
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
	
	public Object[] traverse() {
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
