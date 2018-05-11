package kar.ds.tree;

import kar.ds.stack.Stack;

public class InOrderIterator<T> implements TreeIterator<T> {

	Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
	
	public InOrderIterator(TreeNode<T> root) {
		if(root != null) {
			pushAllLeftNodesFrom(root);
		}
	}
	
	private void pushAllLeftNodesFrom(TreeNode<T> fromNode) {
		TreeNode<T> currentNode = fromNode;
		while(currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.leftNode;
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode<T> next() {
		TreeNode<T> nextNode = stack.pop();
		TreeNode<T> currentNode = nextNode.rightNode;
		if(currentNode != null) {
			pushAllLeftNodesFrom(currentNode);
		}
		return nextNode;
	}

}
