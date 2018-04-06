package kar.ds.linkedlist;

public class Node {
	Node previousNode;
	Object data;
	Node nextNode;
	
	public Node(Node leftNode, Object data, Node rightNode) {
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
