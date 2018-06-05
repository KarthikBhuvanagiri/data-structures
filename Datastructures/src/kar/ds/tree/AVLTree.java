package kar.ds.tree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	@Override
	protected void rebalanceTree(TreeNode<T> rootNode, TreeNode<T> parentNode) {
		int balanceFactor = getBalanceFactor(rootNode);
		int leftNodeBalanceFactor = getBalanceFactor(rootNode.leftNode);
		int rightNodeBalanceFactor = getBalanceFactor(rootNode.rightNode);
		if(balanceFactor > 1 && leftNodeBalanceFactor >= 0) { //Left-Left case
			TreeNode<T> nodeAfterRightRotate = rotateRight(rootNode);
			if(parentNode != null)
				parentNode.leftNode = nodeAfterRightRotate;
			else
				root = nodeAfterRightRotate;
		}else if(balanceFactor < -1 && rightNodeBalanceFactor <= 0) { //Right-Right case
			TreeNode<T> nodeAfterLeftRotate = rotateLeft(rootNode);
			if(parentNode != null)
				parentNode.rightNode = nodeAfterLeftRotate;
			else
				root = nodeAfterLeftRotate;
		}else if(balanceFactor > 1 && leftNodeBalanceFactor < 0) { //Left-Right case
			rootNode.leftNode = rotateLeft(rootNode.leftNode);
			TreeNode<T> nodeAfterRightRotate = rotateRight(rootNode);
			if(parentNode != null)
				parentNode.leftNode = nodeAfterRightRotate;
			else
				root = nodeAfterRightRotate;
		}else if(balanceFactor < -1 && rightNodeBalanceFactor > 0) { //Right-Left case
			rootNode.rightNode = rotateRight(rootNode.rightNode);
			TreeNode<T> nodeAfterLeftRotate = rotateLeft(rootNode);
			if(parentNode != null)
				parentNode.rightNode = nodeAfterLeftRotate;
			else
				root = nodeAfterLeftRotate;
		}
	}
	
	private int getBalanceFactor(TreeNode<T> node) {
		if(node == null)
			return 0;
		return (node.leftNode != null ? node.leftNode.height : -1) - (node.rightNode != null ? node.rightNode.height : -1); 
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> node) {
		TreeNode<T> temp = node.rightNode;
		node.rightNode = temp.leftNode;
		temp.leftNode = node;
		return temp;
		/*if(parentNode == null) {
			root = node.rightNode;
			node.rightNode = root.leftNode;
			root.leftNode = node;
		}else {
			parentNode.rightNode = node.rightNode;
			node.rightNode = parentNode.rightNode.leftNode;
			parentNode.rightNode.leftNode = node;
		}*/
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> node) {
		TreeNode<T> temp = node.leftNode;
		node.leftNode = temp.rightNode;
		temp.rightNode = node;
		return temp;
		/*if(parentNode == null) {
			root = node.leftNode;
			node.leftNode = root.rightNode;
			root.rightNode = node;
		}else {
			TreeNode<T> temp = node.leftNode;
			node.leftNode = temp.rightNode;
			parentNode.leftNode.rightNode = node;
		}*/
	}

}
