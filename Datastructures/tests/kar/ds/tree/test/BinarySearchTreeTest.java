package kar.ds.tree.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import kar.ds.tree.BinarySearchTree;
import kar.ds.tree.Tree;

class BinarySearchTreeTest {


	private void assertLevelOrderContent(Integer[] expected, Tree<Integer> tree) {
		Integer[] actual = tree.traverseLevelOrder();
		assertArrayEquals(expected, actual);
	}
	
	private void assertPreOrderContent(Integer[] expected, Tree<Integer> tree) {
		Integer[] actual = tree.traversePreOrder();
		assertArrayEquals(expected, actual);
	}
	
	private void assertInOrderContent(Integer[] expected, Tree<Integer> tree) {
		Integer[] actual = tree.traverseInOrder();
		assertArrayEquals(expected, actual);;
	}
	
	private void assertPostOrderContent(Integer[] expected, Tree<Integer> tree) {
		Integer[] actual = tree.traversePostOrder();
		assertArrayEquals(expected, actual);
	}
	
	private void assertHeights(int[] expectedHeights, Tree<Integer> tree) {
		Integer[] keys = tree.traverseLevelOrder();
		for(int i=0; i<keys.length; i++) {
			assertEquals(expectedHeights[i], tree.getHeightOf(keys[i]));
		}
	}
	
	private Tree<Integer> createTree(Integer[] nodes) {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		if(nodes != null) {
			for(Integer node : nodes) {
				tree.insert(node);
			}
		}
		return tree;
	}
	
	private Tree<Integer> createEmptyTree() {
		return new BinarySearchTree<Integer>();
	}
	
	private Integer[] getTreeContent() {
		return new Integer[] {11,6,19,3,8,17,43,2,5,7,10,15,18,31,49,4,16,20};
	}
	
	private Integer[] getPreOrderContent() {
		return new Integer[] {11,6,3,2,5,4,8,7,10,19,17,15,16,18,43,31,20,49};
	}
	
	private Integer[] getInOrderContent() {
		return new Integer[] {2,3,4,5,6,7,8,10,11,15,16,17,18,19,20,31,43,49};
	}
	
	private Integer[] getPostOrderContent() {
		return new Integer[] {2,4,5,3,7,10,8,6,16,15,18,17,20,31,49,43,19,11};
	}
	
	private Integer getRootNode() {
		return 11;
	}
	
	private Integer[] getLevelOrderContentAfterRootNodeDeletion() {
		return new Integer[] {15,6,19,3,8,17,43,2,5,7,10,16,18,31,49,4,20};
	}
	
	private Integer[] getPreOrderContentAfterRootNodeDeletion() {
		return new Integer[] {15,6,3,2,5,4,8,7,10,19,17,16,18,43,31,20,49};
	}
	
	private Integer[] getInOrderContentAfterRootNodeDeletion() {
		return new Integer[] {2,3,4,5,6,7,8,10,15,16,17,18,19,20,31,43,49};
	}
	
	private Integer[] getPostOrderContentAfterRootNodeDeletion() {
		return new Integer[] {2,4,5,3,7,10,8,6,16,18,17,20,31,49,43,19,15};
	}
	
	private Integer getInternalNode() {
		return 19;
	}
	
	private Integer[] getLevelOrderContentAfterInternalNodeDeletion() {
		return new Integer[] {11,6,20,3,8,17,43,2,5,7,10,15,18,31,49,4,16};
	}
	
	private Integer[] getPreOrderContentAfterInternalNodeDeletion() {
		return new Integer[] {11,6,3,2,5,4,8,7,10,20,17,15,16,18,43,31,49};
	}
	
	private Integer[] getInOrderContentAfterInternalNodeDeletion() {
		return new Integer[] {2,3,4,5,6,7,8,10,11,15,16,17,18,20,31,43,49};
	}
	
