package kar.ds.linkedlist;

public class Node<T> {
	Node<T> previousNode;
	T data;
	Node<T> nextNode;
	
	public Node(Node<T> leftNode, T data, Node<T> rightNode) {
		this.previousNode = leftNode;
		this.data = data;
		this.nextNode = rightNode;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
