package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void priorityTest1() {
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("Test",1);
		q.add("Stuff",1);
		q.add("Adam", 1);
		assertEquals(3, q.size());
		assertEquals("Test", q.element());
		assertEquals("Stuff", q.element());
		assertEquals("Adam", q.element());
	}
	
	@Test
	public void priorityTest2() {
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("Test",3);
		q.add("Stuff",2);
		q.add("Adam", 1);
		assertEquals(3, q.size());
		assertEquals("Adam", q.element());
		assertEquals("Stuff", q.element());
		assertEquals("Test", q.element());
		assertEquals(0, q.size());
	}
	
	@Test
	public void priorityTest3() {
		PriorityQueue<String> q = new PriorityQueue<String>();

		q.add("Test", 3);
		q.add("Stuff",2);
		q.add("Adam",2);
		q.add("Nick", 3);
		q.add("Roman",1);
		assertEquals(5, q.size());
		assertEquals("Roman", q.element());
		assertEquals("Stuff", q.element());
		assertEquals("Adam", q.element());
		assertEquals("Test", q.element());
		assertEquals("Nick", q.element());
		assertEquals(0, q.size());
		
	}
	
	@Test
	public void priorityTest4() {
		PriorityQueue<String> q = new PriorityQueue<String>();
		assertEquals(0,q.size());
		assertNull(q.element());
	}
	
	@Test
	public void priorityTest5() {
		PriorityQueue<String> q = new PriorityQueue<String>();

		q.add("Test", 3);
		q.add("Stuff",2);
		q.add("Adam",2);
		q.add("Nick", 3);
		q.add("Roman",1);
		assertTrue(q.contains("Adam"));
		assertTrue(q.contains("Stuff"));
		assertFalse(q.contains("nothing"));
		List<String> l = new ArrayList<String>();
		l.add("Adam");
		l.add("Roman");
		l.add("Test");
		assertTrue(q.containsAll(l));
		l.add("nothing");
		assertFalse(q.containsAll(l));
	}
	
	@Test
	public void priorityTest6() {
		PriorityQueue<String> q = new PriorityQueue<String>();

		q.add("Test", 3);
		q.add("Stuff",2);
		q.add("Adam",2);
		q.add("Nick", 3);
		q.add("Roman",1);
		assertEquals("Roman",q.remove());
		q.remove("Nick");
		assertFalse(q.contains("Nick"));
		assertEquals(3, q.size());
	}
	@Test
	public void priorityTest7() {
		PriorityQueue<String> q = new PriorityQueue<String>();

		q.add("Test", 3);
		q.add("Stuff",2);
		q.add("Adam",2);
		q.add("Nick", 3);
		q.add("Roman",1);
		List<String> l = new ArrayList<String>();
		l.add("Adam");
		l.add("Roman");
		l.add("Test");
		q.removeAll(l);
		System.out.println(q.size());
		assertFalse(q.contains("Stuff"));
		assertEquals("Stuff",q.remove());
		assertEquals("Nick",q.remove());
		assertTrue(q.isEmpty());

	}

}
