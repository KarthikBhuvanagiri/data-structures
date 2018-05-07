package kar.ds.tree;

import java.util.ArrayList;

public class BinaryTree implements Tree {

	private TreeNode root;
	
	public BinaryTree() {
	}
	
	@Override
	public void insert(Object data) {
		if(root == null) {
			root = new TreeNode(null, data, null);
		}else {
			LevelOrderIterator iterator = new LevelOrderIterator(root);
			while(iterator.hasNext()) {
				TreeNode node = iterator.next();
				if(node.leftNode == null) {
					node.leftNode = new TreeNode(null, data, null);
					break;
				}else if(node.rightNode == null) {
					node.rightNode = new TreeNode(null, data, null);
					break;
				}
			}
		}
	}
	
	public void insertAsLeftChildOf(Object parent, Object dataToInsert) {
		if(isEmpty())
			return;
		
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		TreeNode currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data == parent) {
				TreeNode newNode = new TreeNode(currentNode.leftNode, dataToInsert, null);
				currentNode.leftNode = newNode;
				break;
			}
		}
	}
	
	public void insertAsRightChildOf(Object parent, Object dataToInsert) {
		if(isEmpty())
			return;
		
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		TreeNode currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data == parent) {
				TreeNode newNode = new TreeNode(currentNode.rightNode, dataToInsert, null);
				currentNode.rightNode = newNode;
				break;
			}
		}
	}
	
	public void deleteLeftChildOf(Object parent) {
		if(isEmpty())
			return;
		
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		TreeNode currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data == parent) {
				currentNode.leftNode = null;
				break;
			}
		}
	}
	
	public void deleteRightChildOf(Object parent) {
		if(isEmpty())
			return;
		
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		TreeNode currentNode = null;
		while(iterator.hasNext()) {
			currentNode = iterator.next();
			if(currentNode.data == parent) {
				currentNode.rightNode = null;
				break;
			}
		}
	}

	@Override
	public void delete(Object data) {
		if(isEmpty())
			return;
		
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		TreeNode nodeToDelete = null; //Node to delete
		TreeNode deepestRightMostNode = null; //Deepest rightmost node
		while(iterator.hasNext()) {
			TreeNode node = deepestRightMostNode = iterator.next();
			if(node.data == data) {
				nodeToDelete = node;
			}
		}
		
		if(nodeToDelete != null) {
			nodeToDelete.data = deepestRightMostNode.data;
			deleteLeafNode(deepestRightMostNode);
		}
		
	}
	
	private void deleteLeafNode(TreeNode leafNode) {
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		while(iterator.hasNext()) {
			TreeNode node = iterator.next();
			if(node.leftNode == leafNode) {
				node.leftNode = null;
			}else if(node.rightNode == leafNode) {
				node.rightNode = null;
			}
		}
	}

	@Override
	public boolean search(Object data) {
		if(isEmpty())
			return false;
		
		boolean isFound = false;
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		while(iterator.hasNext()) {
			TreeNode node = iterator.next();
			if(node.data == data) {
				isFound = true;
				break;
			}
		}
		
		return isFound;
	}

	@Override
	public boolean isEmpty() {
		return root == null ? true : false;
	}
	
	@Override
	public Object[] traverseLevelOrder() {
		if(isEmpty())
			return null;
		
		ArrayList visitedNodes = new ArrayList();
		LevelOrderIterator iterator = new LevelOrderIterator(root);
		while(iterator.hasNext()) {
			TreeNode node = iterator.next();
			visitedNodes.add(node.data);
		}
		return visitedNodes.toArray();
	}

	@Override
	public Object[] traverseInOrder() {
		if(isEmpty())
			return null;
		
		ArrayList visitedNodes = new ArrayList();
		InOrderIterator iterator = new InOrderIterator(root);
		while(iterator.hasNext()) {
			TreeNode node = iterator.next();
			visitedNodes.add(node.data);
		}
		return visitedNodes.toArray();
	}

	@Override
	public Object[] traversePreOrder() {
		if(isEmpty())
			return null;
		
		ArrayList visitedNodes = new ArrayList();
		PreOrderIterator iterator = new PreOrderIterator(root);
		while(iterator.hasNext()) {
			TreeNode node = iterator.next();
			visitedNodes.add(node.data);
		}
		return visitedNodes.toArray();
	}

	@Override
	public Object[] traversePostOrder() {
		if(isEmpty())
			return null;
		
		ArrayList visitedNodes = new ArrayList();
		PostOrderIterator iterator = new PostOrderIterator(root);
		while(iterator.hasNext()) {
			TreeNode node = iterator.next();
			visitedNodes.add(node.data);
		}
		return visitedNodes.toArray();
	}

}
