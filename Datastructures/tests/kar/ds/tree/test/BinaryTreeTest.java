package kar.ds.tree.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import kar.ds.tree.BinaryTree;
import kar.ds.tree.Tree;

class BinaryTreeTest {


	private void assertLevelOrderContent(String[] expected, Tree<String> tree) {
		String[] actual = tree.traverseLevelOrder();
		assertArrayEquals(expected, actual);
	}
	
	private void assertPreOrderContent(String[] expected, Tree<String> tree) {
		String[] actual = tree.traversePreOrder();
		assertArrayEquals(expected, actual);
	}
	
	private void assertInOrderContent(String[] expected, Tree<String> tree) {
		String[] actual = tree.traverseInOrder();
		assertArrayEquals(expected, actual);;
	}
	
	private void assertPostOrderContent(String[] expected, Tree<String> tree) {
		String[] actual = tree.traversePostOrder();
		assertArrayEquals(expected, actual);
	}
	
	protected Tree<String> createTree(String[] nodes) {
		Tree<String> tree = new BinaryTree<String>();
		if(nodes != null) {
			for(String node : nodes) {
				tree.insert(node);
			}
		}
		return tree;
	}
	
	protected Tree<String> createEmptyTree() {
		return new BinaryTree<String>();
	}
	
	protected String[] getTreeContent() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	}
	
	protected String[] getPreOrderContent() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","M","G","N","O"};
	}
	
	protected String[] getInOrderContent() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O"};
	}
	
	protected String[] getPostOrderContent() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","C","A"};
	}
	
	protected String getRootNode() {
		return "A";
	}
	
	protected String[] getLevelOrderContentAfterInsertAtRightChildOfRoot() {
		return new String[] {"A","B","X","D","E","C","H","I","J","K","F","G","L","M","N","O"};
	}
	
	protected String[] getLevelOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"A","X","C","B","F","G","D","E","L","M","N","O","H","I","J","K"};
	}
	
	protected String[] getLevelOrderContentAfterRootNodeDeletion() {
		return new String[] {"O","B","C","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected String[] getLevelOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"A","C","F","G","L","M","N","O"};
	}
	
	protected String[] getLevelOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"A","B","D","E","H","I","J","K"};
	}
	
	protected String[] getPreOrderContentAfterInsertAtRightChildOfRoot() {
		return new String[] {"A","B","D","H","I","E","J","K","X","C","F","L","M","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"A","X","B","D","H","I","E","J","K","C","F","L","M","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterRootNodeDeletion() {
		return new String[] {"O","B","D","H","I","E","J","K","C","F","L","M","G","N"};
	}
	
	protected String[] getPreOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"A","C","F","L","M","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"A","B","D","H","I","E","J","K"};
	}
	
	protected String[] getInOrderContentAfterInsertAsRightChildOfRoot() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O","X"};
	}
	
	protected String[] getInOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"H","D","I","B","J","E","K","X","A","L","F","M","C","N","G","O"};
	}
	
	protected String[] getInOrderContentAfterRootNodeDeletion() {
		return new String[] {"H","D","I","B","J","E","K","O","L","F","M","C","N","G"};
	}
	
	protected String[] getInOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"A","L","F","M","C","N","G","O"};
	}
	
	protected String[] getInOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"H","D","I","B","J","E","K","A"};
	}
	
	protected String[] getPostOrderContentAfterInsertAsRightChildOfRoot() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","C","X","A"};
	}
	
	protected String[] getPostOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	protected String[] getPostOrderContentAfterRootNodeDeletion() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","G","C","O"};
	}
	
	protected String[] getPostOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"L","M","F","N","O","G","C","A"};
	}
	
	protected String[] getPostOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"H","I","D","J","K","E","B","A"};
	}
	
	protected String getInternalNode() {
		return "C";
	}
	
	protected String[] getLevelOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","F","X","H","I","J","K","L","M","G","N","O"};
	}
	
	protected String[] getLevelOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","X","G","H","I","J","K","F","N","O","L","M"};
	}
	
	protected String[] getLevelOrderContentAfterInternalNodeDeletion() {
		return new String[] {"A","B","O","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	protected String[] getLevelOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","G","H","I","J","K","N","O"};
	}
	
	protected String[] getLevelOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","F","H","I","J","K","L","M"};
	}
	
	protected String[] getPreOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","M","X","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","X","F","L","M","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterInternalNodeDeletion() {
		return new String[] {"A","B","D","H","I","E","J","K","O","F","L","M","G","N"};
	}
	
	protected String[] getPreOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","M"};
	}
	
	protected String[] getInOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O","X"};
	}
	
	protected String[] getInOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","X","C","N","G","O"};
	}
	
	protected String[] getInOrderContentAfterInternalNodeDeletion() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","O","N","G"};
	}
	
	protected String[] getInOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","C","N","G","O"};
	}
	
	protected String[] getInOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C"};
	}
	
	protected String[] getPostOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","X","C","A"};
	}
	
	protected String[] getPostOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","X","N","O","G","C","A"};
	}
	
	protected String[] getPostOrderContentAfterInternalNodeDeletion() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","G","O","A"};
	}
	
	protected String[] getPostOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","N","O","G","C","A"};
	}
	
	protected String[] getPostOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","C","A"};
	}
	
	protected String getLeafNode() {
		return "L";
	}
	
	protected String[] getLevelOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","X"};
	}
	
	protected String[] getLevelOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","X"};
	}
	
	protected String[] getLevelOrderContentAfterLeafNodeDeletion() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","O","M","N"};
	}
	
	protected String[] getPreOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","X","M","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","X","M","G","N","O"};
	}
	
	protected String[] getPreOrderContentAfterLeafNodeDeletion() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","O","M","G","N"};
	}
	
	protected String[] getInOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","X","F","M","C","N","G","O"};
	}
	
	protected String[] getInOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"H","D","I","B","J","E","K","A","X","L","F","M","C","N","G","O"};
	}
	
	protected String[] getInOrderContentAfterLeafNodeDeletion() {
		return new String[] {"H","D","I","B","J","E","K","A","O","F","M","C","N","G"};
	}
	
	protected String[] getPostOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	protected String[] getPostOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	protected String[] getPostOrderContentAfterLeafNodeDeletion() {
		return new String[] {"H","I","D","J","K","E","B","O","M","F","N","G","C","A"};
	}
	
	@Test
	void testInsert() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testInsertInEmptyTreeAsLeftChildOf() {
		BinaryTree<String> tree = (BinaryTree<String>) createEmptyTree();
		tree.insertAsLeftChildOf("A", "B");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testInsertAsLeftChildOfRoot() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsLeftChildOf(getRootNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsLeftChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsLeftChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsLeftChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsLeftChildOfRoot(), tree);
	}
	
	@Test
	void testInsertAsLeftChildOfInternalNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsLeftChildOf(getInternalNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsLeftChildOfInternalNode(), tree);
	}
	
	@Test
	void testInsertAsLeftChildOfLeafNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsLeftChildOf(getLeafNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsLeftChildOfLeafNode(), tree);
	}
	
	@Test
	void testInsertAsLeftChildOfNonExistentNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsLeftChildOf("Z", "X");
		assertLevelOrderContent(getTreeContent(), tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testInsertInEmptyTreeAsRightChildOf() {
		BinaryTree<String> tree = (BinaryTree<String>) createEmptyTree();
		tree.insertAsRightChildOf("A", "B");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testInsertAsRightChildOfRoot() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsRightChildOf(getRootNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAtRightChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAtRightChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsRightChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsRightChildOfRoot(), tree);
	}
	
	@Test
	void testInsertAsRightChildOfInternalNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsRightChildOf(getInternalNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsRightChildOfInternalNode(), tree);
	}
	
	@Test
	void testInsertAsRightChildOfLeafNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsRightChildOf(getLeafNode(), "X");
		assertLevelOrderContent(getLevelOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
		assertInOrderContent(getInOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterInsertAsRightChildOfLeafNode(), tree);
	}
	
	@Test
	void testInsertAsRightChildOfNonExistentNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.insertAsRightChildOf("Z", "X");
		assertLevelOrderContent(getTreeContent(), tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteNodeFromEmptyTree() {
		Tree<String> tree = createTree(null);
		tree.delete("A");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}

	@Test
	void testDeleteRootNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		tree.delete(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterRootNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterRootNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterRootNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterRootNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteInternalNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		tree.delete(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterInternalNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterInternalNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterInternalNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterInternalNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteLeafNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		tree.delete(getLeafNode());
		assertLevelOrderContent(getLevelOrderContentAfterLeafNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterLeafNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterLeafNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterLeafNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteNonExistentNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		tree.delete("AA");
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfEmptyTree() {
		BinaryTree<String> tree = (BinaryTree<String>) createEmptyTree();
		tree.deleteLeftChildOf("A");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testDeleteLeftChildOfRoot() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteLeftChildOf(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingLeftChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingLeftChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingLeftChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingLeftChildOfRoot(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfInternalNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteLeftChildOf(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingLeftChildOfInternalNode(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfLeafNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteLeftChildOf(getLeafNode());
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteLeftChildOfNonExistentNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteLeftChildOf("X");
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteRightChildOfEmptyTree() {
		BinaryTree<String> tree = (BinaryTree<String>) createEmptyTree();
		tree.deleteRightChildOf("A");
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testDeleteRightChildOfRoot() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteRightChildOf(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingRightChildOfRoot(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingRightChildOfRoot(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingRightChildOfRoot(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingRightChildOfRoot(), tree);
	}
	
	@Test
	void testDeleteRightChildOfInternalNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteRightChildOf(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterDeletingRightChildOfInternalNode(), tree);
		assertPreOrderContent(getPreOrderContentAfterDeletingRightChildOfInternalNode(), tree);
		assertInOrderContent(getInOrderContentAfterDeletingRightChildOfInternalNode(), tree);
		assertPostOrderContent(getPostOrderContentAfterDeletingRightChildOfInternalNode(), tree);
	}
	
	@Test
	void testDeleteRightChildOfLeafNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteRightChildOf(getLeafNode());
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testDeleteRightChildOfNonExistentNode() {
		String[] expected = getTreeContent();
		BinaryTree<String> tree = (BinaryTree<String>) createTree(expected);
		tree.deleteRightChildOf("X");
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testSearchNodeInEmptyTree() {
		Tree<String> tree = createTree(null);
		assertFalse(tree.search("A"));
	}

	@Test
	void testSearchRootNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		assertTrue(tree.search(getRootNode()));
	}
	
	@Test
	void testSearchInternalNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		assertTrue(tree.search(getInternalNode()));
	}
	
	@Test
	void testSearchLeafNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		assertTrue(tree.search(getLeafNode()));
	}
	
	@Test
	void testSearchNonExistentNode() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		assertFalse(tree.search("X"));
	}

	@Test
	void testIsEmpty() {
		Tree<String> tree = createEmptyTree();
		assertTrue(tree.isEmpty());
	}

}
