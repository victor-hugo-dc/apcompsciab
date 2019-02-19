package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WelcomeReview2Test {

	private WelcomeReview2 wr2;
	
	@Before
	public void onLoad(){
		wr2 = new WelcomeReview2();
	}
	@Test
	public void testRemoveElementAt1() {
		int [] list = {1,2,3,4,5};
		wr2.removeElementAt(list, 2);
		int [] result = {1,2,4,5,0};
		assertTrue(Arrays.equals(list, result));
	}
	@Test
	public void testRemoveElementAt2() {
		int [] list = {1,2,3,4,5};
		wr2.removeElementAt(list, 0);
		int [] result = {2,3,4,5,0};
		assertTrue(Arrays.equals(list, result));
	}
	@Test
	public void testRemoveElementAt3() {
		int [] list = {1,2,3,4,5};
		wr2.removeElementAt(list, 4);
		int [] result = {1,2,3,4,0};
		assertTrue(Arrays.equals(list, result));
	}
	@Test 
	public void testRemoveElementAt4() {
		int [] list = {1,2,3,4,5};
		wr2.removeElementAt(list, 6);
		int [] result = {1,2,3,4,5};
		assertTrue(Arrays.equals(list, result));
	}
	
	@Test
	public void testInsertElement1(){
		int [] list = {1,2,3,4,5,0,0,0};
		wr2.insertElement(list, 2, 16);
		int [] result = {1,2,16,3,4,5,0,0};
		assertTrue(Arrays.equals(list, result));
	}

	@Test
	public void testInsertElement2(){
		int [] list = {1,2,3,4,5,0,0,0};
		wr2.insertElement(list, 0, 16);
		int [] result = {16,1,2,3,4,5,0,0};
		assertTrue(Arrays.equals(list, result));
	}
	@Test
	public void testInsertElement3(){
		int [] list = {1,2,3,4,5,0,0,0};
		wr2.insertElement(list, 5, 16);
		int [] result = {1,2,3,4,5,16,0,0};
		assertTrue(Arrays.equals(list, result));
	}
	@Test
	public void testInsertElement4(){
		int [] list = {1,2,3,4,5,0,0,0};
		wr2.insertElement(list, -1, 16);
		int [] result = {1,2,3,4,5,0,0,0};
		assertTrue(Arrays.equals(list, result));
	}
	
	@Test
	public void expandArrayTest1(){
		int [] list = {1,2,3,4,5};
		int [] result = {1,2,3,4,5,0,0,0,0,0};
		int [] answer = wr2.expandArray(list); 
		assertTrue(Arrays.equals(answer, result));
	}
	
	@Test
	public void expandArrayTest2(){
		int [] list = {};
		int [] result = {};
		int [] answer = wr2.expandArray(list); 
		assertTrue(Arrays.equals(answer, result));
	}

	@Test
	public void removeAllElementsTest1(){
		int [] list = {1,2,3,4,5};
		int [] toBe = {1};
		int [] answer = {2,3,4,5,0};
		wr2.removeAllElements(list, toBe); 
		assertTrue(Arrays.equals(answer, list));

	}

	@Test
	public void removeAllElementsTest2(){
		int [] list = {1,2,3,4,5};
		int [] toBe = {};
		int [] answer = {1,2,3,4,5};
		wr2.removeAllElements(list, toBe);
		assertTrue(Arrays.equals(answer, list));

	}
	
	@Test
	public void removeAllElementsTest3(){
		int [] list = {1,2,3,4,5};
		int [] toBe = {2,3,4};
		int [] answer = {1,5,0,0,0};
		wr2.removeAllElements(list, toBe);
		assertTrue(Arrays.equals(answer, list));

	}
	
	@Test
	public void removeAllElementsTest4(){
		int [] list = {1,2,3,4,5};
		int [] toBe = {6};
		int [] answer = {1,2,3,4,5};
		wr2.removeAllElements(list, toBe);
		assertTrue(Arrays.equals(answer, list));
	}
	
	@Test
	public void removeAllElementsTest5(){
		int [] list = {1,2,3,4,5};
		int [] toBe = {1,5,6,7};
		int [] answer = {2,3,4,0,0};
		wr2.removeAllElements(list, toBe);
		assertTrue(Arrays.equals(answer, list));
	}
	
	@Test
	public void removeAllOfElementTest1(){
		int [] list = {1,2,3,4,5};
		wr2.removeAllOfElement(list, 4);
		int [] answer = {1,2,3,5,0};
		assertTrue(Arrays.equals(answer, list));

	}

	@Test
	public void removeAllOfElementTest2(){
		int [] list = {1,2,3,4,5};
		wr2.removeAllOfElement(list, 1);
		int [] answer = {2,3,4,5,0};
		assertTrue(Arrays.equals(answer, list));

	}
	
	@Test
	public void removeAllOfElementTest3(){
		int [] list = {1,2,3,4,5};
		wr2.removeAllOfElement(list, 5);
		int [] answer = {1,2,3,4,0};
		assertTrue(Arrays.equals(answer, list));

	}
	
	@Test
	public void removeAllOfElementTest4(){
		int [] list = {1,2,3,4,5};
		wr2.removeAllOfElement(list, 0);
		int [] answer = {1,2,3,4,5};
		assertTrue(Arrays.equals(answer, list));
	}

	@Test
	public void addAllElements1(){
		int [] list = {1,2,3,4,5};
		int [] toAdd = {7,8,9};
		int [] result = wr2.addAllElements(list, toAdd, 2);
		int [] answer = {1,2,7,8,9,3,4,5};
		assertTrue(Arrays.equals(answer, result));

	}
	
	@Test
	public void addAllElements2(){
		int [] list = {1,2,3,4,5};
		int [] toAdd = {7,8,9};
		int [] result = wr2.addAllElements(list, toAdd, 0);
		int [] answer = {7,8,9,1,2,3,4,5};
		assertTrue(Arrays.equals(answer, result));

	}
	
	@Test
	public void addAllElements3(){
		int [] list = {1,2,3,4,5};
		int [] toAdd = {7,8,9};
		int [] result = wr2.addAllElements(list, toAdd, 5);
		int [] answer = {1,2,3,4,5,7,8,9};
		assertTrue(Arrays.equals(answer, result));

	}
	
	@Test
	public void addAllElements4(){
		int [] list = {1,2,3,4,5};
		int [] toAdd = {};
		int [] result = wr2.addAllElements(list, toAdd, 2);
		int [] answer = {1,2,3,4,5};
		assertTrue(Arrays.equals(answer, result));

	}
	
	@Test (expected=java.lang.IndexOutOfBoundsException.class)
	public void addAllElements5(){
		int [] list = {1,2,3,4,5};
		int [] toAdd = {7,8,9};
		int [] result = wr2.addAllElements(list, toAdd, 7);
		int [] answer = {1,2,7,8,9,3,4,5};
		assertTrue(Arrays.equals(answer, result));

	}



	

}
