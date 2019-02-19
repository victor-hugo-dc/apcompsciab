package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
@SuppressWarnings({"unchecked", "rawtypes","unused"})
public class IteratorReviewTest {

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
	public void removeAllTest1() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList result = IteratorReview.removeAll(al.iterator());
		ArrayList answer = new ArrayList();
		for (int i = 9; i >= 0; i--)
			answer.add(i);
		assertTrue(al.isEmpty());
		assertEquals(answer, result);
	}

	@Test
	public void removeAllTest2() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList result = IteratorReview.removeAll(al.iterator());
		ArrayList answer = new ArrayList();
		assertTrue(al.isEmpty());
		assertTrue(answer.isEmpty());
	}

	@Test
	public void removeAllTest3() {
		ArrayList<String> al = this.makeStringList(5);
		ArrayList result = IteratorReview.removeAll(al.iterator());
		ArrayList answer = new ArrayList();
		for (int i = 4; i >= 0; i--)
			answer.add("test case " + i);
		assertTrue(al.isEmpty());
		assertEquals(answer, result);

	}

	@Test
	public void removeAllTest4() {
		ArrayList<String> al = this.makeStringList(1);
		ArrayList result = IteratorReview.removeAll(al.iterator());
		ArrayList answer = new ArrayList();
		answer.add("test case " + 0);
		assertTrue(al.isEmpty());
		assertEquals(answer, result);
	}

	@Test
	public void everyOtherTest1() {
		ArrayList<Integer> al = makeIntList(10);
		ArrayList result = new ArrayList();
		IteratorReview.everyOther(al.iterator(), result);
		ArrayList answer = new ArrayList();
		for (int i = 0; i < 10; i += 2) {
			answer.add(i);
		}
		assertEquals(al.size() / 2, result.size());
		assertEquals(answer, result);
	}

	@Test
	public void everyOtherTest2() {
		ArrayList<Integer> al = makeIntList(13);
		ArrayList result = new ArrayList();
		IteratorReview.everyOther(al.iterator(), result);
		ArrayList answer = new ArrayList();
		for (int i = 0; i < 13; i += 2) {
			answer.add(i);
		}
		assertEquals((al.size() / 2) + 1, result.size());
		assertEquals(answer, result);

	}

	@Test
	public void everyOtherTest3() {
		ArrayList<Integer> al = makeIntList(1);
		ArrayList result = new ArrayList();
		IteratorReview.everyOther(al.iterator(), result);
		ArrayList answer = new ArrayList();
		answer.add(0);

		assertEquals((al.size() / 2)+1, result.size());
		assertEquals(answer, result);
	}

	@Test
	public void removePreceedingTest1() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(4);
		al.add(6, 4);
		al.add(8, 4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		IteratorReview.removePreceeding(al.listIterator(), 4);
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(4);
		result.add(4);
		result.add(4);
		result.add(7);
		result.add(8);
		result.add(4);
		assertEquals(result, al);
	}

	@Test
	public void removePreceedingTest2() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(0, 2);
		al.add(6, 2);
		al.add(8, 2);
		al.add(0, 2);
		ArrayList<Integer> result = new ArrayList<Integer>();
		IteratorReview.removePreceeding(al.listIterator(), 2);
		result.add(2);
		result.add(0);
		result.add(2);
		result.add(3);
		result.add(2);
		result.add(2);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		assertEquals(result, al);
	}

	@Test
	public void removePreceedingTest3() {
		ArrayList<Integer> al = makeIntList(10);

		ArrayList<Integer> result = makeIntList(10);
		IteratorReview.removePreceeding(al.listIterator(), 10);
		assertEquals(result, al);
	}

	@Test
	public void removePreceedingTest4() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		IteratorReview.removePreceeding(al.listIterator(), 0);
		assertTrue(al.isEmpty());
	}

	@Test
	public void removePreceedingTest5() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(4);
		al.add(6, 4);
		al.add(8, 4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		IteratorReview.removePreceeding(al.listIterator(5), 4);
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(4);
		result.add(4);
		result.add(7);
		result.add(8);
		result.add(4);
		assertEquals(result, al);
	}

	@Test
	public void removeSucceedingTest1() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(6, 4);
		al.add(8, 4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		IteratorReview.removeSucceeding(al.listIterator(), 4);
		result.add(0);
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(5);
		result.add(5);
		result.add(6);
		result.add(6);
		result.add(7);
		result.add(7);
		result.add(8);
		result.add(9);
		assertEquals(result, al);
	}
	
	@Test
	public void removeSucceedingTest2() {
			ArrayList<Integer> al = makeIntList(10);
			al.add(4);
			ArrayList<Integer> result = new ArrayList<Integer>();
			IteratorReview.removeSucceeding(al.listIterator(), 4);
			result.add(0);
			result.add(1);
			result.add(2);
			result.add(3);
			result.add(5);
			result.add(5);
			result.add(6);
			result.add(7);
			result.add(8);
			result.add(9);
			assertEquals(result,al);
	}
	
	@Test
	public void removeSucceedingTest3() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(4);
		IteratorReview.removeSucceeding(al.listIterator(), 4);
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void removeSucceedingTest4() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		IteratorReview.removeSucceeding(al.listIterator(), 4);
		assertTrue(al.isEmpty());
	}
	
	@Test
	public void preceedingIndexTest1() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(4);
		al.add(6, 4);
		al.add(8, 4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> answer = IteratorReview.preceedingIndex(al.listIterator(), 4);
		result.add(3);
		result.add(5);
		result.add(7);
		result.add(11);
		assertEquals(result,answer);
		
	}
	
	@Test
	public void preceedingIndexTest2() {
		ArrayList<Integer> al = makeIntList(10);
		al.add(0,10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> answer = IteratorReview.preceedingIndex(al.listIterator(), 10);
		result.add(-1);
		assertEquals(result,answer);
	}
	
	@Test
	public void preceedingIndexTest3() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(4);
		al.add(4);
		al.add(4);
		al.add(4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> answer = IteratorReview.preceedingIndex(al.listIterator(), 4);
		result.add(-1);
		result.add(0);
		result.add(1);
		result.add(2);
		assertEquals(result,answer);
	}
}
