package kar.ds.tree;

import kar.ds.stack.Stack;

public class PostOrderIterator implements TreeIterator {

	private Stack stack = new Stack();
	
	public PostOrderIterator(TreeNode root) {
		if(root != null) {
			traverseLeftSubTreeOf(root);
		}
	}
	
	private void traverseLeftSubTreeOf(TreeNode fromNode) {
		TreeNode currentNode = fromNode;
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
	public TreeNode next() {
		TreeNode nextNode = (TreeNode) stack.pop();
		while(!stack.isEmpty() && nextNode.rightNode == stack.peek()) {
			TreeNode currentNode = (TreeNode) stack.pop();
			stack.push(nextNode);
			traverseLeftSubTreeOf(currentNode);
			nextNode = (TreeNode) stack.pop();
		}
		return nextNode;
	}

}
