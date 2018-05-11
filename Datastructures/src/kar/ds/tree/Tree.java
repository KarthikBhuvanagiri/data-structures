package kar.ds.tree;

public interface Tree<T> {

	public void insert(T data);
	public void delete(T data);
	public boolean search(T data);
	public boolean isEmpty();
	public T[] traverseLevelOrder();
	public T[] traverseInOrder();
	public T[] traversePreOrder();
	public T[] traversePostOrder();
}
