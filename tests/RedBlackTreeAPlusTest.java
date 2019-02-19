package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
@SuppressWarnings({"unchecked", "rawtypes","unused"})
public class RedBlackTreeAPlusTest {

	private ArrayList<String> buildBST(RedBlackTreeAPlus<String> bst){
		bst.add("Jamie");
		bst.add("Suzie");
		bst.add("Adam");
		bst.add("Frank");
		bst.add("Julio");
		bst.add("Theo");
		bst.add("Michelle");
		bst.add("Mark");
		bst.add("Aaron");
		bst.add("Eli");

		ArrayList<String> al = new ArrayList<String>();
		al.add("Aaron");
		al.add("Adam");
		al.add("Eli");
		al.add("Frank");
		al.add("Jamie");
		al.add("Julio");
		al.add("Mark");
		al.add("Michelle");
		al.add("Suzie");
		al.add("Theo");
		return al;
	}
	
	
	@Test
	public void testAdd() {
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		
		ArrayList<String> result = buildBST(bst);
		assertEquals(10, bst.size());
		assertEquals(result, bst.inOrder());
	}
	
	@Test 
	public void testAdd2(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		ArrayList<String> result = buildBST(bst);
		bst.add("Michael");
		result.add(7, "Michael");
		assertEquals(11, bst.size());
		assertEquals(result,bst.inOrder());
	}
	
	@Test
	public void testContains(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		ArrayList<String> result = buildBST(bst);
		assertTrue(bst.contains("Mark"));
		assertFalse(bst.contains("Ralph"));
	}
	
	@Test
	public void testContains2(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		assertFalse(bst.contains("Mark"));
	}
	
	@Test
	public void testAddAll(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		ArrayList<String> result = buildBST(bst);
		ArrayList<String> toBe = new ArrayList<String>();
		toBe.add("Sid");
		toBe.add("Caton");
		toBe.add("Nikki");
		bst.addAll(toBe);
		result.add(8, "Sid");
		result.add(2,"Caton");
		result.add(9,"Nikki");
		assertEquals(13,bst.size());
		assertEquals(result,bst.inOrder());
	}
	
	@Test
	public void testAddAll2(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		ArrayList<String> result = buildBST(bst);
		ArrayList<String> toBe = new ArrayList<String>();
		bst.addAll(toBe);
		assertEquals(10,bst.size());
		assertEquals(result,bst.inOrder());
	}

	@Test
	public void testAddAll3(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		ArrayList<String> result = buildBST(bst);
		RedBlackTreeAPlus<String> toBe = new RedBlackTreeAPlus<String>();
		toBe.add("Sid");
		toBe.add("Caton");
		toBe.add("Nikki");
		bst.addAll(toBe);
		result.add(8, "Sid");
		result.add(2,"Caton");
		result.add(9,"Nikki");
		assertEquals(13,bst.size());
		assertEquals(result,bst.inOrder());
	}

	@Test
	public void testIsEmpty(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		assertTrue(bst.isEmpty());
		ArrayList<String> result = buildBST(bst);
		assertFalse(bst.isEmpty());
	}
	
	@Test
	public void testGet(){
		RedBlackTreeAPlus<String> bst = new RedBlackTreeAPlus<String>();
		assertNull(bst.get("Ralph"));
		ArrayList<String> result = buildBST(bst);
		assertNull(bst.get("Ralph"));
		assertEquals("Mark", bst.get("Mark"));
	}
	@Test
	public void testSuccessor1(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		buildBST(bst);
		String successor = (String)bst.successor("Julio");
		assertEquals("Mark", successor);
		successor = (String)bst.successor("Adam");
		assertEquals("Eli", successor);
		successor = (String)bst.successor("Theo");
		assertNull( successor);
		
	}
	
	@Test
	public void testPredessor1(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		buildBST(bst);
		String predessor = (String)bst.predessor("Julio");
		assertNull(predessor);
		predessor = (String)bst.predessor("Theo");
		assertNull(predessor);
		predessor = (String)bst.predessor("Adam");
		assertEquals("Aaron",predessor);
		predessor = (String)bst.predessor("Suzie");
		assertEquals("Michelle",predessor);
		
	}
	
	@Test
	public void minTest(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		buildBST(bst);
		String min = (String)bst.min("Jamie");
		assertEquals("Aaron", min);
	}
	
	@Test 
	public void maxTest(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		buildBST(bst);
		String max = (String)bst.max("Jamie");
		assertEquals("Theo", max);
	}
	
	@Test
	public void removeTest1(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		ArrayList<String> al = buildBST(bst);
		al.remove("Eli");
		bst.remove("Eli");
		ArrayList<Comparable> result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Frank");
		bst.remove("Frank");
		result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Adam");
		bst.remove("Adam");
		result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Aaron");
		bst.remove("Aaron");
		result = bst.inOrder();
		assertEquals(al,result);
	}
	
	@Test
	public void removeTest2(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		ArrayList<String> al = buildBST(bst);
		al.remove("Suzie");
		bst.remove("Suzie");
		ArrayList<Comparable> result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Michelle");
		bst.remove("Michelle");
		result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Mark");
		bst.remove("Mark");
		result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Julio");
		bst.remove("Julio");
		result = bst.inOrder();
		assertEquals(al,result);
		al.remove("Theo");
		bst.remove("Theo");
		result = bst.inOrder();
		assertEquals(al,result);
		
	}
	
	@Test
	public void removeTest3(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		ArrayList<String> al = buildBST(bst);
		al.remove("Jamie");
		bst.remove("Jamie");
		ArrayList<Comparable> result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Frank",bst.getRoot().getData());
		al.remove("Frank");
		bst.remove("Frank");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Eli",bst.getRoot().getData());
		al.remove("Eli");
		bst.remove("Eli");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Adam",bst.getRoot().getData());
		al.remove("Adam");
		bst.remove("Adam");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Aaron",bst.getRoot().getData());
		al.remove("Aaron");
		bst.remove("Aaron");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Julio",bst.getRoot().getData());
		al.remove("Julio");
		bst.remove("Julio");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Mark",bst.getRoot().getData());
		al.remove("Mark");
		bst.remove("Mark");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Michelle",bst.getRoot().getData());
		al.remove("Michelle");
		bst.remove("Michelle");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Suzie",bst.getRoot().getData());
		al.remove("Suzie");
		bst.remove("Suzie");
		result = bst.inOrder();
		assertEquals(al,result);
		assertEquals("Theo",bst.getRoot().getData());
		al.remove("Theo");
		bst.remove("Theo");
		result = bst.inOrder();
		assertEquals(al,result);
		assertNull(bst.getRoot());
	}
	
	@Test
	public void testRemove3(){
		RedBlackTreeAPlus bst = new RedBlackTreeAPlus();
		ArrayList<Comparable> result = bst.inOrder();
		assertTrue(result.isEmpty());
		bst.add("Ralph");
		assertEquals("Ralph", bst.getRoot().getData());
		bst.remove("Unknown");
		assertEquals("Ralph",bst.getRoot().getData());
		
	}
}
