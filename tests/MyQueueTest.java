package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class MyQueueTest {
	@Test
	public void testEnqueueDequeue1() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(5, queue.size());
		assertEquals(new Integer(1), queue.dequeue());
		assertEquals(new Integer(2), queue.dequeue());
		assertEquals(new Integer(3), queue.dequeue());
		assertEquals(new Integer(4), queue.dequeue());
		assertEquals(new Integer(5), queue.dequeue());
		assertEquals(0,queue.size());
	}
	
	@Test
	public void testEnqueueDequeue2() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(5, queue.size());
		assertEquals(new Integer(1), queue.peek());
		assertEquals(new Integer(1), queue.peek());
		assertEquals(5,queue.size());
	}
	
	@Test
	public void testEnqueueDequeue3() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		assertEquals(0,queue.size());
	}
	
	@SuppressWarnings("unused")
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void testEnqueueDequeue4() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		Integer i = queue.dequeue();
	}
	
	@Test
	public void containsTest1() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertTrue(queue.contains(2));
		assertTrue(queue.contains(5));
		assertTrue(queue.contains(1));
	}
	
	@Test
	public void containsAllTest1() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		Collection<Integer> col = new ArrayList<>();
		col.add(1);
		assertTrue(queue.containsAll(col));
		col.add(5);
		assertTrue(queue.containsAll(col));
		col.add(3);
		assertTrue(queue.containsAll(col));
		col.add(10);
		assertFalse(queue.containsAll(col));
	}
	
	@Test
	public void addAllTest1() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		Collection<Integer> col = new ArrayList<>();
		col.add(2);
		col.add(3);
		col.add(4);
		queue.addAll(col);
		assertEquals(3,queue.size());
		assertEquals(new Integer(2),queue.dequeue());
		assertEquals(new Integer(3),queue.dequeue());
		assertEquals(new Integer(4),queue.dequeue());
		assertEquals(0,queue.size());
	}
	
	@Test
	public void addAllTest2() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(5);
		Collection<Integer> col = new ArrayList<>();
		col.add(2);
		col.add(3);
		col.add(4);
		queue.addAll(col);
		assertEquals(6,queue.size());
		assertEquals(new Integer(0),queue.dequeue());
		assertEquals(new Integer(1),queue.dequeue());
		assertEquals(new Integer(5),queue.dequeue());
		assertEquals(3,queue.size());
		assertEquals(new Integer(2), queue.dequeue());
		assertEquals(new Integer(3),queue.dequeue());
		assertEquals(new Integer(4), queue.dequeue());
		assertEquals(0,queue.size());
	}
	
	@Test
	public void isEmptyClearTest1() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertFalse(queue.isEmpty());
		queue.clear();
		assertTrue(queue.isEmpty());
		assertEquals(0,queue.size());
	}
	
	@Test
	public void toArrayTest1() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		Object [] ret = (Object[])queue.toArray();
		for(int i = 1;i<=5;i++) {
			assertEquals(new Integer(i),ret[i-1]);
		}
		
	}
	
	@Test
	public void toArrayTest2() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		Integer [] ret = new Integer[5];
		ret = queue.toArray(ret);
		for(int i = 1;i<=5;i++) {
			assertEquals(new Integer(i),ret[i-1]);
		}
	}

}
