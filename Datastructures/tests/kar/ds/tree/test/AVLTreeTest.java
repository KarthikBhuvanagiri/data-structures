package kar.ds.tree.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import kar.ds.tree.AVLTree;
import kar.ds.tree.Tree;

class AVLTreeTest {

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

	@Test
	void testInsertRightRotateRootNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {15,10,20,5,12,3};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {10,5,15,3,12,20}, tree);
		assertPreOrderContent(new Integer[] {10,5,3,15,12,20}, tree);
		assertInOrderContent(new Integer[] {3,5,10,12,15,20}, tree);
		assertPostOrderContent(new Integer[] {3,5,12,20,15,10}, tree);
		//assertHeights(new int[] {2,1,1,0,0,0}, tree);
	}
	
	@Test
	void testInsertRightRotateInternalNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {28,15,30,10,20,32,5,12,3};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {28,10,30,5,15,32,3,12,20}, tree);
		assertPreOrderContent(new Integer[] {28,10,5,3,15,12,20,30,32}, tree);
		assertInOrderContent(new Integer[] {3,5,10,12,15,20,28,30,32}, tree);
		assertPostOrderContent(new Integer[] {3,5,12,20,15,10,32,30,28}, tree);
	}
	
	@Test
	void testInsertLeftRotateRightRotateRootNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {15,10,20,5,12,13};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {12,10,15,5,13,20}, tree);
		assertPreOrderContent(new Integer[] {12,10,5,15,13,20}, tree);
		assertInOrderContent(new Integer[] {5,10,12,13,15,20}, tree);
		assertPostOrderContent(new Integer[] {5,10,13,20,15,12}, tree);
	}
	
	@Test
	void testInsertLeftRotateRightRotateInternalNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {28,15,30,10,20,32,5,12,13};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {28,12,30,10,15,32,5,13,20}, tree);
		assertPreOrderContent(new Integer[] {28,12,10,5,15,13,20,30,32}, tree);
		assertInOrderContent(new Integer[] {5,10,12,13,15,20,28,30,32}, tree);
		assertPostOrderContent(new Integer[] {5,10,13,20,15,12,32,30,28}, tree);
	}
	
	@Test
	void testInsertLeftRotateRootNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {10,5,18,15,20,23};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {18,10,20,5,15,23}, tree);
		assertPreOrderContent(new Integer[] {18,10,5,15,20,23}, tree);
		assertInOrderContent(new Integer[] {5,10,15,18,20,23}, tree);
		assertPostOrderContent(new Integer[] {5,15,10,23,20,18}, tree);
	}
	
	@Test
	void testInsertLeftRotateInternalNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {4,3,10,2,5,18,15,20,23};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {4,3,18,2,10,20,5,15,23}, tree);
		assertPreOrderContent(new Integer[] {4,3,2,18,10,5,15,20,23}, tree);
		assertInOrderContent(new Integer[] {2,3,4,5,10,15,18,20,23}, tree);
		assertPostOrderContent(new Integer[] {2,3,5,15,10,23,20,18,4}, tree);
	}
	
	@Test
	void testInsertRightRotateLeftRotateRootNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {10,5,18,15,20,13};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {15,10,18,5,13,20}, tree);
		assertPreOrderContent(new Integer[] {15,10,5,13,18,20}, tree);
		assertInOrderContent(new Integer[] {5,10,13,15,18,20}, tree);
		assertPostOrderContent(new Integer[] {5,13,10,20,18,15}, tree);
	}
	
	@Test
	void testInsertRightRotateLeftRotateInternalNode() {
		Tree<Integer> tree = new AVLTree<>();
		int[] nodes = new int[] {4,3,10,2,5,18,15,20,13};
		for(int node : nodes) {
			tree.insert(node);
		}
		assertLevelOrderContent(new Integer[] {4,3,15,2,10,18,5,13,20}, tree);
		assertPreOrderContent(new Integer[] {4,3,2,15,10,5,13,18,20}, tree);
		assertInOrderContent(new Integer[] {2,3,4,5,10,13,15,18,20}, tree);
		assertPostOrderContent(new Integer[] {2,3,5,13,10,20,18,15,4}, tree);
	}
}
