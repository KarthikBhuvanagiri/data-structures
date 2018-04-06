package kar.ds.linkedlist.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import kar.ds.linkedlist.SingleLinkedList;

class SingleLinkedListTest {

	void assertSizeAndContent(int expectedSize, Object[] expectedContent, SingleLinkedList list) {
		int size = list.getSize();
		assertEquals(expectedSize, size);

		Object[] actualContent = list.traverse();
		if(expectedContent != null)
			assertArrayEquals(expectedContent, actualContent);
		else
			assertNull(actualContent);
	}
	
	@Test
	void testIsEmpty() {
		SingleLinkedList list = new SingleLinkedList();
		assertSizeAndContent(0, null, list);
	}

	@Test
	void testInsert() {
		SingleLinkedList list = new SingleLinkedList();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		
		assertSizeAndContent(3, new Integer[]{0,1,2}, list);
	}

	@Test
	void testInsertAtOnEmptyList() {
		SingleLinkedList list = new SingleLinkedList();
		
		boolean isSuccess = list.insertAt(0, 0);
		assertTrue(isSuccess);
		assertSizeAndContent(1, new Object[] {0}, list);
	}
	
	@Test
	void testInsertAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2};
		SingleLinkedList list = new SingleLinkedList(content);
		boolean isSuccess = list.insertAt(-1, -1);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testInsertAtIndexZero() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {1,2,3});
		boolean isSuccess = list.insertAt(0, 0);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtIndexTwo() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,3,4});
		boolean isSuccess = list.insertAt(2, 2);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3,4};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtLastIndex() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,4});
		boolean isSuccess = list.insertAt(list.getSize()-1, 3);
		assertTrue(isSuccess);
		
		Integer[] expectedContent = new Integer[]{0,1,2,3,4};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testInsertAtIndexEqualsSize() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		boolean isSuccess = list.insertAt(list.getSize(), 4);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content,  list);
	}
	
	@Test
	void testInsertAtIndexGreaterThanSize() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		boolean isSuccess = list.insertAt(list.getSize()+1, 4);
		assertFalse(isSuccess);
		
		assertSizeAndContent(content.length, content, list);
	}

	@Test
	void testUpdateEmptyList() {
		SingleLinkedList list = new SingleLinkedList();
		boolean isSuccess = list.update(1, 0);
		
		assertFalse(isSuccess);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testUpdateAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		boolean isSuccess = list.update(-1, -1);
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testUpdateAtIndexZero() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update("0x", 0);
		
		assertTrue(isSuccess);
		Object[] expectedContent = new Object[]{"0x",1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtIndexTwo() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update("2x", 2);
		
		assertTrue(isSuccess);
		Object[] expectedContent = new Object[]{0,1,"2x",3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtLastIndex() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.update("3x", list.getSize()-1);
		
		assertTrue(isSuccess);
		Object[] expectedContent = new Object[]{0,1,2,"3x"};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testUpdateAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		boolean isSuccess = list.update(4, list.getSize());
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testUpdateAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		boolean isSuccess = list.update(100, list.getSize()+1);
		
		assertFalse(isSuccess);
		assertSizeAndContent(content.length, content, list);
	}

	@Test
	void testDeleteExistingData() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.delete(2);
		
		assertTrue(isSuccess);
		Integer[] expectedContent = new Integer[] {0,1,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteNonExistingData() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		boolean isSuccess = list.delete(5);
		
		assertFalse(isSuccess);
		Integer[] expectedContent = new Integer[] {0,1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}

	@Test
	void testDeleteAtOnEmptyList() {
		SingleLinkedList list = new SingleLinkedList();
		Object data = list.deleteAt(0);
		
		assertNull(data);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testDeleteAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		Object data = list.deleteAt(-1);
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtIndexZero() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		Object data = list.deleteAt(0);
		
		assertEquals(0, data);
		Object[] expectedContent = new Object[]{1,2,3};
		assertSizeAndContent(expectedContent.length, expectedContent , list);
	}
	
	@Test
	void testDeleteAtIndexTwo() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		Object data = list.deleteAt(2);
		
		assertEquals(2, data);
		Object[] expectedContent = new Object[]{0,1,3};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteAtLastIndex() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0,1,2,3});
		Object data = list.deleteAt(list.getSize()-1);
		
		assertEquals(3, data);
		Object[] expectedContent = new Object[]{0,1,2};
		assertSizeAndContent(expectedContent.length, expectedContent, list);
	}
	
	@Test
	void testDeleteAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		Object data = list.deleteAt(list.getSize());
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		Object data = list.deleteAt(list.getSize()+1);
		
		assertNull(data);
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testDeleteAtOnListWithOneItem() {
		SingleLinkedList list = new SingleLinkedList(new Integer[] {0});
		Object data = list.deleteAt(0);
		
		assertEquals(0, data);
		assertSizeAndContent(0, null, list);
	}
	
	@Test
	void testGetDataAtOnEmptyList() {
		SingleLinkedList list = new SingleLinkedList();
		
		assertNull(list.getDataAt(0));
		assertSizeAndContent(0, null, list);
	}

	@Test
	void testGetDataAtNegativeIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		
		assertEquals(null, list.getDataAt(-1));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexZero() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		
		assertEquals(0, list.getDataAt(0));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexTwo() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		
		assertEquals(2, list.getDataAt(2));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtLastIndex() {
		Integer[] content = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		
		assertEquals(3, list.getDataAt(list.getSize() - 1));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexEqualsSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		
		assertEquals(null, list.getDataAt(list.getSize()));
		assertSizeAndContent(content.length, content, list);
	}
	
	@Test
	void testGetDataAtIndexGreaterThanSize() {
		Integer content[] = new Integer[] {0,1,2,3};
		SingleLinkedList list = new SingleLinkedList(content);
		
		assertEquals(null, list.getDataAt(list.getSize() + 1));
		assertSizeAndContent(content.length, content, list);
	}

}
