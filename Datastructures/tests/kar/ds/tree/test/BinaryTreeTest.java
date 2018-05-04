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
	
	private void assertPreOrderContent(Object[] expected, Tree tree) {
		Object[] actual = tree.traversePreOrder();
		assertArrayEquals(expected, actual);
	}
	
	private void assertInOrderContent(Object[] expected, Tree tree) {
		Object[] actual = tree.traverseInOrder();
		assertArrayEquals(expected, actual);;
	}
	
	private void assertPostOrderContent(Object[] expected, Tree tree) {
		Object[] actual = tree.traversePostOrder();
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
	
	protected Object[] getPreOrderContent() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","L","M","G","N","O"};
	}
	
	protected Object[] getInOrderContent() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O"};
	}
	
	protected Object[] getPostOrderContent() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","C","A"};
	}
	
	protected Object getRootNode() {
		return "A";
	}
	
	protected Object[] getLevelOrderContentAfterRootNodeDeletion() {
		return new Object[] {"O","B","C","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected Object[] getPreOrderContentAfterRootNodeDeletion() {
		return new Object[] {"O","B","D","H","I","E","J","K","C","F","L","M","G","N"};
	}
	
	protected Object[] getInOrderContentAfterRootNodeDeletion() {
		return new Object[] {"H","D","I","B","J","E","K","O","L","F","M","C","N","G"};
	}
	
	protected Object[] getPostOrderContentAfterRootNodeDeletion() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","G","C","O"};
	}
	
	protected Object getInternalNode() {
		return "C";
	}
	
	protected Object[] getLevelOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"A","B","O","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected Object[] getPreOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"A","B","D","H","I","E","J","K","O","F","L","M","G","N"};
	}
	
	protected Object[] getInOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","O","N","G"};
	}
	
	protected Object[] getPostOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","G","O","A"};
	}
	
	protected Object getLeafNode() {
		return "L";
	}
	
	protected Object[] getLevelOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"A","B","C","D","E","F","G","H","I","J","K","O","M","N"};
	}
	
	protected Object[] getPreOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","O","M","G","N"};
	}
	
	protected Object[] getInOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"H","D","I","B","J","E","K","A","O","F","M","C","N","G"};
	}
	
	protected Object[] getPostOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"H","I","D","J","K","E","B","O","M","F","N","G","C","A"};
	}
	
	@Test
	void testInsert() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteNodeFromEmptyTree() {
		BinaryTree tree = (BinaryTree) createTree(null);
		tree.delete("A");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}

	@Test
	void testDeleteRootNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterRootNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterRootNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterRootNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterRootNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterInternalNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterInternalNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterInternalNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterInternalNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete(getLeafNode());
		assertLevelOrderContent(getLevelOrderContentAfterLeafNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterLeafNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterLeafNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterLeafNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.delete("AA");
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
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
