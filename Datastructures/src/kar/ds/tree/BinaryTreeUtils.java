package kar.ds.tree;

public class BinaryTreeUtils {

	public static <T> void calculateHeightOfAllNodesOfTree(TreeNode<T> root) {
		if(root == null)
			return;
		PostOrderIterator<T> iterator = new PostOrderIterator<>(root);
		while(iterator.hasNext()) {
			TreeNode<T> currentNode = iterator.next();
			if(currentNode.leftNode == null && currentNode.rightNode == null)
				currentNode.height = 0;
			else if(currentNode.leftNode == null)
				currentNode.height = 1 + currentNode.rightNode.height;
			else if(currentNode.rightNode == null)
				currentNode.height = 1 + currentNode.leftNode.height;
			else
				currentNode.height = 1 + Math.max(currentNode.leftNode.height, currentNode.rightNode.height);
		}
	}
}
