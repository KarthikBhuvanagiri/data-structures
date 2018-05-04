package kar.ds.tree;

import kar.ds.stack.Stack;

public class PreOrderIterator implements TreeIterator {

	private Stack stack = new Stack();
	
	public PreOrderIterator(TreeNode root) {
		if(root != null) {
			stack.push(root);
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public TreeNode next() {
		TreeNode nextNode = (TreeNode) stack.pop();
		if(nextNode.rightNode != null)
			stack.push(nextNode.rightNode);
		if(nextNode.leftNode != null)
			stack.push(nextNode.leftNode);
		return nextNode;
	}

}
