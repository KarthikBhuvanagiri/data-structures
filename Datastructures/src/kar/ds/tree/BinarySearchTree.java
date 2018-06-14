package kar.ds.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kar.ds.stack.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	protected TreeNode<T> root;

	@Override
	public void insert(T data) {
		if(root == null) {
			root = new TreeNode<T>(null, data, null);
		}else {
			TreeNode<T> currentNode = root;
			Stack<TreeNode<T>> stack = new Stack();
			stack.push(currentNode);
			while(currentNode != null) {
				int x = data.compareTo(currentNode.data);
				if(x < 0) {
					if(currentNode.leftNode == null) {
						currentNode.leftNode = new TreeNode<T>(null, data, null);
						break;
					}else {
						currentNode = currentNode.leftNode;
						stack.push(currentNode);
					}
				}else if(x > 0) {
					if(currentNode.rightNode == null) {
						currentNode.rightNode = new TreeNode<T>(null, data, null);
						break;
					}else {
						currentNode = currentNode.rightNode;
						stack.push(currentNode);
					}
				}
			}
			
			calculateHeightOfAncestralNodes(stack);
		}
		
	}
	
	private void calculateHeightOfAncestralNodes(Stack<TreeNode<T>> ancestralNodes) {
		while(!ancestralNodes.isEmpty()) {
			TreeNode<T> ancestralNode = ancestralNodes.pop();
			ancestralNode.height = 1 + Math.max(ancestralNode.leftNode != null ? ancestralNode.leftNode.height : -1, ancestralNode.rightNode != null ? ancestralNode.rightNode.height : -1);
			
			rebalanceTree(ancestralNode, ancestralNodes.peek());
		}
	}
	
	protected void rebalanceTree(TreeNode<T> rootNode, TreeNode<T> parentNode) {
		
	}

	@Override
	public void delete(T data) {
		TreeNode<T> currentNode = root;
		TreeNode<T> parentNode = null;
		TreeNode<T> nodeToDelete = null;
		Stack<TreeNode<T>> stack = new Stack();
		while(currentNode != null) {
			int x = data.compareTo(currentNode.data);
			if(x == 0) {
				nodeToDelete = currentNode;
				break;
			}else if(x < 0) {
				stack.push(currentNode);
				parentNode = currentNode;
				currentNode = currentNode.leftNode;
			}else {
				stack.push(currentNode);
				parentNode = currentNode;
				currentNode = currentNode.rightNode;
			}
		}
		
		if(nodeToDelete != null) {
			
			if(nodeToDelete.leftNode == null && nodeToDelete.rightNode == null) { //node to be deleted is leaf node
				if(root == nodeToDelete)
					root = null;
				else if(parentNode.leftNode == nodeToDelete)
					parentNode.leftNode = null;
				else if(parentNode.rightNode == nodeToDelete)
					parentNode.rightNode = null;
			}else if(nodeToDelete.leftNode == null || nodeToDelete.rightNode == null) { //node to be deleted has only one child
				if(nodeToDelete == root) {
					if(root.leftNode != null)
						root = root.leftNode;
					else if(root.rightNode != null)
						root = root.rightNode;
				} else if(parentNode.rightNode == nodeToDelete)
					parentNode.rightNode = nodeToDelete.leftNode != null ? nodeToDelete.leftNode : nodeToDelete.rightNode;
				else if(parentNode.leftNode == nodeToDelete) {
					parentNode.leftNode = nodeToDelete.leftNode != null ? nodeToDelete.leftNode : nodeToDelete.rightNode;
				}
			}else { //node to be deleted has two children
				TreeNode<T> minNode = findMinNode(nodeToDelete.rightNode);
				delete(minNode.data);
				if(root == nodeToDelete)
					root.data = minNode.data;
				else if(parentNode.leftNode == nodeToDelete)
					parentNode.leftNode.data = minNode.data;
				else if(parentNode.rightNode == nodeToDelete)
					parentNode.rightNode.data = minNode.data;
			}
			
			calculateHeightOfAncestralNodes(stack);
		}
	}
	
	private TreeNode<T> findMinNode(TreeNode<T> root){
		if(root == null)
			return null;
		TreeNode<T> minNode = root;
		TreeNode<T> currentNode = root;
		while(currentNode != null) {
			currentNode = currentNode.leftNode;
			if(currentNode != null)
				minNode = currentNode;
		}
		return minNode;
	}

	@Override
	public boolean search(T data) {
		return searchNodeWithData(data) != null ? true : false;
	}
	
	private TreeNode<T> searchNodeWithData(T data){
		TreeNode<T> currentNode = root;
		while(currentNode != null) {
			int x = data.compareTo(currentNode.data);
			if(x == 0) {
				break;
			}else if(x < 0) {
				currentNode = currentNode.leftNode;
			}else {
				currentNode = currentNode.rightNode;
			}
		}
		return currentNode;
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
