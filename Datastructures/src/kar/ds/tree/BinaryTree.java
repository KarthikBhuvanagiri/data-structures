package kar.ds.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kar.ds.stack.Stack;

public class BinaryTree<T> implements Tree<T> {

	private TreeNode<T> root;
	
	public BinaryTree() {
	}
	
	@Override
	public void insert(T data) {
		if(root == null) {
			root = new TreeNode<T>(null, data, null);
		}else {
			Stack<TreeNode<T>> stack = new Stack();
			LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
			while(iterator.hasNext()) {
				TreeNode<T> node = iterator.next();
				if(node.leftNode == null) {
					node.leftNode = new TreeNode<T>(null, data, null);
					node.height = 1 + Math.max(node.leftNode.height, node.rightNode != null ? node.rightNode.height : -1);
					break;
				}else if(node.rightNode == null) {
					node.rightNode = new TreeNode<T>(null, data, null);
					node.height = 1 + Math.max(node.leftNode != null ? node.leftNode.height : -1, node.rightNode.height);
					break;
				}
				stack.push(node);
			}
//			recalculateHeight = true;
			while(!stack.isEmpty()) {
				TreeNode<T> currentNode = stack.pop();
				currentNode.height = 1 + Math.max(currentNode.leftNode != null ? currentNode.leftNode.height : -1, currentNode.rightNode != null ? currentNode.rightNode.height : -1);
			}
		}
	}
	
	public void insertAsLeftChildOf(T parent, T dataToInsert) {
		if(isEmpty())
			return;
		
		Stack<TreeNode<T>> stack = new Stack();
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			stack.push(currentNode);
			if(currentNode.data.equals(parent)) {
				TreeNode<T> newNode = new TreeNode<T>(currentNode.leftNode, dataToInsert, null);
				newNode.height = 1 + (newNode.leftNode != null ? newNode.leftNode.height : -1);
				currentNode.leftNode = newNode;
				break;
			}
		}
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			currentNode.height = 1 + Math.max(currentNode.leftNode != null ? currentNode.leftNode.height : -1, currentNode.rightNode != null ? currentNode.rightNode.height : -1);
		}
	}
	
	public void insertAsRightChildOf(T parent, T dataToInsert) {
		if(isEmpty())
			return;
		
		Stack<TreeNode<T>> stack = new Stack();
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			stack.push(currentNode);
			if(currentNode.data.equals(parent)) {
				TreeNode<T> newNode = new TreeNode<T>(currentNode.rightNode, dataToInsert, null);
				newNode.height = 1 + (newNode.leftNode != null ? newNode.leftNode.height : -1);
				currentNode.rightNode = newNode;
				break;
			}
		}
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			currentNode.height = 1 + Math.max(currentNode.leftNode != null ? currentNode.leftNode.height : -1, currentNode.rightNode != null ? currentNode.rightNode.height : -1);
		}
	}
	
	public void deleteLeftChildOf(T parent) {
		if(isEmpty())
			return;
		
		Stack<TreeNode<T>> stack = new Stack();
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data.equals(parent)) {
				currentNode.leftNode = null;
				break;
			}
			stack.push(currentNode);
		}
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			currentNode.height = 1 + Math.max(currentNode.leftNode != null ? currentNode.leftNode.height : -1, currentNode.rightNode != null ? currentNode.rightNode.height : -1);
		}
	}
	
	public void deleteRightChildOf(T parent) {
		if(isEmpty())
			return;
		
		Stack<TreeNode<T>> stack = new Stack();
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data.equals(parent)) {
				currentNode.rightNode = null;
				break;
			}
			stack.push(currentNode);
		}
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			currentNode.height = 1 + Math.max(currentNode.leftNode != null ? currentNode.leftNode.height : -1, currentNode.rightNode != null ? currentNode.rightNode.height : -1);
		}
	}

	@Override
	public void delete(T data) {
		if(isEmpty())
			return;
		
		Stack<TreeNode<T>> stack = new Stack();
		LevelOrderIterator<T> iterator = new LevelOrderIterator<T>(root);
		TreeNode<T> nodeToDelete = null; //Node to delete
		TreeNode<T> deepestRightMostNode = null; //Deepest rightmost node
		while(iterator.hasNext()) {
			TreeNode<T> node = deepestRightMostNode = iterator.next();
			if(node.data.equals(data)) {
				nodeToDelete = node;
			}
			stack.push(node);
		}
		
		if(nodeToDelete != null) {
			nodeToDelete.data = deepestRightMostNode.data;
			deleteLeafNode(deepestRightMostNode);
			while(!stack.isEmpty()) {
				TreeNode<T> currentNode = stack.pop();
				currentNode.height = 1 + Math.max(currentNode.leftNode != null ? currentNode.leftNode.height : -1, currentNode.rightNode != null ? currentNode.rightNode.height : -1);
			}
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
		int currentNodeHeight = -1;
		TreeNode<T> currentNode = searchNodeWithData(data);
		if(currentNode != null)
			currentNodeHeight = currentNode.height;
		return currentNodeHeight;
	}

}
