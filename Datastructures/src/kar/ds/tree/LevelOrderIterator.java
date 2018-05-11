package kar.ds.tree;

import kar.ds.queue.Queue;

public class LevelOrderIterator<T> implements TreeIterator<T> {

	private Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
	
	public LevelOrderIterator(TreeNode<T> root) {
		if(root != null) {
			queue.enqueue(root);
		}
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public TreeNode<T> next() {
		TreeNode<T> node = queue.dequeue();
		if(node != null) {
			if(node.leftNode != null)
				queue.enqueue(node.leftNode);
			if(node.rightNode != null)
				queue.enqueue(node.rightNode);
		}
		return node;
	}

}
