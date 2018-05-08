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
	
	protected Object[] getLevelOrderContentAfterInsertAtRightChildOfRoot() {
		return new Object[] {"A","B","X","D","E","C","H","I","J","K","F","G","L","M","N","O"};
	}
	
	protected Object[] getLevelOrderContentAfterInsertAsLeftChildOfRoot() {
		return new Object[] {"A","X","C","B","F","G","D","E","L","M","N","O","H","I","J","K"};
	}
	
	protected Object[] getLevelOrderContentAfterRootNodeDeletion() {
		return new Object[] {"O","B","C","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected Object[] getLevelOrderContentAfterDeletingLeftChildOfRoot() {
		return new Object[] {"A","C","F","G","L","M","N","O"};
	}
	
	protected Object[] getLevelOrderContentAfterDeletingRightChildOfRoot() {
		return new Object[] {"A","B","D","E","H","I","J","K"};
	}
	
	protected Object[] getPreOrderContentAfterInsertAtRightChildOfRoot() {
		return new Object[] {"A","B","D","H","I","E","J","K","X","C","F","L","M","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterInsertAsLeftChildOfRoot() {
		return new Object[] {"A","X","B","D","H","I","E","J","K","C","F","L","M","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterRootNodeDeletion() {
		return new Object[] {"O","B","D","H","I","E","J","K","C","F","L","M","G","N"};
	}
	
	protected Object[] getPreOrderContentAfterDeletingLeftChildOfRoot() {
		return new Object[] {"A","C","F","L","M","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterDeletingRightChildOfRoot() {
		return new Object[] {"A","B","D","H","I","E","J","K"};
	}
	
	protected Object[] getInOrderContentAfterInsertAsRightChildOfRoot() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O","X"};
	}
	
	protected Object[] getInOrderContentAfterInsertAsLeftChildOfRoot() {
		return new Object[] {"H","D","I","B","J","E","K","X","A","L","F","M","C","N","G","O"};
	}
	
	protected Object[] getInOrderContentAfterRootNodeDeletion() {
		return new Object[] {"H","D","I","B","J","E","K","O","L","F","M","C","N","G"};
	}
	
	protected Object[] getInOrderContentAfterDeletingLeftChildOfRoot() {
		return new Object[] {"A","L","F","M","C","N","G","O"};
	}
	
	protected Object[] getInOrderContentAfterDeletingRightChildOfRoot() {
		return new Object[] {"H","D","I","B","J","E","K","A"};
	}
	
	protected Object[] getPostOrderContentAfterInsertAsRightChildOfRoot() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","C","X","A"};
	}
	
	protected Object[] getPostOrderContentAfterInsertAsLeftChildOfRoot() {
		return new Object[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	protected Object[] getPostOrderContentAfterRootNodeDeletion() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","G","C","O"};
	}
	
	protected Object[] getPostOrderContentAfterDeletingLeftChildOfRoot() {
		return new Object[] {"L","M","F","N","O","G","C","A"};
	}
	
	protected Object[] getPostOrderContentAfterDeletingRightChildOfRoot() {
		return new Object[] {"H","I","D","J","K","E","B","A"};
	}
	
	protected Object getInternalNode() {
		return "C";
	}
	
	protected Object[] getLevelOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new Object[] {"A","B","C","D","E","F","X","H","I","J","K","L","M","G","N","O"};
	}
	
	protected Object[] getLevelOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new Object[] {"A","B","C","D","E","X","G","H","I","J","K","F","N","O","L","M"};
	}
	
	protected Object[] getLevelOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"A","B","O","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected Object[] getLevelOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new Object[] {"A","B","C","D","E","G","H","I","J","K","N","O"};
	}
	
	protected Object[] getLevelOrderContentAfterDeletingRightChildOfInternalNode() {
		return new Object[] {"A","B","C","D","E","F","H","I","J","K","L","M"};
	}
	
	protected Object[] getPreOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","L","M","X","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","X","F","L","M","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"A","B","D","H","I","E","J","K","O","F","L","M","G","N"};
	}
	
	protected Object[] getPreOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterDeletingRightChildOfInternalNode() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","L","M"};
	}
	
	protected Object[] getInOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O","X"};
	}
	
	protected Object[] getInOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","X","C","N","G","O"};
	}
	
	protected Object[] getInOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","O","N","G"};
	}
	
	protected Object[] getInOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new Object[] {"H","D","I","B","J","E","K","A","C","N","G","O"};
	}
	
	protected Object[] getInOrderContentAfterDeletingRightChildOfInternalNode() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","F","M","C"};
	}
	
	protected Object[] getPostOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","X","C","A"};
	}
	
	protected Object[] getPostOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","X","N","O","G","C","A"};
	}
	
	protected Object[] getPostOrderContentAfterInternalNodeDeletion() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","N","G","O","A"};
	}
	
	protected Object[] getPostOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new Object[] {"H","I","D","J","K","E","B","N","O","G","C","A"};
	}
	
	protected Object[] getPostOrderContentAfterDeletingRightChildOfInternalNode() {
		return new Object[] {"H","I","D","J","K","E","B","L","M","F","C","A"};
	}
	
	protected Object getLeafNode() {
		return "L";
	}
	
	protected Object[] getLevelOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new Object[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","X"};
	}
	
	protected Object[] getLevelOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new Object[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","X"};
	}
	
	protected Object[] getLevelOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"A","B","C","D","E","F","G","H","I","J","K","O","M","N"};
	}
	
	protected Object[] getPreOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","L","X","M","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","L","X","M","G","N","O"};
	}
	
	protected Object[] getPreOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"A","B","D","H","I","E","J","K","C","F","O","M","G","N"};
	}
	
	protected Object[] getInOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new Object[] {"H","D","I","B","J","E","K","A","L","X","F","M","C","N","G","O"};
	}
	
	protected Object[] getInOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new Object[] {"H","D","I","B","J","E","K","A","X","L","F","M","C","N","G","O"};
	}
	
	protected Object[] getInOrderContentAfterLeafNodeDeletion() {
		return new Object[] {"H","D","I","B","J","E","K","A","O","F","M","C","N","G"};
	}
	
	protected Object[] getPostOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new Object[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	protected Object[] getPostOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new Object[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
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
	void testInsertInEmptyTreeAsLeftChildOf() {
		BinaryTree tree = new BinaryTree();
		tree.insertAsLeftChildOf("A", "B");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testInsertAsLeftChildOfRoot() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsLeftChildOf(getRootNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsLeftChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsLeftChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsLeftChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsLeftChildOfRoot(), tree);
	}
	
	@Test
	void testInsertAsLeftChildOfInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsLeftChildOf(getInternalNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
	}
	
	@Test
	void testInsertAsLeftChildOfLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsLeftChildOf(getLeafNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
	}
	
	@Test
	void testInsertAsLeftChildOfNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsLeftChildOf("Z", "X");
		assertLevelOrderContent(getTreeContent(), tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testInsertInEmptyTreeAsRightChildOf() {
		BinaryTree tree = new BinaryTree();
		tree.insertAsRightChildOf("A", "B");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testInsertAsRightChildOfRoot() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsRightChildOf(getRootNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAtRightChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAtRightChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsRightChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsRightChildOfRoot(), tree);
	}
	
	@Test
	void testInsertAsRightChildOfInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsRightChildOf(getInternalNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
	}
	
	@Test
	void testInsertAsRightChildOfLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsRightChildOf(getLeafNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
	}
	
	@Test
	void testInsertAsRightChildOfNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.insertAsRightChildOf("Z", "X");
		assertLevelOrderContent(getTreeContent(), tree);
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
	void testDeleteLeftChildOfEmptyTree() {
		BinaryTree tree = new BinaryTree();
		tree.deleteLeftChildOf("A");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testDeleteLeftChildOfRoot() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteLeftChildOf(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingLeftChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingLeftChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingLeftChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingLeftChildOfRoot(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteLeftChildOf(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteLeftChildOf(getLeafNode());
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteLeftChildOf("X");
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteRightChildOfEmptyTree() {
		BinaryTree tree = new BinaryTree();
		tree.deleteRightChildOf("A");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testDeleteRightChildOfRoot() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteRightChildOf(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingRightChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingRightChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingRightChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingRightChildOfRoot(), tree);
	}
	
	@Test
	void testDeleteRightChildOfInternalNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteRightChildOf(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingRightChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingRightChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingRightChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingRightChildOfInternalNode(), tree);
	}
	
	@Test
	void testDeleteRightChildOfLeafNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteRightChildOf(getLeafNode());
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteRightChildOfNonExistentNode() {
		Object[] expected = getTreeContent();
		BinaryTree tree = (BinaryTree) createTree(expected);
		tree.deleteRightChildOf("X");
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
