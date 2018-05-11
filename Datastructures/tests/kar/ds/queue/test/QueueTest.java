package kar.ds.queue.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import kar.ds.queue.Queue;
import kar.ds.queue.QueueException;

class QueueTest {

	void assertSizeAndContent(int expectedSize, Integer[] expectedContent, Queue<Integer> queue) {
		int size = queue.getSize();
		assertEquals(expectedSize, size);

		Integer[] actualContent = queue.traverse();
		if(expectedContent != null)
			assertArrayEquals(expectedContent, actualContent);
		else
			assertNull(actualContent);
	}
	
	@Test
	void testEmptyQueueCreation() {
		Queue<Integer> queue = new Queue<Integer>();
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testEnqueueOneItem() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(0);
		
		assertSizeAndContent(1, new Integer[] {0}, queue);
	}
	
	@Test
	void testEnqueueThreeItems() {
		Integer[] content = new Integer[] {0,1,2};
		Queue<Integer> queue = new Queue<Integer>();
		for(Integer i : content) {
			queue.enqueue(content[i]);
		}
		
		assertSizeAndContent(3, content, queue);
	}
	
	@Test
	void testDequeueEmptyQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		Integer data = queue.dequeue();
		
		assertNull(data);
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testDequeueNonEmptyQueue() {
		Integer[] content = new Integer[] {0,1,2};
		Queue<Integer> queue = new Queue<Integer>();
		for(Integer i : content) {
			queue.enqueue(content[i]);
		}
		Integer data = queue.dequeue();
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(2, new Integer[] {1,2}, queue);
	}
	
	@Test
	void testDequeueFromQueueHavingOnlyItem() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(0);
		Integer data = queue.dequeue();
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testEmptyQueueByDequeingAllItems() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testPeekEmptyQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		Integer data = queue.peek();
		
		assertNull(data);
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testPeekNOnEmptyQueue() {
		Integer[] content = new Integer[] {0,1,2};
		Queue<Integer> queue = new Queue<Integer>();
		for(Integer i : content) {
			queue.enqueue(content[i]);
		}
		Integer data = queue.peek();
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(3, content, queue);
	}
	
	@Test
	void testPeekQueueHavingOnlyItem() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(0);
		Integer data = queue.peek();
		
		assertEquals(Integer.valueOf(0), data);
		assertSizeAndContent(1, new Integer[] {0}, queue);
	}
	
	@Test
	void testInsert(){
		Queue<Integer> queue = new Queue<Integer>();
		assertThrows(QueueException.class, ()->{queue.insert(0);});
	}
	
	@Test
	void testInsertAt(){
		Queue<Integer> queue = new Queue<Integer>();
		assertThrows(QueueException.class, ()->{queue.insertAt(0, 0);});
	}
	
	@Test
	void testDelete(){
		Queue<Integer> queue = new Queue<Integer>();
		assertThrows(QueueException.class, ()->{queue.delete(0);});
	}
	
	@Test
	void testDeleteAt(){
		Queue<Integer> queue = new Queue<Integer>();
		assertThrows(QueueException.class, ()->{queue.deleteAt(0);});
	}
	
	@Test
	void testUpdate(){
		Queue<Integer> queue = new Queue<Integer>();
		assertThrows(QueueException.class, ()->{queue.update(0,0);});
	}
	
	@Test
	void testGetDataAt(){
		Queue<Integer> queue = new Queue<Integer>();
		assertThrows(QueueException.class, ()->{queue.getDataAt(0);});
	}

}
