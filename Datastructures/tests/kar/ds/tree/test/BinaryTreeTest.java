package kar.ds.tree.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	private void assertHeights(int[] expectedHeights, Tree<String> tree) {
		String[] keys = tree.traverseLevelOrder();
		for(int i=0; i<keys.length; i++) {
			assertEquals(expectedHeights[i], tree.getHeightOf(keys[i]));
		}
	}
	
	private Tree<String> createTree(String[] nodes) {
		Tree<String> tree = new BinaryTree<String>();
		if(nodes != null) {
			for(String node : nodes) {
				tree.insert(node);
			}
		}
		return tree;
	}
	
	private Tree<String> createEmptyTree() {
		return new BinaryTree<String>();
	}
	
	private String[] getTreeContent() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	}
	
	private String[] getPreOrderContent() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","M","G","N","O"};
	}
	
	private String[] getInOrderContent() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O"};
	}
	
	private String[] getPostOrderContent() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","C","A"};
	}
	
	private String getRootNode() {
		return "A";
	}
	
	private String[] getLevelOrderContentAfterInsertAtRightChildOfRoot() {
		return new String[] {"A","B","X","D","E","C","H","I","J","K","F","G","L","M","N","O"};
	}
	
	private String[] getLevelOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"A","X","C","B","F","G","D","E","L","M","N","O","H","I","J","K"};
	}
	
	private String[] getLevelOrderContentAfterRootNodeDeletion() {
		return new String[] {"O","B","C","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	private String[] getLevelOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"A","C","F","G","L","M","N","O"};
	}
	
	private String[] getLevelOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"A","B","D","E","H","I","J","K"};
	}
	
	private String[] getPreOrderContentAfterInsertAtRightChildOfRoot() {
		return new String[] {"A","B","D","H","I","E","J","K","X","C","F","L","M","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"A","X","B","D","H","I","E","J","K","C","F","L","M","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterRootNodeDeletion() {
		return new String[] {"O","B","D","H","I","E","J","K","C","F","L","M","G","N"};
	}
	
	private String[] getPreOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"A","C","F","L","M","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"A","B","D","H","I","E","J","K"};
	}
	
	private String[] getInOrderContentAfterInsertAsRightChildOfRoot() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O","X"};
	}
	
	private String[] getInOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"H","D","I","B","J","E","K","X","A","L","F","M","C","N","G","O"};
	}
	
	private String[] getInOrderContentAfterRootNodeDeletion() {
		return new String[] {"H","D","I","B","J","E","K","O","L","F","M","C","N","G"};
	}
	
	private String[] getInOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"A","L","F","M","C","N","G","O"};
	}
	
	private String[] getInOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"H","D","I","B","J","E","K","A"};
	}
	
	private String[] getPostOrderContentAfterInsertAsRightChildOfRoot() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","C","X","A"};
	}
	
	private String[] getPostOrderContentAfterInsertAsLeftChildOfRoot() {
		return new String[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	private String[] getPostOrderContentAfterRootNodeDeletion() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","G","C","O"};
	}
	
	private String[] getPostOrderContentAfterDeletingLeftChildOfRoot() {
		return new String[] {"L","M","F","N","O","G","C","A"};
	}
	
	private String[] getPostOrderContentAfterDeletingRightChildOfRoot() {
		return new String[] {"H","I","D","J","K","E","B","A"};
	}
	
	private String getInternalNode() {
		return "C";
	}
	
	private String[] getLevelOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","F","X","H","I","J","K","L","M","G","N","O"};
	}
	
	private String[] getLevelOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","X","G","H","I","J","K","F","N","O","L","M"};
	}
	
	private String[] getLevelOrderContentAfterInternalNodeDeletion() {
		return new String[] {"A","B","O","D","E","F","G","H","I","J","K","L","M","N"};
	}
	
	private String[] getLevelOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","G","H","I","J","K","N","O"};
	}
	
	private String[] getLevelOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"A","B","C","D","E","F","H","I","J","K","L","M"};
	}
	
	private String[] getPreOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","M","X","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","X","F","L","M","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterInternalNodeDeletion() {
		return new String[] {"A","B","D","H","I","E","J","K","O","F","L","M","G","N"};
	}
	
	private String[] getPreOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","M"};
	}
	
	private String[] getInOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C","N","G","O","X"};
	}
	
	private String[] getInOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","X","C","N","G","O"};
	}
	
	private String[] getInOrderContentAfterInternalNodeDeletion() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","O","N","G"};
	}
	
	private String[] getInOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","C","N","G","O"};
	}
	
	private String[] getInOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","F","M","C"};
	}
	
	private String[] getPostOrderContentAfterInsertAsRightChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","O","G","X","C","A"};
	}
	
	private String[] getPostOrderContentAfterInsertAsLeftChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","X","N","O","G","C","A"};
	}
	
	private String[] getPostOrderContentAfterInternalNodeDeletion() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","N","G","O","A"};
	}
	
	private String[] getPostOrderContentAfterDeletingLeftChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","N","O","G","C","A"};
	}
	
	private String[] getPostOrderContentAfterDeletingRightChildOfInternalNode() {
		return new String[] {"H","I","D","J","K","E","B","L","M","F","C","A"};
	}
	
	private String getLeafNode() {
		return "L";
	}
	
	private String[] getLevelOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","X"};
	}
	
	private String[] getLevelOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","X"};
	}
	
	private String[] getLevelOrderContentAfterLeafNodeDeletion() {
		return new String[] {"A","B","C","D","E","F","G","H","I","J","K","O","M","N"};
	}
	
	private String[] getPreOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","X","M","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","L","X","M","G","N","O"};
	}
	
	private String[] getPreOrderContentAfterLeafNodeDeletion() {
		return new String[] {"A","B","D","H","I","E","J","K","C","F","O","M","G","N"};
	}
	
	private String[] getInOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"H","D","I","B","J","E","K","A","L","X","F","M","C","N","G","O"};
	}
	
	private String[] getInOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"H","D","I","B","J","E","K","A","X","L","F","M","C","N","G","O"};
	}
	
	private String[] getInOrderContentAfterLeafNodeDeletion() {
		return new String[] {"H","D","I","B","J","E","K","A","O","F","M","C","N","G"};
	}
	
	private String[] getPostOrderContentAfterInsertAsRightChildOfLeafNode() {
		return new String[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	private String[] getPostOrderContentAfterInsertAsLeftChildOfLeafNode() {
		return new String[] {"H","I","D","J","K","E","B","X","L","M","F","N","O","G","C","A"};
	}
	
	private String[] getPostOrderContentAfterLeafNodeDeletion() {
		return new String[] {"H","I","D","J","K","E","B","O","M","F","N","G","C","A"};
	}
	
	private int[] getHeightOfAllNodes() {
		return new int[] {3,2,2,1,1,1,1,0,0,0,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterInsertAsLeftChildOfRoot() {
		return new int[] {4,3,2,2,1,1,1,1,0,0,0,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterInsertAsLeftChildOfInternalNode() {
		return new int[] {4,2,3,1,1,2,1,0,0,0,0,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterInsertAsLeftChildOfLeafNode() {
		return new int[] {4,2,3,1,1,2,1,0,0,0,0,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterInsertAsRightChildOfRoot() {
		return new int[] {4,2,3,1,1,2,0,0,0,0,1,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterInsertAsRightChildOfInternalNode() {
		return new int[] {4,2,3,1,1,1,2,0,0,0,0,0,0,1,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterInsertAsRightChildOfLeafNode() {
		return new int[] {4,2,3,1,1,2,1,0,0,0,0,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingRootNode() {
		return new int[] {3,2,2,1,1,1,1,0,0,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingInternalNode() {
		return new int[] {3,2,2,1,1,1,1,0,0,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingLeafNode() {
		return new int[] {3,2,2,1,1,1,1,0,0,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingLeftChildOfRoot() {
		return new int[] {3,2,1,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingLeftChildOfInternalNode() {
		return new int[] {3,2,2,1,1,1,0,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingRightChildOfRoot() {
		return new int[] {3,2,1,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingRightChildOfInternalNode() {
		return new int[] {3,2,2,1,1,1,0,0,0,0,0,0};
	}
	
	
	@Test
	void testInsert() {
		String[] expected = getTreeContent();
		Tree<String> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodesAfterInsertAsLeftChildOfRoot(), tree);
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
		assertHeights(getHeightOfAllNodesAfterInsertAsLeftChildOfInternalNode(), tree);
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
		assertHeights(getHeightOfAllNodesAfterInsertAsLeftChildOfLeafNode(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodesAfterInsertAsRightChildOfRoot(), tree);
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
		assertHeights(getHeightOfAllNodesAfterInsertAsRightChildOfInternalNode(), tree);
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
		assertHeights(getHeightOfAllNodesAfterInsertAsRightChildOfLeafNode(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingRootNode(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingInternalNode(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingLeafNode(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingLeftChildOfRoot(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingLeftChildOfInternalNode(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingRightChildOfRoot(), tree);
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
		assertHeights(getHeightOfAllNodesAfterDeletingRightChildOfInternalNode(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
		assertHeights(getHeightOfAllNodes(), tree);
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
