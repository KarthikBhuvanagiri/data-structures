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

	void assertSizeAndContent(int expectedSize, Object[] expectedContent, DoubleLinkedList list) {
		int size = list.getSize();
		assertEquals(expectedSize, size);
		
		if(expectedContent != null) {
			Object[] actualContent = list.traverseForward();
			assertArrayEquals(expectedContent, actualContent);
			
			List expectedContentList = Arrays.asList(expectedContent);
			Collections.reverse(expectedContentList);
			Object[] expectedContentReverse = expectedContentList.toArray();
			Object[] actualContentReverse = list.traverseReverse();
			assertArrayEquals(expectedContentReverse, actualContentReverse);
		}else {
			assertNull(list.traverseForward());
			assertNull(list.traverseReverse());
		}
	}
	
	@Test
	void testIsEmpty() {
		DoubleLinkedList list = new DoubleLinkedList();
		assertSizeAndContent(0, null, list);
	}

	@Test
	void testInsert() {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		
		assertSizeAndContent(3, new Integer[]{0,1,2}, list);
	}

	@Test
	void testInsertAtOnEmptyList() {
		DoubleLinkedList list = new DoubleLinkedList();
		
		boolean isSuccess = list.insertAt(0, 0);
		assertTrue(isSuccess);
		assertSizeAndContent(1, new Object[] {0}, list);
	}
	
	@Test
	void testInsertAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2};
		DoubleLinkedList list = new DoubleLinkedList(content);
		boolean isSuccess = list.insertAt(-1, -1);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testInsertAtIndexZero() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {1,2,3});
		boolean isSuccess = list.insertAt(0, 0);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtIndexTwo() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,3,4});
		boolean isSuccess = list.insertAt(2, 2);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3,4};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtLastIndex() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,4});
		boolean isSuccess = list.insertAt(list.getSize()-1, 3);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3,4};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtIndexEqualsSize() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		boolean isSuccess = list.insertAt(list.getSize(), 4);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content,  list);
	}
	
	@Test
	void testInsertAtIndexGreaterThanSize() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		boolean isSuccess = list.insertAt(list.getSize()+1, 4);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content, list);
	}

	@Test
	void testUpdateAtOnEmptyList() {
		DoubleLinkedList list = new DoubleLinkedList();
		boolean isSuccess = list.update(3, 0);
		
		assertFalse(isSuccess);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testUpdateAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		boolean isSuccess = list.update(-1, -1);
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testUpdateAtIndexZero() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update("0x", 0);
		
		assertTrue(isSuccess);
		Object[] expectedContent = new Object[]{"0x",1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtIndexTwo() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update("2x", 2);
		
		assertTrue(isSuccess);
		Object[] expectedContent = new Object[]{0,1,"2x",3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtLastIndex() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update("3x", list.getSize()-1);
		
		assertTrue(isSuccess);
		Object[] expectedContent = new Object[]{0,1,2,"3x"};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		boolean isSuccess = list.update(4, list.getSize());
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testUpdateAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		boolean isSuccess = list.update(100, list.getSize()+1);
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}

	@Test
	void testDeleteExistingData() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.delete(2);
		
		assertTrue(isSuccess);
		Integer[] expectedContent = new Integer[] {0,1,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteNonExistingData() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.delete(5);
		
		assertFalse(isSuccess);
		Integer[] expectedContent = new Integer[] {0,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}

	@Test
	void testDeleteAtOnEmptyList() {
		DoubleLinkedList list = new DoubleLinkedList();
		Object data = list.deleteAt(0);
		
		assertNull(data);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testDeleteAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		Object data = list.deleteAt(-1);
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtIndexZero() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		Object data = list.deleteAt(0);
		
		assertEquals(0, data);
		Object[] expectedContent = new Object[]{1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent , list);
	}
	
	@Test
	void testDeleteAtIndexTwo() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		Object data = list.deleteAt(2);
		
		assertEquals(2, data);
		Object[] expectedContent = new Object[]{0,1,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteAtLastIndex() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0,1,2,3});
		Object data = list.deleteAt(list.getSize()-1);
		
		assertEquals(3, data);
		Object[] expectedContent = new Object[]{0,1,2};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		Object data = list.deleteAt(list.getSize());
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		Object data = list.deleteAt(list.getSize()+1);
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtOnListWithOneItem() {
		DoubleLinkedList list = new DoubleLinkedList(new Integer[] {0});
		Object data = list.deleteAt(0);
		
		assertEquals(0, data);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testGetDataAtOnEmptyList() {
		DoubleLinkedList list = new DoubleLinkedList();
		
		assertNull(list.getDataAt(0));
		assertSizeAndContent(0, null, list);
	}

	@Test
	void testGetDataAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		
		assertEquals(null, list.getDataAt(-1));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexZero() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		
		assertEquals(0, list.getDataAt(0));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexTwo() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		
		assertEquals(2, list.getDataAt(2));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtLastIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		
		assertEquals(3, list.getDataAt(list.getSize() - 1));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		
		assertEquals(null, list.getDataAt(list.getSize()));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		DoubleLinkedList list = new DoubleLinkedList(content);
		
		assertEquals(null, list.getDataAt(list.getSize() + 1));
		assertSizeAndContent(content.length, content, list);
	}

}
