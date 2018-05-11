package kar.ds.tree;

public interface TreeIterator<T> {

	public boolean hasNext();
	public TreeNode<T> next();
}
