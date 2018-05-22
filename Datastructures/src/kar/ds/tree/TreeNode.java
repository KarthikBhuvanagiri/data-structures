package kar.ds.tree;

public class TreeNode<T> {

	TreeNode<T> leftNode;
	T data;
	TreeNode<T> rightNode;
	int height;
	
	public TreeNode(TreeNode<T> leftNode, T data, TreeNode<T> rightNode) {
		this.leftNode = leftNode;
		this.data = data;
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
