package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
@SuppressWarnings({"unchecked", "rawtypes","unused"})
public class MyArrayListAPlusTest {

	
	@Test
	public void testAdd1() {
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Ralph");
		al.add("Joe");
		assertTrue(al.size() == 3);
		assertEquals(al.get(0),"Sam");
		assertEquals(al.get(1),"Ralph");
		assertEquals(al.get(2),"Joe");
	}
	
	@Test
	public void testSize1(){
		List<String> al = new MyArrayListAPlus<String>();
		assertTrue(al.size() == 0);
		
	}
	
	@Test
	public void testSize2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Joe");
		assertTrue(al.size() == 2);
		al.remove(1);
		assertTrue(al.size() == 1);
		al.remove(0);
		assertTrue(al.size() == 0);
	}
	
	@Test
	public void testInsert1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Joe");
		al.add(0,"Ralph");
		assertTrue(al.size() == 3);
		assertEquals(al.get(0),"Ralph");
	}
	
	@Test
	public void testInsert2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Ralph");
		al.add(2,"Joe");
		assertTrue(al.size() == 3);
		assertEquals(al.get(2),"Joe");
	}

	@Test
	public void testInsert3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Joe");
		al.add(1,"Ralph");
		assertTrue(al.size() == 3);
		assertEquals(al.get(1),"Ralph");
	}
	@Test
	public void testInsert4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Joe");
		al.add(1,"Ralph");
		al.add("Bob");
		assertTrue(al.size() == 4);
		assertEquals(al.get(3),"Bob");
	}
	
	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void testInsert5(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Joe");
		al.add(3,"Ralph");
		al.add("Fred");
		assertTrue(al.size() == 4);
		assertEquals(al.get(3),"Fred");
	}
	
	@Test
	public void testClear1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.clear();
		assertTrue(al.size() == 0);
		
	}
	
	@Test
	public void testClear2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.clear();
		assertTrue(al.size() == 0);
	}	
	
	@Test
	public void testRemove1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Joe");
		al.add("Sam");
		al.add("Bob");
		al.add("Fred");
		Object b = al.remove(2);
		assertEquals("Bob",b);
		assertTrue(al.size() == 3);
		assertEquals(al.get(2),"Fred");
	}
	
	@Test
	public void testRemove2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Ralph");
		al.add("Bob");
		Object b = al.remove(0);
		assertEquals("Sam",b);
		assertTrue(al.size() == 3);
		assertEquals(al.get(2), "Bob");
	}
	
	@Test
	public void testRemove3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Bob");
		al.add("Fred");
		al.add("Ralph");
		Object b = al.remove(3);
		assertEquals("Ralph",b);
		assertTrue(al.size() == 3);
		assertEquals(al.get(2),"Fred");
	}
	
	@Test
	public void testRemove4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Bob");
		al.add("Joe");
		Object b = al.remove(2);
		assertEquals("Bob",b);
		assertTrue(al.size() == 3);
		assertEquals(al.get(2),"Joe");
	}
	
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void testRemove5(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		Object b = al.remove(5);
		assertTrue(al.size() == 4);
	}
	
	@Test
	public void testRemove6() {
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		boolean b = al.remove("Sam");
		assertTrue(b);
		assertTrue(al.size() == 3);
		assertEquals("Fred", al.get(0));
	}
	
	@Test
	public void testRemove7() {
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		boolean b = al.remove("Ralph");
		assertTrue(b);
		assertTrue(al.size() == 3);
		assertEquals("Joe", al.get(2));
	}
	
	@Test
	public void testRemove8() {
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		boolean b = al.remove("Fred");
		assertTrue(b);
		assertTrue(al.size() == 3);
		assertEquals("Ralph", al.get(2));
	}
	
	@Test
	public void testRemove9() {
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		boolean b = al.remove("Bob");
		assertFalse(b);
		assertTrue(al.size() == 4);
	}
	
	@Test
	public void testContains1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Bob");
		al.add("Ralph");
		boolean b = al.contains("Ralph");
		assertTrue(b);
	}
	@Test
	public void testContains2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Bob");
		al.add("Ralph");
		boolean b = al.contains("Sam");
		assertTrue(b);
	}
	@Test
	public void testContains3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Bob");
		al.add("Ralph");
		boolean b = al.contains("Fred");
		assertTrue(b);
	}
	@Test
	public void testContains4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Bob");
		al.add("Ralph");
		boolean b = al.contains("Fritz");
		assertFalse(b);
	}
	
	@Test
	public void testIndexOf1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = al.indexOf("Fred");
		assertEquals(1,i);
	}

	@Test
	public void testIndexOf2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = al.indexOf("Sam");
		assertEquals(i,0);
	}
	@Test
	public void testIndexOf3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = al.indexOf("Ralph");
		assertEquals(i,3);
	}
	@Test
	public void testIndexOf4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = al.indexOf("Fritz");
		assertEquals(i,-1);
	}
	
	@Test
	public void isEmptyTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void isEmptyTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		al.clear();
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void isEmptyTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		assertFalse(al.isEmpty());
		al.remove(0);
		al.remove(0);
		al.remove(0);
		al.remove(0);
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void setTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		al.set(0, "Bob");
		Object b = al.get(0);
		assertEquals("Bob", b);
		assertEquals(al.size(),4);
	}

	@Test
	public void setTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		al.set(4, "Bob");
		Object b = al.get(4);
		assertEquals("Bob",b);
		assertEquals(al.size(),5);
	}
	
	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void setTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		al.set(10, "Fritz");
		Object b = al.get(10);
		assertEquals(b, "Fritz");
		assertEquals(al.size(),4);
	}
	
	@Test
	public void addAllTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Jenny");
		a2.add("Jane");
		al.addAll(a2);
		assertEquals(al.size(),6);
		assertEquals(al.get(4),"Jenny");
		assertEquals(al.get(5),"Jane");
		
	}

	@Test
	public void addAllTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Jenny");
		a2.add("Jane");
		al.addAll(a2);
		assertEquals(al.size(),2);
		assertEquals(al.get(0),"Jenny");
		assertEquals(al.get(1),"Jane");
		
	}
	
	@Test
	public void addAllTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		al.addAll(a2);
		assertEquals(al.size(),4);
		
	}

	@Test
	public void addAllTest4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Jenny");
		a2.add("Jane");
		al.addAll(0, a2);
		assertEquals(al.size(),6);
		assertEquals(al.get(0),"Jenny");
		assertEquals(al.get(1),"Jane");
		
	}
	
	@Test
	public void addAllTest5(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Jenny");
		a2.add("Jane");
		al.addAll(4, a2);
		assertEquals(al.size(),6);
		assertEquals(al.get(4),"Jenny");
		assertEquals(al.get(5),"Jane");
		
	}

	@Test
	public void addAllTest6(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Jenny");
		a2.add("Jane");
		al.addAll(3, a2);
		assertEquals(al.size(),6);
		assertEquals(al.get(3),"Jenny");
		assertEquals(al.get(4),"Jane");
		
	}

	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void addAllTest7(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Jenny");
		a2.add("Jane");
		al.addAll(6, a2);
		assertEquals(al.size(),6);
		assertEquals(al.get(0),"Sam");
		assertEquals(al.get(1),"Fred");
		
	}
	
	@Test
	public void containsAllTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Sam");
		a2.add("Fred");
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Sam");
		a2.add("Ralph");
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Fritz");
		a2.add("Bob");
		boolean b = al.containsAll(a2);
		assertFalse(b);
		
	}
	
	@Test
	public void containsAllTest4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Sam");
		a2.add("Fritz");
		boolean b = al.containsAll(a2);
		assertFalse(b);
		
	}
	
	@Test
	public void containsAllTest5(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Ralph");
		a2.add("Fred");
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest6(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Sam");
		a2.add("Fred");
		a2.add("Joe");
		a2.add("Ralph");
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest7(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Ralph");
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void retainAllTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Ralph");
		boolean b = al.retainAll(a2);
		
		assertTrue(b);
		assertEquals(al.get(0), "Ralph");

	}
	
	@Test
	public void retainAllTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Ralph");
		a2.add("Sam");
		boolean b = al.retainAll(a2);
		
		assertTrue(b);
		assertEquals(al.get(0), "Sam");
		assertEquals(al.get(1),"Ralph");
		assertTrue(al.size() == 2);

	}
	@Test
	public void retainAllTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		a2.add("Joe");
		boolean b = al.retainAll(a2);
		
		assertTrue(b);
		assertTrue(al.size() == 1);

	}
	@Test
	public void retainAllTest4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		List<String> a2 = new MyArrayListAPlus<String>();
		boolean b = al.retainAll(a2);
		assertTrue(b);
		assertTrue(al.size() == 0);

	}
	
	@Test
	public void toArrayTest(){
		List<String> al = new MyArrayListAPlus<String>();
		Object [] objs = al.toArray();
		assertEquals(0, objs.length);
	}
	@Test
	public void toArrayTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		String [] objs = new String[al.size()];
		objs = (String[])al.toArray(objs);
		assertEquals("Sam",objs[0]);
		assertEquals("Fred",objs[1]);
		assertEquals("Joe",objs[2]);
		assertEquals("Ralph",objs[3]);

	}
	@Test
	public void iteratorTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = 0;
		Iterator iter = al.iterator();
		while(iter.hasNext()){
			Object o = iter.next();
			switch(i) {
			case 0:
				assertEquals("Sam",o);
				break;
			case 1:
				assertEquals("Fred",o);
				break;
			case 2:
				assertEquals("Joe",o);
				break;
			case 3:
				assertEquals("Ralph",o);
				break;
			default:
				fail("too many in iterator");
			}
			i++;
		}

	}
	@Test
	public void iteratorTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int size = 3;
		Iterator iter = al.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
			assertEquals(size,al.size());
			size--;
		}
		assertEquals(al.size(),0);
	}
	@Test
	public void iteratorTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = 0;
		Iterator iter = al.iterator();
		while(iter.hasNext()){
			Object o = iter.next();
			if(i == 2) iter.remove();
			i++;
			
		}
		assertEquals(al.size(),3);
		assertEquals(al.get(2),"Ralph");
	}
	@Test
	public void iteratorTest4(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		int i = 0;
		for(Object o: al){
			switch(i) {
			case 0:
				assertEquals("Sam",o);
				break;
			case 1:
				assertEquals("Fred",o);
				break;
			case 2:
				assertEquals("Joe",o);
				break;
			case 3:
				assertEquals("Ralph",o);
				break;
			default:
				fail("too many in iterator");
			}
			i++;
		}
	}
	
	@Test
	public void listIteratorTest1(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		ListIterator li = al.listIterator();
		int i = 0;
		while(li.hasNext()){
			Object o = li.next();
			switch(i) {
			case 0:
				assertEquals("Sam",o);
				break;
			case 1:
				assertEquals("Fred",o);
				break;
			case 2:
				assertEquals("Joe",o);
				break;
			case 3:
				assertEquals("Ralph",o);
				break;
			default:
				fail("too many in iterator");
			}
			i++;
		}

	}
	
	@Test
	public void listIteratorTest2(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		ListIterator li = al.listIterator(2);
		int i = 0;
		while(li.hasNext()){
			Object o = li.next();
			switch(i) {
			case 0:
				assertEquals("Joe",o);
				break;
			case 1:
				assertEquals("Ralph",o);
				break;
			default:
				fail("too many in iterator");
			}
			i++;
		}

	}
	
	@Test
	public void listIteratorTest3(){
		List<String> al = new MyArrayListAPlus<String>();
		al.add("Sam");
		al.add("Fred");
		al.add("Joe");
		al.add("Ralph");
		ListIterator li = al.listIterator();
		int i = 0;
		while(li.hasNext()){
			li.next();
			if(i == 2){
				li.add("Bob");
			}
			
			i+= 1;
		}
		assertEquals(al.size(), 5);
		assertEquals(al.get(2), "Bob");

	}
	


}
