package kar.ds.tree;

import kar.ds.queue.Queue;

public class LevelOrderIterator implements TreeIterator {

	private Queue queue = new Queue();
	
	public LevelOrderIterator(TreeNode root) {
		if(root != null) {
			queue.enqueue(root);
		}
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public TreeNode next() {
		TreeNode node = (TreeNode) queue.dequeue();
		if(node != null) {
			if(node.leftNode != null)
				queue.enqueue(node.leftNode);
			if(node.rightNode != null)
				queue.enqueue(node.rightNode);
		}
		return node;
	}

}
