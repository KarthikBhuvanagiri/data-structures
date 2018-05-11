package kar.ds.tree;

import kar.ds.stack.Stack;

public class PostOrderIterator<T> implements TreeIterator<T> {

	private Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
	
	public PostOrderIterator(TreeNode<T> root) {
		if(root != null) {
			traverseLeftSubTreeOf(root);
		}
	}
	
	private void traverseLeftSubTreeOf(TreeNode<T> fromNode) {
		TreeNode<T> currentNode = fromNode;
		while(currentNode != null) {
			if(currentNode.rightNode != null) {
				stack.push(currentNode.rightNode);
			}
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
		while(!stack.isEmpty() && nextNode.rightNode == stack.peek()) {
			TreeNode<T> currentNode = stack.pop();
			stack.push(nextNode);
			traverseLeftSubTreeOf(currentNode);
			nextNode = stack.pop();
		}
		return nextNode;
	}

}
