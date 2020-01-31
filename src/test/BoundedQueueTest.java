/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import arc180006.BoundedQueue;

/**
 * @author cuong
 *
 */
class BoundedQueueTest {

	@Test
	void testZeroSizeQueue() {
		assertThrows(ArrayStoreException.class, () -> new BoundedQueue<>(0));
		assertThrows(ArrayStoreException.class, () -> new BoundedQueue<>(-10));
	}
	
	@Test
	void testOneItemQueue() {
		BoundedQueue<Integer> queue = new BoundedQueue<>(1);
		queue.offer(2);
		assertEquals(2, queue.peek());
		assertEquals(2, queue.poll());
		assertTrue(queue.offer(1));
		assertFalse(queue.offer(2));
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.peek());
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.poll());
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testMultipleItemsQueue() {
		BoundedQueue<Integer> queue = new BoundedQueue<>(3);
		assertTrue(queue.isEmpty());
		for (int i = 1; i <= 3; i++) {
			queue.offer(i);
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.peek());
		}
		assertEquals(3, queue.size());		
		assertEquals(1,queue.poll());
		assertEquals(2,queue.poll());
		assertTrue(queue.offer(4));
		assertTrue(queue.offer(5));
		assertEquals(3, queue.size());
		queue.printQueue();
		assertEquals(3,queue.poll());		
		assertEquals(4,queue.poll());		
		assertEquals(5,queue.poll());	
		assertEquals(null, queue.peek());
		assertEquals(null, queue.poll());
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
		
	}
	
	@Test
	void testMultipleItemsQueue2() {
		BoundedQueue<Integer> queue = new BoundedQueue<>(3);
		assertTrue(queue.isEmpty());
		for (int i = 1; i <= 3; i++) {
			queue.offer(i);
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.peek());
		}
		assertEquals(3, queue.size());
		queue.clear(); queue.clear();
		assertEquals(0, queue.size());
		for (int i = 1; i <= 3; i++) {
			queue.offer(i);
			assertFalse(queue.isEmpty());
			assertEquals(1, queue.peek());
		}
		assertEquals(3, queue.size());
	}
	
	@Test
	void testCopyArray() {
		Integer[] array1 = new Integer[3];
		BoundedQueue<Integer> queue = new BoundedQueue<>(3);
		assertTrue(queue.isEmpty());
		for (int i = 0; i <= 2; i++) {
			queue.offer(i);
			assertFalse(queue.isEmpty());
			assertEquals(0, queue.peek());
		}
		
		queue.toArray(array1);
		for (int i = 0; i <= 2; i++) {
			assertEquals(i, array1[i]);
		}
	}
	
	@Test
	void testCopyArray2() {
		Integer[] array1 = new Integer[3];
		BoundedQueue<Integer> queue = new BoundedQueue<>(3);
		assertTrue(queue.isEmpty());
		for (int i = 0; i <= 2; i++) {
			queue.offer(i);
			assertFalse(queue.isEmpty());
			assertEquals(0, queue.peek());
		}
		queue.poll();
		queue.poll();
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		
		queue.toArray(array1);
		for (int i = 0; i <= 2; i++) {
			assertEquals(i+2, array1[i]);
		}
	}
}
