package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WelcomeReviewTest {

	WelcomeReview wb;
	@Before
	public void init(){
		wb = new WelcomeReview();
	}
	@Test
	public void testOccurrences1() {
		int [] list = {1,2,3,4,5,6};
		int o = wb.occurences(list, 1);
		assertEquals(o,1);
	}
	@Test
	public void testOccurrences2() {
		int [] list = {1,2,3,4,5,6,5,5,4};
		int o = wb.occurences(list, 5);
		assertEquals(o,3);
	}
	
	@Test
	public void testOccurrences3() {
		int [] list = {1,2,3,4,5,6};
		int o = wb.occurences(list, 7);
		assertEquals(o,0);
	}
	
	@Test
	public void testOccurrences4() {
		int [] list = {6,6,6,6,6,6,6};
		int o = wb.occurences(list, 6);
		assertEquals(o,7);
	}
	
	@Test
	public void testOccurences5(){
		int [] list = {};
		int o = wb.occurences(list, 10);
		assertEquals(o,0);
	}
	
	@Test 
	public void testMax1(){
		int [] list = {1,2,3,4,5,6};
		int m = wb.max(list);
		assertEquals(m, 6);
	}
	@Test 
	public void testMax2(){
		int [] list = {6, 5, 4, 3, 2, 1};
		int m = wb.max(list);
		assertEquals(m, 6);
	}
	@Test 
	public void testMax3(){
		int [] list = {1,2,3,4,5,6,5,4,3,2,1};
		int m = wb.max(list);
		assertEquals(m, 6);
	}
	
	@Test 
	public void testMax4(){
		int [] list = {6,6,6};
		int m = wb.max(list);
		assertEquals(m, 6);
	}

	@Test (expected=java.lang.RuntimeException.class)
	public void testMax5(){
		int [] list = {};
		int m = wb.max(list);
		assertEquals(m,0);
	}
	
	@Test
	public void testIsAscending1(){
		int [] list = {1,2,3,4,5,6};
		boolean b = wb.isAscending(list);
		assertTrue(b);

	}
	@Test
	public void testIsAscending2(){
		int [] list = {6,5,4,3,2,1};
		boolean b = wb.isAscending(list);
		assertFalse(b);

	}
	@Test
	public void testIsAscending3(){
		int [] list = {2,4,8,10,14,24};
		boolean b = wb.isAscending(list);
		assertTrue(b);
	}
	
	@Test
	public void testIsAscending4(){
		int [] list = {1,2,3,4,5,6, 5, 4, 3, 2, 1};
		boolean b = wb.isAscending(list);
		assertFalse(b);
	}
	@Test
	public void testIsAscending5(){
		int [] list = {};
		boolean b = wb.isAscending(list);
		assertFalse(b);
	}


	@Test
	public void testCountOdd1(){
		int [] list = {1,2,3,4,5,6, 5, 4, 3, 2, 1};
		int b = wb.countOdd(list);
		assertEquals(b, 6);
	}

	@Test
	public void testCountOdd2(){
		int [] list = {2,4,6,4, 2};
		int b = wb.countOdd(list);
		assertEquals(b, 0);
	}

	@Test
	public void testCountOdd3(){
		int [] list = {};
		int b = wb.countOdd(list);
		assertEquals(b, 0);
	}

	@Test
	public void testCountOdd4(){
		int [] list = {1,3,5,7,9};
		int b = wb.countOdd(list);
		assertEquals(b, 5);
	}
	
	@Test
	public void testSwap1(){
		int [] list = {1,3,5,7,9};
      int [] result = {5,3,1,7,9};
		wb.swap(list, 0,2);
      assertTrue(Arrays.equals(result, list));
		assertEquals(list[0], 5);
		assertEquals(list[2], 1);
	}
	
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void testSwap2(){
		int [] list = {1,3,5,7,9};
		wb.swap(list,  0, 10);
	}
	@Test
	public void testSwap3(){
		int [] list = {1,3,5,7,9};
      int [] result = {9,3,5,7,1};
		wb.swap(list, 0, 4);
      assertTrue(Arrays.equals(result, list));
		assertEquals(list[0], 9);
		assertEquals(list[4], 1);
	}
	
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void testSwap4(){
		int [] list = {};
		wb.swap(list,  0, 1);
	}
	
	@Test
	public void testSwap5(){
		int [] list = {1,2,3,4,5,6,7};
      int [] result = {1,2,6,4,5,3,7};
		wb.swap(list, 5, 2);
      assertTrue(Arrays.equals(result, list));
		assertEquals(list[5],3);
		assertEquals(list[2],6);
	}
	
	@Test
	public void testReverse1(){
		int [] list = {1,2,3,4,5};
		wb.reverse(list);
		int [] list2 = {5,4,3,2,1};
		assertTrue(Arrays.equals(list, list2));
	}
	@Test
	public void testReverse2(){
		int [] list = {};
		wb.reverse(list);
		int [] list2 = {};
		assertTrue(Arrays.equals(list, list2));
	}
	
	@Test
	public void testReverse3(){
		int [] list = {1,2,4,5};
		wb.reverse(list);
		int [] list2 = {5,4,2,1};
		assertTrue(Arrays.equals(list, list2));
	}

	@Test
	public void testReverse4(){
		int [] list = {1};
		wb.reverse(list);
		int [] list2 = {1};
		assertTrue(Arrays.equals(list, list2));
	}
}
