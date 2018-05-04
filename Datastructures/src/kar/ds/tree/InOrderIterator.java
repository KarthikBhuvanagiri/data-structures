package kar.ds.tree;

import kar.ds.stack.Stack;

public class InOrderIterator implements TreeIterator {

	Stack stack = new Stack();
	
	public InOrderIterator(TreeNode root) {
		if(root != null) {
			pushAllLeftNodesFrom(root);
		}
	}
	
	private void pushAllLeftNodesFrom(TreeNode fromNode) {
		TreeNode currentNode = fromNode;
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
	public TreeNode next() {
		TreeNode nextNode = (TreeNode) stack.pop();
		TreeNode currentNode = nextNode.rightNode;
		if(currentNode != null) {
			pushAllLeftNodesFrom(currentNode);
		}
		return nextNode;
	}

}
