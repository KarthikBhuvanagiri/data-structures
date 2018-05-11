package kar.ds.linkedlist.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import kar.ds.linkedlist.DoubleLinkedList;

class DoubleLinkedListTest {

	void assertSizeAndContent(int expectedSize, Integer[] expectedContent, DoubleLinkedList<Integer> list) {
		int size = list.getSize();
		assertEquals(expectedSize, size);
		
		if(expectedContent != null) {
			Integer[] actualContent = list.traverseForward();
			assertArrayEquals(expectedContent, actualContent);
			
			List<Integer> expectedContentList = Arrays.asList(expectedContent);
			Collections.reverse(expectedContentList);
			Integer[] expectedContentReverse = (Integer[]) expectedContentList.toArray();
			Integer[] actualContentReverse = list.traverseReverse();
			assertArrayEquals(expectedContentReverse, actualContentReverse);
		}else {
			assertNull(list.traverseForward());
			assertNull(list.traverseReverse());
		}
	}
	
	@Test
	void testIsEmpty() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		assertSizeAndContent(0, null, list);
	}

	@Test
	void testInsert() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		
		assertSizeAndContent(3, new Integer[]{0,1,2}, list);
	}

	@Test
	void testInsertAtOnEmptyList() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		boolean isSuccess = list.insertAt(0, 0);
		assertTrue(isSuccess);
		assertSizeAndContent(1, new Integer[] {0}, list);
	}
	
	@Test
	void testInsertAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		boolean isSuccess = list.insertAt(-1, -1);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testInsertAtIndexZero() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {1,2,3});
		boolean isSuccess = list.insertAt(0, 0);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtIndexTwo() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,3,4});
		boolean isSuccess = list.insertAt(2, 2);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3,4};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtLastIndex() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,4});
		boolean isSuccess = list.insertAt(list.getSize()-1, 3);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3,4};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtIndexEqualsSize() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		boolean isSuccess = list.insertAt(list.getSize(), 4);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content,  list);
	}
	
	@Test
	void testInsertAtIndexGreaterThanSize() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		boolean isSuccess = list.insertAt(list.getSize()+1, 4);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content, list);
	}

	@Test
	void testUpdateAtOnEmptyList() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		boolean isSuccess = list.update(3, 0);
		
		assertFalse(isSuccess);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testUpdateAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		boolean isSuccess = list.update(-1, -1);
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testUpdateAtIndexZero() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update(-1, 0);
		
		assertTrue(isSuccess);
		Integer[] expectedContent = new Integer[]{-1,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtIndexTwo() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update(-2, 2);
		
		assertTrue(isSuccess);
		Integer[] expectedContent = new Integer[]{0,1,-2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtLastIndex() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update(-3, list.getSize()-1);
		
		assertTrue(isSuccess);
		Integer[] expectedContent = new Integer[]{0,1,2,-3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		boolean isSuccess = list.update(4, list.getSize());
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testUpdateAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		boolean isSuccess = list.update(100, list.getSize()+1);
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}

	@Test
	void testDeleteExistingData() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		boolean isSuccess = list.delete(2);
		
		assertTrue(isSuccess);
		Integer[] expectedContent = new Integer[] {0,1,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteNonExistingData() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		boolean isSuccess = list.delete(5);
		
		assertFalse(isSuccess);
		Integer[] expectedContent = new Integer[] {0,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}

	@Test
	void testDeleteAtOnEmptyList() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		Integer data = list.deleteAt(0);
		
		assertNull(data);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testDeleteAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		Integer data = list.deleteAt(-1);
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtIndexZero() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		Integer data = list.deleteAt(0);
		
		assertEquals(Integer.valueOf(0), data);
		Integer[] expectedContent = new Integer[]{1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent , list);
	}
	
	@Test
	void testDeleteAtIndexTwo() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		Integer data = list.deleteAt(2);
		
		assertEquals(Integer.valueOf(2), data);
		Integer[] expectedContent = new Integer[]{0,1,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteAtLastIndex() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0,1,2,3});
		Integer data = list.deleteAt(list.getSize()-1);
		
		assertEquals(Integer.valueOf(3), data);
		Integer[] expectedContent = new Integer[]{0,1,2};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		Integer data = list.deleteAt(list.getSize());
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		Integer data = list.deleteAt(list.getSize()+1);
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtOnListWithOneItem() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(new Integer[] {0});
		Integer data = list.deleteAt(0);
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testGetDataAtOnEmptyList() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		assertNull(list.getDataAt(0));
		assertSizeAndContent(0, null, list);
	}

	@Test
	void testGetDataAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		
		assertEquals(null, list.getDataAt(-1));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexZero() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		
		assertEquals(Integer.valueOf(0), list.getDataAt(0));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexTwo() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		
		assertEquals(Integer.valueOf(2), list.getDataAt(2));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtLastIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		
		assertEquals(Integer.valueOf(3), list.getDataAt(list.getSize() - 1));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		
		assertEquals(null, list.getDataAt(list.getSize()));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>(content);
		
		assertEquals(null, list.getDataAt(list.getSize() + 1));
		assertSizeAndContent(content.length, content, list);
	}

}
