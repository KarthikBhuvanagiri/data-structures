package kar.ds.tree;

public class TreeNode {

	TreeNode leftNode;
	Object data;
	TreeNode rightNode;
	
	public TreeNode(TreeNode leftNode, Object data, TreeNode rightNode) {
		this.leftNode = leftNode;
		this.data = data;
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
