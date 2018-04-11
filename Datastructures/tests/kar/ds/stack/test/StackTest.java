package kar.ds.stack.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import kar.ds.stack.Stack;
import kar.ds.stack.StackException;

class StackTest {

	void assertSizeAndContent(int expectedSize, Object[] expectedContent, Stack stack) {
		int size = stack.getSize();
		assertEquals(expectedSize, size);

		Object[] actualContent = stack.traverse();
		if(expectedContent != null)
			assertArrayEquals(expectedContent, actualContent);
		else
			assertNull(actualContent);
	}
	
	@Test
	void testEmptyStackCreation() {
		Stack stack = new Stack();
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPushOneItem() {
		Stack stack = new Stack();
		stack.push(0);
		
		assertSizeAndContent(1, new Object[] {0}, stack);
	}
	
	@Test
	void testPushThreeItems() {
		Integer[] content = new Integer[] {0,1,2};
		Stack stack = new Stack();
		for(Integer i : content) {
			stack.push(content[i]);
		}
		
		assertSizeAndContent(3, content, stack);
	}
	
	@Test
	void testPopEmptyStack() {
		Stack stack = new Stack();
		Object data = stack.pop();
		
		assertNull(data);
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPopNonEmptyStack() {
		Integer[] content = new Integer[] {0,1,2};
		Stack stack = new Stack();
		for(Integer i : content) {
			stack.push(content[i]);
		}
		Object data = stack.pop();
		
		assertEquals(2, data);
		assertSizeAndContent(2, new Object[] {0,1}, stack);
	}
	
	@Test
	void testPopFromStackHavingOnlyItem() {
		Stack stack = new Stack();
		stack.push(0);
		Object data = stack.pop();
		
		assertEquals(0, data);
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testEmptyStackByPoppingAllItems() {
		Stack stack = new Stack();
		stack.push(0);
		stack.push(1);
		stack.push(2);

		stack.pop();
		stack.pop();
		stack.pop();
		
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPeekEmptyStack() {
		Stack stack = new Stack();
		Object data = stack.peek();
		
		assertNull(data);
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPeekNOnEmptyStack() {
		Integer[] content = new Integer[] {0,1,2};
		Stack stack = new Stack();
		for(Integer i : content) {
			stack.push(content[i]);
		}
		Object data = stack.peek();
		
		assertEquals(2, data);
		assertSizeAndContent(3, content, stack);
	}
	
	@Test
	void testPeekStackHavingOnlyItem() {
		Stack stack = new Stack();
		stack.push(0);
		Object data = stack.peek();
		
		assertEquals(0, data);
		assertSizeAndContent(1, new Object[] {0}, stack);
	}
	
	@Test
	void testInsert(){
		Stack stack = new Stack();
		assertThrows(StackException.class, ()->{stack.insert(0);});
	}
	
	@Test
	void testInsertAt(){
		Stack stack = new Stack();
		assertThrows(StackException.class, ()->{stack.insertAt(0, 0);});
	}
	
	@Test
	void testDelete(){
		Stack stack = new Stack();
		assertThrows(StackException.class, ()->{stack.delete(0);});
	}
	
	@Test
	void testDeleteAt(){
		Stack stack = new Stack();
		assertThrows(StackException.class, ()->{stack.deleteAt(0);});
	}
	
	@Test
	void testUpdate(){
		Stack stack = new Stack();
		assertThrows(StackException.class, ()->{stack.update(0,0);});
	}
	
	@Test
	void testGetDataAt(){
		Stack stack = new Stack();
		assertThrows(StackException.class, ()->{stack.getDataAt(0);});
	}

}
