package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class MyStackTest {

	@Test
	public void testPushPop1() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals(5, stack.size());
		assertEquals(new Integer(5), stack.pop());
		assertEquals(new Integer(4), stack.pop());
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(2), stack.pop());
		assertEquals(new Integer(1), stack.pop());
		assertEquals(0,stack.size());
	}
	
	@Test
	public void testPushPop2() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals(5, stack.size());
		assertEquals(new Integer(5), stack.peek());
		assertEquals(new Integer(5), stack.peek());
		assertEquals(5,stack.size());
	}
	
	@Test
	public void testPushPop3() {
		MyStack<Integer> stack = new MyStack<Integer>();
		assertEquals(0,stack.size());
	}
	
	@SuppressWarnings("unused")
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void testPushPop4() {
		MyStack<Integer> stack = new MyStack<Integer>();
		Integer i = stack.pop();
	}
	
	@Test
	public void containsTest1() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertTrue(stack.contains(2));
		assertTrue(stack.contains(5));
		assertTrue(stack.contains(1));
	}
	
	@Test
	public void containsAllTest1() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		Collection<Integer> col = new ArrayList<>();
		col.add(1);
		assertTrue(stack.containsAll(col));
		col.add(5);
		assertTrue(stack.containsAll(col));
		col.add(3);
		assertTrue(stack.containsAll(col));
		col.add(10);
		assertFalse(stack.containsAll(col));
	}
	
	@Test
	public void addAllTest1() {
		MyStack<Integer> stack = new MyStack<Integer>();
		Collection<Integer> col = new ArrayList<>();
		col.add(2);
		col.add(3);
		col.add(4);
		stack.addAll(col);
		assertEquals(3,stack.size());
		assertEquals(new Integer(4),stack.pop());
		assertEquals(new Integer(3),stack.pop());
		assertEquals(new Integer(2),stack.pop());
		assertEquals(0,stack.size());
	}
	
	@Test
	public void addAllTest2() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(5);
		Collection<Integer> col = new ArrayList<>();
		col.add(2);
		col.add(3);
		col.add(4);
		stack.addAll(col);
		assertEquals(6,stack.size());
		assertEquals(new Integer(4),stack.pop());
		assertEquals(new Integer(3),stack.pop());
		assertEquals(new Integer(2),stack.pop());
		assertEquals(3,stack.size());
		assertEquals(new Integer(5), stack.pop());
		assertEquals(new Integer(1),stack.pop());
		assertEquals(new Integer(0), stack.pop());
		assertEquals(0,stack.size());
	}
	
	@Test
	public void isEmptyClearTest1() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertFalse(stack.isEmpty());
		stack.clear();
		assertTrue(stack.isEmpty());
		assertEquals(0,stack.size());
	}
	
	@Test
	public void toArrayTest1() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		Object [] ret = (Object[])stack.toArray();
		for(int i = 5;i>=1;i--) {
			assertEquals(new Integer(i),ret[5-i]);
		}		
	}
	
	@Test
	public void toArrayTest2() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		Integer [] ret = new Integer[5];
		ret = stack.toArray(ret);
		for(int i = 5;i>=1;i--) {
			assertEquals(new Integer(i),ret[5-i]);
		}
	}
}
