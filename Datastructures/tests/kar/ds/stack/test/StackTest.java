package kar.ds.stack.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import kar.ds.stack.Stack;
import kar.ds.stack.StackException;

class StackTest {

	void assertSizeAndContent(int expectedSize, Integer[] expectedContent, Stack<Integer> stack) {
		int size = stack.getSize();
		assertEquals(expectedSize, size);

		Integer[] actualContent = stack.traverse();
		if(expectedContent != null)
			assertArrayEquals(expectedContent, actualContent);
		else
			assertNull(actualContent);
	}
	
	@Test
	void testEmptyStackCreation() {
		Stack<Integer> stack = new Stack<Integer>();
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPushOneItem() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		assertSizeAndContent(1, new Integer[] {0}, stack);
	}
	
	@Test
	void testPushThreeItems() {
		Integer[] content = new Integer[] {0,1,2};
		Stack<Integer> stack = new Stack<Integer>();
		for(Integer i : content) {
			stack.push(content[i]);
		}
		
		assertSizeAndContent(3, content, stack);
	}
	
	@Test
	void testPopEmptyStack() {
		Stack<Integer> stack = new Stack<Integer>();
		Integer data = stack.pop();
		
		assertNull(data);
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPopNonEmptyStack() {
		Integer[] content = new Integer[] {0,1,2};
		Stack<Integer> stack = new Stack<Integer>();
		for(Integer i : content) {
			stack.push(content[i]);
		}
		Integer data = stack.pop();
		
		assertEquals(Integer.valueOf(2), data);
		assertSizeAndContent(2, new Integer[] {0,1}, stack);
	}
	
	@Test
	void testPopFromStackHavingOnlyItem() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		Integer data = stack.pop();
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testEmptyStackByPoppingAllItems() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);

		stack.pop();
		stack.pop();
		stack.pop();
		
		assertSizeAndContent(Integer.valueOf(0), null, stack);
	}
	
	@Test
	void testPeekEmptyStack() {
		Stack<Integer> stack = new Stack<Integer>();
		Integer data = stack.peek();
		
		assertNull(data);
		assertSizeAndContent(0, null, stack);
	}
	
	@Test
	void testPeekNOnEmptyStack() {
		Integer[] content = new Integer[] {0,1,2};
		Stack<Integer> stack = new Stack<Integer>();
		for(Integer i : content) {
			stack.push(content[i]);
		}
		Integer data = stack.peek();
		
		assertEquals(Integer.valueOf(2), data);
		assertSizeAndContent(3, content, stack);
	}
	
	@Test
	void testPeekStackHavingOnlyItem() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		Integer data = stack.peek();
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(1, new Integer[] {0}, stack);
	}
	
	@Test
	void testInsert(){
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(StackException.class, ()->{stack.insert(0);});
	}
	
	@Test
	void testInsertAt(){
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(StackException.class, ()->{stack.insertAt(0, 0);});
	}
	
	@Test
	void testDelete(){
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(StackException.class, ()->{stack.delete(0);});
	}
	
	@Test
	void testDeleteAt(){
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(StackException.class, ()->{stack.deleteAt(0);});
	}
	
	@Test
	void testUpdate(){
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(StackException.class, ()->{stack.update(0,0);});
	}
	
	@Test
	void testGetDataAt(){
		Stack<Integer> stack = new Stack<Integer>();
		assertThrows(StackException.class, ()->{stack.getDataAt(0);});
	}

}
