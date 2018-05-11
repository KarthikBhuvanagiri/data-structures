package kar.ds.tree;

import kar.ds.stack.Stack;

public class PreOrderIterator<T> implements TreeIterator<T> {

	private Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
	
	public PreOrderIterator(TreeNode<T> root) {
		if(root != null) {
			stack.push(root);
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode<T> next() {
		TreeNode<T> nextNode = stack.pop();
		if(nextNode.rightNode != null)
			stack.push(nextNode.rightNode);
		if(nextNode.leftNode != null)
			stack.push(nextNode.leftNode);
		return nextNode;
	}

}
