package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ArrayListReviewTest {

	private ArrayList<Integer> makeIntList(int i) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int j = 0; j < i; j++) {
			al.add(j);
		}
		return al;
	}

	private ArrayList<String> makeStringList(int i) {
		ArrayList<String> al = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			al.add("test case " + j);
		}
		return al;
	}

	@Test
	public void removeAllElementsTest6() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		ArrayListReview.removeAllElements(al, 2);
		assertEquals(9, al.size());
		assertEquals(result, al);

	}

	@Test
	public void removeAllElementsTest3() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(0);
		al.add(0);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		ArrayListReview.removeAllElements(al, 0);
		assertEquals(9, al.size());
		assertEquals(result, al);
	}

	@Test
	public void removeAllElementsTest2() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		ArrayListReview.removeAllElements(al, -1);
		assertEquals(10, al.size());
		assertEquals(result, al);
	}

	@Test
	public void removeAllElementsTest4() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(3, 4);
		al.add(3, 4);
		al.add(8, 4);
		al.add(9, 4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(5);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		ArrayListReview.removeAllElements(al, 4);
		assertEquals(9, al.size());
		assertEquals(result, al);

	}

	@Test
	public void removeAllElementsTest1() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayListReview.removeAllElements(al, 2);
		assertEquals(0, al.size());
		assertEquals(result, al);

	}

	@Test
	public void removeAllElementsTest5() {
		ArrayList<String> al = makeStringList(5);

		ArrayList<String> result = makeStringList(5);
		result.remove(4);
		ArrayListReview.removeAllElements(al, "test case 4");
		assertEquals(4, al.size());
		assertEquals(result, al);

	}

	@Test
	public void removeAllElementsTest7() {
		ArrayList<String> al = makeStringList(5);
		al.add(1,"test case 2");
		al.add(2, "test case 2");
		ArrayList<String> result = makeStringList(5);
		
		result.remove(2);
		ArrayListReview.removeAllElements(al, "test case 2");
		assertEquals(4, al.size());
		assertEquals(result, al);

	}
	
	@Test
	public void reverseTest1() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(9);
		result.add(8);
		result.add(7);
		result.add(6);
		result.add(5);
		result.add(4);
		result.add(3);
		result.add(2);
		result.add(1);
		result.add(0);
		ArrayListReview.reverseArrayList(al);
		assertEquals(result, al);
	}
	
	@Test
	public void reverseTest2() {
		ArrayList<String> al = makeStringList(5);
		ArrayList<String> result = new ArrayList<String>();
		result.add("test case 4");
		result.add("test case 3");
		result.add("test case 2");
		result.add("test case 1");
		result.add("test case 0");
		ArrayListReview.reverseArrayList(al);
		assertEquals(result,al);
	}
	
	@Test
	public void reverseTest3() {
		ArrayList<Integer> al = new ArrayList();
		ArrayListReview.reverseArrayList(al);
		assertEquals(0,al.size());
	}
	
	@Test
	public void removeMinMaxTest1() {
		ArrayList<Comparable> al = new ArrayList<Comparable>();
		al.add(16);
		al.add(10);
		al.add(10);
		al.add(16);
		al.add(13);
		al.add(12);
		al.add(10);
		al.add(14);
		al.add(17);
		al.add(10);
		ArrayList<Comparable> result = new ArrayList<Comparable>();
		result.add(16);
		result.add(16);
		result.add(13);
		result.add(12);
		result.add(14);
		ArrayListReview.removeMaxMin(al);
		assertEquals(5, al.size());
		assertEquals(result, al);
	}
	
	@Test
	public void removeMinMaxTest2() {
		ArrayList<Comparable> al = new ArrayList<Comparable>();
		al.add("apple");
		al.add("Apple");
		al.add("zed");
		al.add("zed");
		al.add("Zed");
		al.add("Apple");
		al.add("Carrot");
		al.add("Apple");
		ArrayList<Comparable> result = new ArrayList<Comparable>();
		result.add("apple");
		result.add("Zed");
		result.add("Carrot");
		ArrayListReview.removeMaxMin(al);
		assertEquals(3, al.size());
		assertEquals(result, al);
	}
	
	@Test
	public void removeMinMaxTest3() {
		ArrayList<Comparable> al = new ArrayList<Comparable>();
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		al.add("apple");
		ArrayList<Comparable> result = new ArrayList<Comparable>();
		ArrayListReview.removeMaxMin(al);
		assertEquals(0,al.size());
		assertEquals(result,al);
	}
	
	@Test
	public void testMerge1() {
		ArrayList<Integer> al1 = makeIntList(5);
		ArrayList<Integer> al2 = makeIntList(5);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		result.add(1);
		result.add(1);
		result.add(2);
		result.add(2);
		result.add(3);
		result.add(3);
		result.add(4);
		result.add(4);
		ArrayList answer = ArrayListReview.merge(al1, al2);
		assertEquals(10,answer.size());
		assertEquals(result,answer);
	}
	
	@Test
	public void mergeTest2() {
		ArrayList<Integer> al1 = makeIntList(5);
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		ArrayList answer = ArrayListReview.merge(al1, al2);
		assertEquals(5,answer.size());
		assertEquals(result,answer);
	}
		
	@Test
	public void mergeTest3() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Integer> al2 = makeIntList(5);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		ArrayList answer = ArrayListReview.merge(al1, al2);
		assertEquals(5,answer.size());
		assertEquals(result,answer);
	}
	
	@Test
	public void mergeTest4() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		//ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList answer = ArrayListReview.merge(al1, al2);
		assertEquals(0,answer.size());
	}
	
	@Test
	public void mergeTest5() {
		ArrayList<String> al1 = makeStringList(10);
		
		ArrayList<String> al2 = makeStringList(5);
		ArrayList<String> result = new ArrayList<String>();
		result.add("test case 0");
		result.add("test case 0");
		result.add("test case 1");
		result.add("test case 1");
		result.add("test case 2");
		result.add("test case 2");
		result.add("test case 3");
		result.add("test case 3");
		result.add("test case 4");
		result.add("test case 4");
		result.add("test case 5");
		result.add("test case 6");
		result.add("test case 7");
		result.add("test case 8");
		result.add("test case 9");
		ArrayList<String> answer = ArrayListReview.merge(al1, al2);
		assertEquals(15,answer.size());
		assertEquals(result, answer);
	}
	
	@Test
	public void removeAllBetweenTest1() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(9);
		ArrayListReview.removeAllBetween(al, 1, 8);
		assertEquals(result,al);
	}

	@Test
	public void removeAllBetweenTest2() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayListReview.removeAllBetween(al, 0,9);
		assertEquals(result,al);
	}
	
	@Test
	public void removeAllBetweenTest3() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(9);
		ArrayListReview.removeAllBetween(al, 3, 8);
		assertEquals(result,al);
	}
	
	@Test
	public void removeAllBetweenTest4() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(9);
		ArrayListReview.removeAllBetween(al, 8, 3);
		assertEquals(result,al);
		
	}
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void removeAllBetweenTest5() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayListReview.removeAllBetween(al, 3,11);
		assertEquals(result,al);
		
	}
	
	@Test
	public void keepAllBetweenTest1() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		ArrayListReview.keepAllBetween(al, 2, 7);
		assertEquals(result,al);
	}

	@Test
	public void keepAllBetweenTest2() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = makeIntList(10);
		ArrayListReview.keepAllBetween(al, 0, 9);
		assertEquals(result, al);
	}
	
	@Test
	public void keepAllBetweenTest3() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		
		ArrayListReview.keepAllBetween(al, 7, 3);
		assertEquals(result,al);
		
	}
	@Test(expected=java.lang.IndexOutOfBoundsException.class)
	public void keepAllBetweenTest4() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList<Integer> result = makeIntList(10);
		ArrayListReview.keepAllBetween(al, -3, 9);
		assertEquals(result, al);
	}
}