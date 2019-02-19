package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class HeapTest {

	@Test
	public void testAddGetMin1() {
		Heap<String> heap = new Heap<String>();
		heap.add("Bob");
		assertEquals(1,  heap.size());
		assertEquals("Bob", heap.get());
		assertEquals(0,heap.size());
	}
	
	@Test
	public void testAddGetMin2() {
		Heap<String> heap = new Heap<String>();
		heap.add("Bob");
		heap.add("Ralph");
		assertEquals(2,  heap.size());
		assertEquals("Bob", heap.get());
		assertEquals(1,heap.size());
		assertEquals("Ralph",heap.get());
		assertEquals(0, heap.size());
	}
	
	@Test
	public void testAddGetMin3() {
		Heap<String> heap = new Heap<String>();
		heap.add("Bob");
		heap.add("Adam");
		assertEquals(2,  heap.size());
		assertEquals("Adam", heap.get());
		assertEquals(1,heap.size());
		assertEquals("Bob",heap.get());
		assertEquals(0, heap.size());	
	}

	@Test
	public void testAddGetMin4() {
		Heap<String> heap = new Heap<String>();
		heap.add("Bob");
		heap.add("Adam");
		heap.add("Ralph");
		heap.add("Tracey");
		heap.add("Frank");
		heap.add("Aaron");
		heap.add("Victor");
		assertEquals(7, heap.size());
		List<String> list = heap.getStructure();
		assertEquals("Aaron", list.get(0));
		assertTrue(list.get(2).compareTo(list.get(5))<0);
		assertTrue(list.get(2).compareTo(list.get(6))<0);
	}
	
	@Test
	public void testAddGetMin5() {
		Heap<String> heap = new Heap<String>();
		heap.add("Bob");
		heap.add("Adam");
		heap.add("Ralph");
		heap.add("Tracey");
		heap.add("Frank");
		heap.add("Aaron");
		heap.add("Victor");
		String[] ret = (String[])heap.heapSort();
		String[] result = {"Victor","Tracey","Ralph","Frank","Bob","Adam", "Aaron"};
		
		for(int i = 0;i<ret.length;i++) {
			assertEquals(result[i], ret[i]);
		}
		
	}
	
	@Test
	public void testAddGetMax1() {
		Heap<String> heap = new Heap<String>(false);
		heap.add("Bob");
		assertEquals(1,  heap.size());
		assertEquals("Bob", heap.get());
		assertEquals(0,heap.size());
	}
	
	@Test
	public void testAddGetMax2() {
		Heap<String> heap = new Heap<String>(false);
		heap.add("Bob");
		heap.add("Ralph");
		assertEquals(2,  heap.size());
		assertEquals("Ralph", heap.get());
		assertEquals(1,heap.size());
		assertEquals("Bob",heap.get());
		assertEquals(0, heap.size());
	}
	
	@Test
	public void testAddGetMax3() {
		Heap<String> heap = new Heap<String>(false);
		heap.add("Bob");
		heap.add("Adam");
		assertEquals(2,  heap.size());
		assertEquals("Bob", heap.get());
		assertEquals(1,heap.size());
		assertEquals("Adam",heap.get());
		assertEquals(0, heap.size());	
	}

	@Test
	public void testAddGetMax4() {
		Heap<String> heap = new Heap<String>(false);
		heap.add("Bob");
		heap.add("Adam");
		heap.add("Ralph");
		heap.add("Tracey");
		heap.add("Frank");
		heap.add("Aaron");
		heap.add("Victor");
		assertEquals(7, heap.size());
		List<String> list = heap.getStructure();
		assertEquals("Victor", list.get(0));
		assertTrue(list.get(2).compareTo(list.get(5))>0);
		assertTrue(list.get(2).compareTo(list.get(6))>0);
	}
	
	@Test
	public void testAddGetMax5() {
		Heap<String> heap = new Heap<String>(false);
		heap.add("Bob");
		heap.add("Adam");
		heap.add("Ralph");
		heap.add("Tracey");
		heap.add("Frank");
		heap.add("Aaron");
		heap.add("Victor");
		String[] result = {"Aaron","Adam","Bob","Frank","Ralph","Tracey","Victor"};

		String[] ret = (String[])heap.heapSort();
		for(int i = 0;i<ret.length;i++) {
			assertEquals(result[i], ret[i]);
		}
		
	}
	
	@Test
	public void testAddAll1() {
		Heap<String> heap = new Heap<String>();
		List<String> list = new ArrayList<String>();
		list.add("Bob");
		list.add("Adam");
		list.add("Frank");
		list.add("Sally");
		list.add("Nick");
		list.add("Roman");
		heap.addAll(list);
		assertEquals(6, heap.size());
		assertEquals("Adam",heap.get());
		Collections.sort(list);
		list.remove("Adam");
		String[] ret = (String[])heap.heapSort();
		Collections.reverse(list);
		String[] result = (String [])list.toArray(new String[list.size()]);
		for(int i = 0;i<ret.length;i++) {
			assertEquals(result[i], ret[i]);
		}

	}
	@Test
	public void testAddAllMax1() {
		Heap<String> heap = new Heap<String>(false);
		List<String> list = new ArrayList<String>();
		list.add("Bob");
		list.add("Adam");
		list.add("Frank");
		list.add("Sally");
		list.add("Nick");
		list.add("Roman");
		heap.addAll(list);
		assertEquals(6, heap.size());
		assertEquals("Sally",heap.get());
		Collections.sort(list);
		list.remove("Sally");
		//Collections.reverse(list);
		String[] ret = (String[])heap.heapSort();
		String[] result = (String [])list.toArray(new String[list.size()]);
		for(int i = 0;i<ret.length;i++) {
			assertEquals(result[i], ret[i]);
		}

	}
		
	
}