package kar.ds.tree.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
	
	private Integer[] getPreOrderContentOfRightSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getInOrderContentOfRightSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getPostOrderContentOfRightSkewedTree() {
		return new Integer[] {30,27,25,19,15,10,7,5,2,1};
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
	
	private Integer[] getTreeContentOfLeftSkewedTree() {
		return new Integer[] {30,27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getPreOrderContentOfLeftSkewedTree() {
		return new Integer[] {30,27,25,19,15,10,7,5,2,1};
	}
	
	private Integer[] getInOrderContentOfLeftSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	private Integer[] getPostOrderContentOfLeftSkewedTree() {
		return new Integer[] {1,2,5,7,10,15,19,25,27,30};
	}
	
	@Test
	void testInsert() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContent(), tree);
		assertInOrderContent(getInOrderContent(), tree);
		assertPostOrderContent(getPostOrderContent(), tree);
	}
	
	@Test
	void testInsertAscendingOrder() {
		Integer[] expected = getRightSkewedTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContentOfRightSkewedTree(), tree);
		assertInOrderContent(getInOrderContentOfRightSkewedTree(), tree);
		assertPostOrderContent(getPostOrderContentOfRightSkewedTree(), tree);
	}
	
	@Test
	void testInsertDescendingOrder() {
		Integer[] expected = getTreeContentOfLeftSkewedTree();
		Tree<Integer> tree = createTree(expected);
		assertLevelOrderContent(expected, tree);
		assertPreOrderContent(getPreOrderContentOfLeftSkewedTree(), tree);
		assertInOrderContent(getInOrderContentOfLeftSkewedTree(), tree);
		assertPostOrderContent(getPostOrderContentOfLeftSkewedTree(), tree);
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
	void testDeleteRootNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		tree.delete(getRootNode());
		assertLevelOrderContent(getLevelOrderContentAfterRootNodeDeletion(), tree);
		assertPreOrderContent(getPreOrderContentAfterRootNodeDeletion(), tree);
		assertInOrderContent(getInOrderContentAfterRootNodeDeletion(), tree);
		assertPostOrderContent(getPostOrderContentAfterRootNodeDeletion(), tree);
	}
	
	@Test
	void tesDeleteRootNodeInRightSkewedTree() {
		
	}
	
	@Test
	void tesDeleteRootNodeInLeftSkewedTree() {
		
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
	}
	
	@Test
	void testDeleteInternalNodeInRightSkewedTree() {
		
	}
	
	@Test
	void testDeleteInternalNodeInLeftSkewedTree() {
		
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
	}
	
	@Test
	void testDeleteLeafNodeInRightSkewedTree() {
		
	}
	
	@Test
	void testDeleteLeafNodeInLeftSkewedTree() {
		
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
		
	}
	
	void testSearchRootNodeInLeftSkewedTree() {
		
	}
	
	@Test
	void testSearchInternalNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getInternalNode()));
	}
	
	@Test
	void testSearchInternalNodeInRightSkewedTree() {
		
	}
	
	void testSearchInternalNodeInLeftSkewedTree() {
		
	}
	
	@Test
	void testSearchLeafNode() {
		Integer[] expected = getTreeContent();
		Tree<Integer> tree = createTree(expected);
		assertTrue(tree.search(getLeafNode()));
	}
	
	@Test
	void testSearchLeafNodeInRightSkewedTree() {
		
	}
	
	void testSearchLeafNodeInLeftSkewedTree() {
		
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

}
