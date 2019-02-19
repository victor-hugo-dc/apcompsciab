package edu.fcps.ab;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
@SuppressWarnings("unused")

public class MyLinkedListAPlusTest {

	private List<BigInteger> list = new MyLinkedListAPlus<BigInteger>();
	
	@Test
	public void testAdd1() {
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("11"));
		al.add(new BigInteger("13"));
		assertTrue(al.size() == 3);
		assertEquals(al.get(0),new BigInteger("10"));
		assertEquals(al.get(1), new BigInteger("11"));
		assertEquals(al.get(2), new BigInteger("13"));
	}
	
	@Test
	public void testSize1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		assertTrue(al.size() == 0);
		
	}
	
	@Test
	public void testSize2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("12"));
		assertEquals(al.size(), 2);
		al.remove(1);
		assertEquals(al.size(), 1);
		al.remove(0);
		assertEquals(al.size(), 0);
	}
	
	@Test
	public void testInsert1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("12"));
		al.add(0,new BigInteger("20"));
		assertEquals(al.size(), 3);
		assertEquals(al.get(0), new BigInteger("20"));
	}
	
	@Test
	public void testInsert2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("12"));
		al.add(2,new BigInteger("20"));
		assertEquals(al.size(), 3);
		assertEquals(al.get(2), new BigInteger("20"));
	}

	@Test
	public void testInsert3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("12"));
		al.add(1,new BigInteger("20"));
		assertEquals(al.size(), 3);
		assertEquals( al.get(1), new BigInteger("20"));
	}
	@Test
	public void testInsert4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("12"));
		al.add(1,new BigInteger("20"));
		al.add(new BigInteger("45"));
		assertEquals(al.size(), 4);
		assertEquals( al.get(3), new BigInteger("45"));
	}
	
	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void testInsert5(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("12"));
		al.add(3,new BigInteger("20"));
		al.add(new BigInteger("45"));
		assertTrue(al.size() == 4);
		assertEquals( al.get(3), new BigInteger("45"));
	}
	
	@Test
	public void testClear1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("1"));
		al.add(new BigInteger("3"));
		al.add(new BigInteger("0"));
		al.clear();
		assertEquals(al.size(), 0);
		
	}
	
	@Test
	public void testClear2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.clear();
		assertEquals(al.size(), 0);
	}	
	
	@Test
	public void testRemove1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		BigInteger b =  al.remove(2);
		assertEquals(b, new BigInteger("30"));
		assertEquals(al.size(), 3);
		assertEquals( al.get(2), new BigInteger("40"));
	}
	
	@Test
	public void testRemove2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		BigInteger b =  al.remove(0);
		assertEquals(b, new BigInteger("10"));
		assertEquals(al.size(), 3);
		assertEquals( al.get(2), new BigInteger("40"));
	}
	
	@Test
	public void testRemove3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		BigInteger b =  al.remove(3);
		assertEquals(b, new BigInteger("40"));
		assertEquals(al.size(), 3);
		assertEquals( al.get(2), new BigInteger("30"));
	}
	
	@Test
	public void testRemove4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		BigInteger b =  al.remove(2);
		assertEquals(b, new BigInteger("30"));
		assertEquals(al.size(), 3);
		assertEquals( al.get(2), new BigInteger("40"));
	}
	
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void testRemove5(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		BigInteger b =  al.remove(5);
		assertTrue(al.size() == 4);
	}
	
	@Test
	public void testRemove6(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b =  al.remove(new BigInteger("10"));
		assertTrue(b);
		assertTrue(al.size() == 3);
	}

	@Test
	public void testRemove7(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b =  al.remove(new BigInteger("40"));
		assertTrue(b);
		assertTrue(al.size() == 3);
	}
	
	@Test
	public void testRemove8(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b =  al.remove(new BigInteger("50"));
		assertFalse(b);
		assertTrue(al.size() == 4);
	}


	@Test
	public void testContains1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b = al.contains(new BigInteger("30"));
		assertTrue(b);
	}
	@Test
	public void testContains2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b = al.contains(new BigInteger("10"));
		assertTrue(b);
	}
	@Test
	public void testContains3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b = al.contains(new BigInteger("40"));
		assertTrue(b);
	}
	@Test
	public void testContains4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		boolean b = al.contains(new BigInteger("50"));
		assertFalse(b);
	}
	@Test
	public void testContains5(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		al.remove(2);
		boolean b = al.contains(new BigInteger("30"));
		assertFalse(b);
	}
	
	@Test
	public void testIndexOf1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		int i = al.indexOf(new BigInteger("20"));
		assertEquals(i,1);
	}

	@Test
	public void testIndexOf2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		int i = al.indexOf(new BigInteger("10"));
		assertEquals(i,0);
	}
	@Test
	public void testIndexOf3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		int i = al.indexOf(new BigInteger("40"));
		assertEquals(i,3);
	}
	@Test
	public void testIndexOf4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		int i = al.indexOf(new BigInteger("50"));
		assertEquals(i,-1);
	}
	
	@Test
	public void testIndexOf5(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		al.remove(0);
		int i = al.indexOf(new BigInteger("10"));
		assertEquals(i,-1);
	}
	
	@Test
	public void isEmptyTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void isEmptyTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		al.clear();
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void isEmptyTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		assertFalse(al.isEmpty());
		al.remove(0);
		al.remove(0);
		al.remove(0);
		al.remove(0);
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void setTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		al.set(0, new BigInteger("50"));
		BigInteger i =  al.get(0);
		assertEquals(i, new BigInteger("50"));
		assertEquals(al.size(),4);
	}

	@Test
	public void setTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		al.set(4, new BigInteger("50"));
		BigInteger i =  al.get(4);
		assertEquals(i, new BigInteger("50"));
		assertEquals(al.size(),5);
	}
	
	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void setTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		al.set(5, new BigInteger("100"));
		BigInteger i =  al.get(5);
		assertEquals(i, new BigInteger("100"));
		assertEquals(al.size(),5);
	}
	
	@Test
	public void addAllTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		al.addAll(a2);
		assertEquals(al.size(),6);
		assertEquals( al.get(4), new BigInteger("10"));
		assertEquals( al.get(5), new BigInteger("20"));
		
	}

	@Test
	public void addAllTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		al.addAll(a2);
		assertEquals(al.size(),2);
		assertEquals( al.get(0), new BigInteger("10"));
		assertEquals( al.get(1), new BigInteger("20"));
		
	}
	
	@Test
	public void addAllTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		al.addAll(a2);
		assertEquals(al.size(),4);
		
	}

	@Test
	public void addAllTest4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		al.addAll(0, a2);
		assertEquals(al.size(),6);
		assertEquals( al.get(0), new BigInteger("10"));
		assertEquals( al.get(1), new BigInteger("20"));
		
	}
	
	@Test
	public void addAllTest5(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		al.addAll(4, a2);
		assertEquals(al.size(),6);
		assertEquals( al.get(4), new BigInteger("10"));
		assertEquals( al.get(5), new BigInteger("20"));
		
	}

	@Test
	public void addAllTest6(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		al.addAll(3, a2);
		assertEquals(al.size(),6);
		assertEquals( al.get(3), new BigInteger("10"));
		assertEquals( al.get(4), new BigInteger("20"));
		assertEquals(al.get(5), new BigInteger("40"));
		
	}

	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void addAllTest7(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		al.addAll(6, a2);
		assertEquals(al.size(),6);
		assertEquals( al.get(0), new BigInteger("10"));
		assertEquals( al.get(1), new BigInteger("20"));
		
	}
	
	@Test
	public void containsAllTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("40"));
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("50"));
		a2.add(new BigInteger("60"));
		boolean b = al.containsAll(a2);
		assertFalse(b);
		
	}
	
	@Test
	public void containsAllTest4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("50"));
		boolean b = al.containsAll(a2);
		assertFalse(b);
		
	}
	
	@Test
	public void containsAllTest5(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("40"));
		a2.add(new BigInteger("20"));
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest6(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("10"));
		a2.add(new BigInteger("20"));
		a2.add(new BigInteger("30"));
		a2.add(new BigInteger("40"));
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void containsAllTest7(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("40"));
		boolean b = al.containsAll(a2);
		assertTrue(b);
		
	}
	
	@Test
	public void retainAllTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("40"));
		boolean b = al.retainAll(a2);
		
		assertTrue(b);
		assertEquals( (al.get(0)),  new BigInteger("40"));

	}
	
	@Test
	public void retainAllTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("40"));
		a2.add(new BigInteger("20"));
		boolean b = al.retainAll(a2);
		
		assertTrue(b);
		assertEquals( (al.get(0)),  new BigInteger("20"));
		assertEquals( (al.get(1)),  new BigInteger("40"));
		assertTrue(al.size() == 2);

	}
	@Test
	public void retainAllTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		a2.add(new BigInteger("50"));
		boolean b = al.retainAll(a2);
		
		assertFalse(b);
		assertTrue(al.size() == 0);

	}
	@Test
	public void retainAllTest4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> a2 = new MyLinkedListAPlus<BigInteger>();
		boolean b = al.retainAll(a2);
		assertFalse(b);
		assertTrue(al.size() == 0);

	}
	
	@Test
	public void toArrayTest(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		Object [] objs = al.toArray();
		for(int i = 0;i< 40;i+=10){
			assertEquals( objs[i/10], new BigInteger(""+(i+10)));
		}
	}

	@Test
	public void iteratorTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		int i = 10;
		Iterator<BigInteger> iter = al.iterator();
		while(iter.hasNext()){
			assertEquals( iter.next(), new BigInteger(""+i));
			i+=10;
		}

	}
	@Test
	public void iteratorTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));

		Iterator<BigInteger> iter = al.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
		assertEquals(al.size(),0);
	}
	@Test
	public void iteratorTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20") );
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		Iterator<BigInteger> iter = al.iterator();
		while(iter.hasNext()){
			if(iter.next().equals(new BigInteger("20"))){
				iter.remove();
			}
			
		}
		assertEquals(al.size(),3);
		assertEquals( al.get(1), new BigInteger("30"));
	}
	@Test
	public void iteratorTest4(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		int i = 10;
		for(BigInteger o: al){
			assertEquals( o, new BigInteger(""+i));
			i += 10;
		}
	}
	
	@Test
	public void listIteratorTest1(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		ListIterator<BigInteger> li = al.listIterator();
		int i = 10;
		while(li.hasNext()){
			assertEquals( li.next(),new BigInteger(""+ i));
			assertEquals( li.previous(),new BigInteger(""+ i));
			li.next();
			i+= 10;
		}

	}
	
	@Test
	public void listIteratorTest2(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		ListIterator<BigInteger> li = al.listIterator(2);
		int i = 30;
		while(li.hasNext()){
			assertEquals( li.next(), new BigInteger(""+i));
			i+= 10;
		}

	}
	
	@Test
	public void listIteratorTest3(){
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		ListIterator<BigInteger> li = al.listIterator();
		
		while(li.hasNext()){
			BigInteger b = li.next();
			if(b.equals(new BigInteger("20"))){
				li.add(new BigInteger("100"));
			}
			if(b.equals(new BigInteger("30"))) {
				li.set(new BigInteger("200"));
			}
		}
		assertEquals(al.size(), 5);
		assertEquals(al.get(1), new BigInteger("100"));
		assertEquals(al.get(3), new BigInteger("200")); 
	}
	
	@Test
	public void subListTest1() {
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> sub = al.subList(1, 3);
		assertEquals(2,  sub.size());
		assertEquals(new BigInteger("20"), sub.get(0));
		assertEquals(new BigInteger("30"), sub.get(1));
	}
	
	@Test
	public void subListTest2() {
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> sub = al.subList(0, 2);
		assertEquals(2,  sub.size());
		assertEquals(new BigInteger("10"), sub.get(0));
		assertEquals(new BigInteger("20"), sub.get(1));
		
	}
	@Test
	public void subListTest3() {
		List<BigInteger> al = new MyLinkedListAPlus<BigInteger>();
		al.add(new BigInteger("10"));
		al.add(new BigInteger("20"));
		al.add(new BigInteger("30"));
		al.add(new BigInteger("40"));
		List<BigInteger> sub = al.subList(0, 4);
		assertEquals(4,  sub.size());
		for(int i = 0; i < sub.size(); i++) {
			assertEquals(sub.get(i), al.get(i));
		}
		
	}
}