	private Integer[] getPostOrderContentAfterInternalNodeDeletion() {
		return new Integer[] {2,4,5,3,7,10,8,6,16,15,18,17,31,49,43,20,11};
	}
	
	private Integer getLeafNode() {
		return 7;
	}
	
	private Integer[] getLevelOrderContentAfterLeafNodeDeletion() {
		return new Integer[] {11,6,19,3,8,17,43,2,5,10,15,18,31,49,4,16,20};
	}
	
	private Integer[] getPreOrderContentAfterLeafNodeDeletion() {
		return new Integer[] {11,6,3,2,5,4,8,10,19,17,15,16,18,43,31,20,49};
	}
	
	private Integer[] getInOrderContentAfterLeafNodeDeletion() {
		return new Integer[] {2,3,4,5,6,8,10,11,15,16,17,18,19,20,31,43,49};
	}
	
	private Integer[] getPostOrderContentAfterLeafNodeDeletion() {
		return new Integer[] {2,4,5,3,10,8,6,16,15,18,17,20,31,49,43,19,11};
	}
	
	private Integer getRootNodeInRightSkewedTree() {
		return 1;
	}
	
	private Integer getInternalNodeInRightSkewedTree() {
		return 10;
	}
	
	private Integer getLeafNodeInRightSkewedTree() {
		return 30;
	}
	
