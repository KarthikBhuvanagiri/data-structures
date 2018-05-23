package kar.ds.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTree<T> implements Tree<T> {

	private TreeNode<T> root;
	private boolean recalculateHeight;
	
	public BinaryTree() {
	}
	
	@Override
	public void insert(T data) {
		if(root == null) {
			root = new TreeNode<T>(null, data, null);
		}else {
			LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
			while(iterator.hasNext()) {
				TreeNode<T> node = iterator.next();
				if(node.leftNode == null) {
					node.leftNode = new TreeNode<T>(null, data, null);
					break;
				}else if(node.rightNode == null) {
					node.rightNode = new TreeNode<T>(null, data, null);
					break;
				}
			}
			recalculateHeight = true;
		}
	}
	
	public void insertAsLeftChildOf(T parent, T dataToInsert) {
		if(isEmpty())
			return;
		
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data.equals(parent)) {
				TreeNode<T> newNode = new TreeNode<T>(currentNode.leftNode, dataToInsert, null);
				currentNode.leftNode = newNode;
				break;
			}
		}
		recalculateHeight = true;
	}
	
	public void insertAsRightChildOf(T parent, T dataToInsert) {
		if(isEmpty())
			return;
		
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data.equals(parent)) {
				TreeNode<T> newNode = new TreeNode<T>(currentNode.rightNode, dataToInsert, null);
				currentNode.rightNode = newNode;
				break;
			}
		}
		recalculateHeight = true;
	}
	
	public void deleteLeftChildOf(T parent) {
		if(isEmpty())
			return;
		
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data.equals(parent)) {
				currentNode.leftNode = null;
				break;
			}
		}
		recalculateHeight = true;
	}
	
	public void deleteRightChildOf(T parent) {
		if(isEmpty())
			return;
		
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data.equals(parent)) {
				currentNode.rightNode = null;
				break;
			}
		}
		recalculateHeight = true;
	}

	@Override
	public void delete(T data) {
		if(isEmpty())
			return;
		
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> nodeToDelete = null; //Node to delete
		TreeNode<T> deepestRightMostNode = null; //Deepest rightmost node
		while(iterator.hasNext()) {
			TreeNode<T> node = deepestRightMostNode = iterator.next();
			if(node.data.equals(data)) {
				nodeToDelete = node;
			}
		}
		
		if(nodeToDelete != null) {
			nodeToDelete.data = deepestRightMostNode.data;
			deleteLeafNode(deepestRightMostNode);
			recalculateHeight = true;
		}
		
	}
	
	private void deleteLeafNode(TreeNode<T> leafNode) {
		if(leafNode == root) {
			root = null;
			return;
		}
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		while(iterator.hasNext()) {
			TreeNode<T> node = iterator.next();
			if(node.leftNode == leafNode) {
				node.leftNode = null;
			}else if(node.rightNode == leafNode) {
				node.rightNode = null;
			}
		}
	}

	@Override
	public boolean search(T data) {
		return searchNodeWithData(data) != null ? true : false;
	}
	
	private TreeNode<T> searchNodeWithData(T data){
		if(isEmpty())
			return null;
		
		TreeNode<T> foundNode = null;
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		while(iterator.hasNext()) {
			TreeNode<T> currentNode = iterator.next();
			if(currentNode.data == data) {
				foundNode = currentNode;
				break;
			}
		}
		
		return foundNode;
	}

	@Override
	public boolean isEmpty() {
		return root == null ? true : false;
	}
	
	@Override
	public T[] traverseLevelOrder() {
		if(isEmpty())
			return null;
		
		ArrayList<T> visitedNodes = new ArrayList<T>();
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		while(iterator.hasNext()) {
			TreeNode<T> node = iterator.next();
			visitedNodes.add(node.data);
		}
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(root.data.getClass(), visitedNodes.size());
		return visitedNodes.toArray(out);
	}

	@Override
	public T[] traverseInOrder() {
		if(isEmpty())
			return null;
		
		ArrayList<T> visitedNodes = new ArrayList<T>();
		InOrderIterator<T> iterator = new InOrderIterator<T>(root);
		while(iterator.hasNext()) {
			TreeNode<T> node = iterator.next();
			visitedNodes.add(node.data);
		}
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(root.data.getClass(), visitedNodes.size());
		return visitedNodes.toArray(out);
	}

	@Override
	public T[] traversePreOrder() {
		if(isEmpty())
			return null;
		
		ArrayList<T> visitedNodes = new ArrayList<T>();
		PreOrderIterator<T> iterator = new PreOrderIterator<T>(root);
		while(iterator.hasNext()) {
			TreeNode<T> node = iterator.next();
			visitedNodes.add(node.data);
		}
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(root.data.getClass(), visitedNodes.size());
		return visitedNodes.toArray(out);
	}

	@Override
	public T[] traversePostOrder() {
		if(isEmpty())
			return null;
		
		ArrayList<T> visitedNodes = new ArrayList<T>();
		PostOrderIterator<T> iterator = new PostOrderIterator<T>(root);
		while(iterator.hasNext()) {
			TreeNode<T> node = iterator.next();
			visitedNodes.add(node.data);
		}
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(root.data.getClass(), visitedNodes.size());
		return visitedNodes.toArray(out);
	}

	@Override
	public int getHeightOf(T data) {
		if(recalculateHeight) {
			BinaryTreeUtils.calculateHeightOfAllNodesOfTree(root);
			recalculateHeight = false;
		}
		int currentNodeHeight = -1;
		TreeNode<T> currentNode = searchNodeWithData(data);
		if(currentNode != null)
			currentNodeHeight = currentNode.height;
		return currentNodeHeight;
	}

}
