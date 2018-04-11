package kar.ds.queue.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import kar.ds.queue.Queue;
import kar.ds.queue.QueueException;

class QueueTest {

	void assertSizeAndContent(int expectedSize, Object[] expectedContent, Queue queue) {
		int size = queue.getSize();
		assertEquals(expectedSize, size);

		Object[] actualContent = queue.traverse();
		if(expectedContent != null)
			assertArrayEquals(expectedContent, actualContent);
		else
			assertNull(actualContent);
	}
	
	@Test
	void testEmptyQueueCreation() {
		Queue queue = new Queue();
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testEnqueueOneItem() {
		Queue queue = new Queue();
		queue.enqueue(0);
		
		assertSizeAndContent(1, new Object[] {0}, queue);
	}
	
	@Test
	void testEnqueueThreeItems() {
		Integer[] content = new Integer[] {0,1,2};
		Queue queue = new Queue();
		for(Integer i : content) {
			queue.enqueue(content[i]);
		}
		
		assertSizeAndContent(3, content, queue);
	}
	
	@Test
	void testDequeueEmptyQueue() {
		Queue queue = new Queue();
		Object data = queue.dequeue();
		
		assertNull(data);
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testDequeueNonEmptyQueue() {
		Integer[] content = new Integer[] {0,1,2};
		Queue queue = new Queue();
		for(Integer i : content) {
			queue.enqueue(content[i]);
		}
		Object data = queue.dequeue();
		
		assertEquals(0, data);
		assertSizeAndContent(2, new Object[] {1,2}, queue);
	}
	
	@Test
	void testDequeueFromQueueHavingOnlyItem() {
		Queue queue = new Queue();
		queue.enqueue(0);
		Object data = queue.dequeue();
		
		assertEquals(0, data);
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testEmptyQueueByDequeingAllItems() {
		Queue queue = new Queue();
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
		Queue queue = new Queue();
		Object data = queue.peek();
		
		assertNull(data);
		assertSizeAndContent(0, null, queue);
	}
	
	@Test
	void testPeekNOnEmptyQueue() {
		Integer[] content = new Integer[] {0,1,2};
		Queue queue = new Queue();
		for(Integer i : content) {
			queue.enqueue(content[i]);
		}
		Object data = queue.peek();
		
		assertEquals(0, data);
		assertSizeAndContent(3, content, queue);
	}
	
	@Test
	void testPeekQueueHavingOnlyItem() {
		Queue queue = new Queue();
		queue.enqueue(0);
		Object data = queue.peek();
		
		assertEquals(0, data);
		assertSizeAndContent(1, new Object[] {0}, queue);
	}
	
	@Test
	void testInsert(){
		Queue queue = new Queue();
		assertThrows(QueueException.class, ()->{queue.insert(0);});
	}
	
	@Test
	void testInsertAt(){
		Queue queue = new Queue();
		assertThrows(QueueException.class, ()->{queue.insertAt(0, 0);});
	}
	
	@Test
	void testDelete(){
		Queue queue = new Queue();
		assertThrows(QueueException.class, ()->{queue.delete(0);});
	}
	
	@Test
	void testDeleteAt(){
		Queue queue = new Queue();
		assertThrows(QueueException.class, ()->{queue.deleteAt(0);});
	}
	
	@Test
	void testUpdate(){
		Queue queue = new Queue();
		assertThrows(QueueException.class, ()->{queue.update(0,0);});
	}
	
	@Test
	void testGetDataAt(){
		Queue queue = new Queue();
		assertThrows(QueueException.class, ()->{queue.getDataAt(0);});
	}

}
