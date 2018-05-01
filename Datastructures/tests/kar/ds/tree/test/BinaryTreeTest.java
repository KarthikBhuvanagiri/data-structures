package kar.ds.tree.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import kar.ds.tree.BinaryTree;
import kar.ds.tree.Tree;

class BinaryTreeTest {


	private void assertLevelOrderContent(Object[] expected, Tree tree) {
		Object[] actual = tree.traverseLevelOrder();
		assertArrayEquals(expected, actual);
	}
	
	protected Tree createTree(Object[] nodes) {
		Tree tree = new BinaryTree();
		if(nodes != null) {
			for(Object node : nodes) {
				tree.insert(node);
			}
		}
		return tree;
	}
	
	protected Object[] getTreeContent() {
		return new Object[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	}
	
	protected Object getRootNode() {
		return "A";
	}
	
	protected Object[] getLevelOrderContentAfterRootNodeDeletion() {
		return new Object[] {"O","B","C","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected Object getInternalNode() {
		return "C";
	}
	
	protected Object[] getLevelOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"A","B","O","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected Object getLeafNode() {
		return "L";
	}
	
	protected Object[] getLevelOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"A","B","C","D","E","F","G","H","I","J","K","O","M","N"};
	}
	
	@Test
	void testInsert() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		assertLevelOrderContent(expected, tree);
	}
	
	@Test
	void testDeleteNodeFromEmptyTree() {
		BinaryTree tree = (BinaryTree) createTree(null);
		tree.delete("A");
		assertLevelOrderContent(null, tree);
	}

	@Test
	void testDeleteRootNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterRootNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterInternalNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete(getLeafNode());
		assertLevelOrderContent(getLevelOrderContentAfterLeafNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete("AA");
		assertLevelOrderContent(expected, tree);
	}
	
	@Test
	void testSearchNodeInEmptyTree() {
		BinaryTree tree = (BinaryTree) createTree(null);
		assertFalse(tree.search("A"));
	}

	@Test
	void testSearchRootNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		assertTrue(tree.search(getRootNode()));
	}
	
	@Test
	void testSearchInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		assertTrue(tree.search(getInternalNode()));
	}
	
	@Test
	void testSearchLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		assertTrue(tree.search(getLeafNode()));
	}
	
	@Test
	void testSearchNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		assertFalse(tree.search("X"));
	}

	@Test
	void testIsEmpty() {
		BinaryTree tree = new BinaryTree();
		assertTrue(tree.isEmpty());
	}

}
