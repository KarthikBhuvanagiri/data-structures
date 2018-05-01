package kar.ds.tree;

public interface Tree {

	public void insert(Object data);
	public void delete(Object data);
	public boolean search(Object data);
	public boolean isEmpty();
	public Object[] traverseLevelOrder();
	public Object[] traverseInOrder();
	public Object[] traversePreOrder();
	public Object[] traversePostOrder();
}