	private Integer[] getRightSkewedTreeContent() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getLevelOrderContentOfRightSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getLevelOrderContentOfRightSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {1,2,5,7,15,19,25,27,30};
	}
	
	private Integer[] getLevelOrderContentOfRightSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {1,2,5,7,10,15,19,25,27};
	}
	
	private Integer[] getPreOrderContentOfRightSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getPreOrderContentOfRightSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getPreOrderContentOfRightSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {1,2,5,7,15,19,25,27,30};
	}
	
	private Integer[] getPreOrderContentOfRightSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {1,2,5,7,10,15,19,25,27};
	}
	
	private Integer[] getInOrderContentOfRightSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getInOrderContentOfRightSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getInOrderContentOfRightSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {1,2,5,7,15,19,25,27,30};
	}
	
	private Integer[] getInOrderContentOfRightSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {1,2,5,7,10,15,19,25,27};
	}
	
	private Integer[] getPostOrderContentOfRightSkewedTree() {
		return new Integer[] {30,27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getPostOrderContentOfRightSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {30,27,25,19,15,10,7,5,2};
	}
	
	private Integer[] getPostOrderContentOfRightSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {30,27,25,19,15,7,5,2,1};
	}
	
	private Integer[] getPostOrderContentOfRightSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {27,25,19,15,10,7,5,2,1};
	}
	
	private Integer getRootNodeInLeftSkewedTree() {
		return 30;
	}
	
	private Integer getInternalNodeInLeftSkewedTree() {
		return 15;
	}
	
	private Integer getLeafNodeInLeftSkewedTree() {
		return 1;
	}
	
	private Integer[] getLeftSkewedTreeContent() {
		return new Integer[] {30,27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getLevelOrderContentOfLeftSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getLevelOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {30,27,25,19,10,7,5,2,1};
	}
	
	private Integer[] getLevelOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {30,27,25,19,15,10,7,5,2};
	}
	
	private Integer[] getPreOrderContentOfLeftSkewedTree() {
		return new Integer[] {30,27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getPreOrderContentOfLeftSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getPreOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {30,27,25,19,10,7,5,2,1};
	}
	
	private Integer[] getPreOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {30,27,25,19,15,10,7,5,2};
	}
	
	private Integer[] getInOrderContentOfLeftSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getInOrderContentOfLeftSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {1,2,5,7,10,15,19,25,27};
	}
	
	private Integer[] getInOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {1,2,5,7,10,19,25,27,30};
	}
	
	private Integer[] getInOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getPostOrderContentOfLeftSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getPostOrderContentOfLeftSkewedTreeAfterRootNodeDeletion() {
		return new Integer[] {1,2,5,7,10,15,19,25,27};
	}
	
	private Integer[] getPostOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion() {
		return new Integer[] {1,2,5,7,10,19,25,27,30};
	}
	
	private Integer[] getPostOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion() {
		return new Integer[] {2,5,7,10,15,19,25,27,30};
	}
	
	private int[] getHeightOfAllNodes() {
		return new int[] {4,3,3,2,1,2,2,0,1,0,0,1,0,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingRootNode() {
		return new int[] {4,3,3,2,1,1,2,0,1,0,0,0,0,1,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingInternalNode() {
		return new int[] {4,3,3,2,1,2,1,0,1,0,0,1,0,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesAfterDeletingLeafNode() {
		return new int[] {4,3,3,2,1,2,2,0,1,0,1,0,1,0,0,0,0};
	}
	
	private int[] getHeightOfAllNodesInLeftSkewedTree() {
		return new int[] {9,8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInLeftSkewedTreeAfterRootNodeDeletion() {
		return new int[] {8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInLeftSkewedTreeAfterInternalNodeDeletion() {
		return new int[] {8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInLeftSkewedTreeAfterLeafNodeDeletion() {
		return new int[] {8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInRightSkewedTree() {
		return new int[] {9,8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInRightSkewedTreeAfterRootNodeDeletion() {
		return new int[] {8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInRightSkewedTreeAfterInternalNodeDeletion() {
		return new int[] {8,7,6,5,4,3,2,1,0};
	}
	
	private int[] getHeightOfAllNodesInRightSkewedTreeAfterLeafNodeDeletion() {
		return new int[] {8,7,6,5,4,3,2,1,0};
	}
	
	@Test
	void testInsert() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
		assertHeights(getHeightOfAllNodes(), tree);
	}
	
	@Test
	void testInsertAscendingOrder() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContentOfRightSkewedTree(), tree);
		assertInOrderContent(getInOrderContentOfRightSkewedTree(), tree);
		assertPostOrderContent(getPostOrderContentOfRightSkewedTree(), tree);
		assertHeights(getHeightOfAllNodesInRightSkewedTree(), tree);
	}
	
	@Test
	void testInsertDescendingOrder() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContentOfLeftSkewedTree(), tree);
		assertInOrderContent(getInOrderContentOfLeftSkewedTree(), tree);
		assertPostOrderContent(getPostOrderContentOfLeftSkewedTree(), tree);
		assertHeights(getHeightOfAllNodesInLeftSkewedTree(), tree);
	}
	
	@Test
	void testDeleteNodeFromEmptyTree() {
		Tree<Integer> tree = createTree(null);
		tree.delete(100);
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}
	
	@Test
	void testDeleteNodeFromTreeWithSingleNode() {
		Tree<Integer> tree = createTree(null);
		tree.insert(10);
		tree.delete(10);
		assertLevelOrderContent(null, tree);
		assertPreOrderContent(null, tree);
		assertInOrderContent(null, tree);
		assertPostOrderContent(null, tree);
	}

	@Test
	void testDeleteRootNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterRootNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterRootNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterRootNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterRootNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesAfterDeletingRootNode(), tree);
	}
	
	@Test
	void tesDeleteRootNodeInRightSkewedTree() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getRootNodeInRightSkewedTree());
		assertLevelOrderContent(getLevelOrderContentOfRightSkewedTreeAfterRootNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentOfRightSkewedTreeAfterRootNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentOfRightSkewedTreeAfterRootNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentOfRightSkewedTreeAfterRootNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesInRightSkewedTreeAfterRootNodeDeletion(), tree);
	}
	
	@Test
	void tesDeleteRootNodeInLeftSkewedTree() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getRootNodeInLeftSkewedTree());
		assertLevelOrderContent(getLevelOrderContentOfLeftSkewedTreeAfterRootNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentOfLeftSkewedTreeAfterRootNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentOfLeftSkewedTreeAfterRootNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentOfLeftSkewedTreeAfterRootNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesInLeftSkewedTreeAfterRootNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteInternalNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getInternalNode());
		assertLevelOrderContent(getLevelOrderContentAfterInternalNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterInternalNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterInternalNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterInternalNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesAfterDeletingInternalNode(), tree);
	}
	
	@Test
	void testDeleteInternalNodeInRightSkewedTree() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getInternalNodeInRightSkewedTree());
		assertLevelOrderContent(getLevelOrderContentOfRightSkewedTreeAfterInternalNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentOfRightSkewedTreeAfterInternalNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentOfRightSkewedTreeAfterInternalNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentOfRightSkewedTreeAfterInternalNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesInRightSkewedTreeAfterInternalNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteInternalNodeInLeftSkewedTree() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getInternalNodeInLeftSkewedTree());
		assertLevelOrderContent(getLevelOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentOfLeftSkewedTreeAfterInternalNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesInLeftSkewedTreeAfterInternalNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteLeafNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getLeafNode());
		assertLevelOrderContent(getLevelOrderContentAfterLeafNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterLeafNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterLeafNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterLeafNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesAfterDeletingLeafNode(), tree);
	}
	
	@Test
	void testDeleteLeafNodeInRightSkewedTree() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getLeafNodeInRightSkewedTree());
		assertLevelOrderContent(getLevelOrderContentOfRightSkewedTreeAfterLeafNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentOfRightSkewedTreeAfterLeafNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentOfRightSkewedTreeAfterLeafNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentOfRightSkewedTreeAfterLeafNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesInRightSkewedTreeAfterLeafNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteLeafNodeInLeftSkewedTree() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getLeafNodeInLeftSkewedTree());
		assertLevelOrderContent(getLevelOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentOfLeftSkewedTreeAfterLeafNodeDeletion(), tree);
		assertHeights(getHeightOfAllNodesInLeftSkewedTreeAfterLeafNodeDeletion(), tree);
	}
	
	@Test
	void testDeleteNonExistentNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(100);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
		assertHeights(getHeightOfAllNodes(), tree);
	}
	
	@Test
	void testSearchNodeInEmptyTree() {
		Tree<Integer> tree = createTree(null);
		assertFalse(tree.search(100));
	}

	@Test
	void testSearchRootNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getRootNode()));
	}
	
	@Test
	void testSearchRootNodeInRightSkewedTree() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getRootNodeInRightSkewedTree()));
	}
	
	@Test
	void testSearchRootNodeInLeftSkewedTree() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getRootNodeInLeftSkewedTree()));
	}
	
	@Test
	void testSearchInternalNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getInternalNode()));
	}
	
	@Test
	void testSearchInternalNodeInRightSkewedTree() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getInternalNodeInRightSkewedTree()));
	}
	
	@Test
	void testSearchInternalNodeInLeftSkewedTree() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getInternalNodeInLeftSkewedTree()));
	}
	
	@Test
	void testSearchLeafNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getLeafNode()));
	}
	
	@Test
	void testSearchLeafNodeInRightSkewedTree() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getLeafNodeInRightSkewedTree()));
	}
	
	@Test
	void testSearchLeafNodeInLeftSkewedTree() {
		Integer[] expected = getLeftSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getLeafNodeInLeftSkewedTree()));
	}
	
	@Test
	void testSearchNonExistentNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertFalse(tree.search(100));
	}

	@Test
	void testIsEmpty() {
		Tree<Integer> tree = createEmptyTree();
		assertTrue(tree.isEmpty());
	}
	
	@Test
	void testHeightOfNonExistentNode() {
		Tree<Integer> tree = createTree(getTreeContent());
		int height = tree.getHeightOf(0);
		assertEquals(-1, height);
	}
}
