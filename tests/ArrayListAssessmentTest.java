package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListAssessmentTest {

	@Test
	public void allGreaterThanTest1() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(2);
		al2.add(8);
		al2.add(9);
		ArrayListAssessment.allGreaterThan(al1, al2.iterator(), 6);
		ArrayList<Comparable> al3 = new ArrayList<Comparable>();
		al3.add(7);
		al3.add(10);
		al3.add(12);
		al3.add(8);
		al3.add(9);
		assertEquals(al3,al1);
	}
	
	@Test
	public void allGreaterThanTest2() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(2);
		al2.add(8);
		al2.add(9);
		ArrayListAssessment.allGreaterThan(al1, al2.iterator(), 1);
		ArrayList<Comparable> al3 = new ArrayList<Comparable>();
		al3.add(4);
		al3.add(7);
		al3.add(10);
		al3.add(12);
		al3.add(2);
		al3.add(8);
		al3.add(9);
		assertEquals(al3,al1);
	}
	
	@Test
	public void allGreaterThanTest3() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(2);
		al2.add(8);
		al2.add(9);
		ArrayListAssessment.allGreaterThan(al1, al2.iterator(), 13);
		ArrayList<Comparable> al3 = new ArrayList<Comparable>();
		assertEquals(al3,al1);
	}
	
	@Test
	public void allGreaterThanTest4() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(2);
		al2.add(8);
		al2.add(9);
		ArrayListAssessment.allGreaterThan(al1, al2.iterator(), 10);
		ArrayList<Comparable> al3 = new ArrayList<Comparable>();
		al3.add(10);
		al3.add(12);
		assertEquals(al3,al1);
	}
	
	@Test
	public void mergeSortedTest1() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(14);
		al1.add(3);
		al1.add(5);
		al1.add(9);
		al1.add(11);
		ArrayList<Comparable> result = ArrayListAssessment.mergeSorted(al1, al2);
		ArrayList<Comparable> answer = new ArrayList<Comparable>();
		answer.add(3);
		answer.add(4);
		answer.add(5);
		answer.add(7);
		answer.add(9);
		answer.add(10);
		answer.add(11);
		answer.add(12);
		answer.add(14);
		assertEquals(answer.size(),result.size());
		assertEquals(answer, result);
	}

	
	@Test
	public void mergeSortedTest2() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(14);
		ArrayList<Comparable> result = ArrayListAssessment.mergeSorted(al1, al2);
		ArrayList<Comparable> answer = new ArrayList<Comparable>();
		answer.add(4);
		answer.add(7);
		answer.add(10);
		answer.add(12);
		answer.add(14);
		assertEquals(answer.size(),result.size());
		assertEquals(answer, result);
	}	
	@Test
	public void mergeSortedTest3() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		
		al1.add(3);
		al1.add(5);
		al1.add(9);
		al1.add(11);
		ArrayList<Comparable> result = ArrayListAssessment.mergeSorted(al1, al2);
		ArrayList<Comparable> answer = new ArrayList<Comparable>();
		answer.add(3);
		answer.add(5);
		answer.add(9);
		answer.add(11);
		assertEquals(answer.size(),result.size());
		assertEquals(answer, result);
	}

	
	@Test
	public void mergeSortedTest4() {
		ArrayList<Comparable> al1 = new ArrayList<Comparable>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		ArrayList<Comparable> result = ArrayListAssessment.mergeSorted(al1, al2);
		ArrayList<Comparable> answer = new ArrayList<Comparable>();
		assertEquals(answer, result);
	}	
	
	@Test
	public void sortThroughIntegersTest1() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(204);
		al1.add(321);
		al1.add(322);
		al1.add(344);
		al1.add(542);
		al1.add(645);
		al1.add(504);
		al1.add(100);
		al1.add(20);
		al1.add(1111);
		ArrayList<ArrayList<Integer>> result = ArrayListAssessment.sortThroughIntegers(al1.iterator());
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<10;i++) {
			answer.add(new ArrayList<Integer>());
		}
		answer.get(0).add(100);
		answer.get(0).add(20);
		answer.get(1).add(321);
		answer.get(1).add(1111);
		answer.get(2).add(322);
		answer.get(2).add(542);
		answer.get(4).add(204);
		answer.get(4).add(344);
		answer.get(4).add(504);
		answer.get(5).add(645);
		assertEquals(answer, result);
	}
	
	@Test
	public void sortThroughIntegersTest2() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = ArrayListAssessment.sortThroughIntegers(al1.iterator());
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<10;i++) {
			answer.add(new ArrayList<Integer>());
		}
		assertEquals(answer, result);
	}
	
	@Test
	public void sortThroughIntegersTest3() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(204);
		al1.add(324);
		al1.add(324);
		al1.add(344);
		al1.add(544);
		al1.add(644);
		al1.add(504);
		al1.add(104);
		al1.add(24);
		al1.add(1114);
		ArrayList<ArrayList<Integer>> result = ArrayListAssessment.sortThroughIntegers(al1.iterator());
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<10;i++) {
			answer.add(new ArrayList<Integer>());
		}
		answer.get(4).add(204);
		answer.get(4).add(324);
		answer.get(4).add(324);
		answer.get(4).add(344);
		answer.get(4).add(544);
		answer.get(4).add(644);
		answer.get(4).add(504);
		answer.get(4).add(104);
		answer.get(4).add(24);
		answer.get(4).add(1114);
		assertEquals(answer, result);
	}
	
	@Test
	public void removeAllBetweenTest1() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12); //here
		al2.add(14); //here
		al2.add(3); //here
		al2.add(5);
		al2.add(9); //here
		al2.add(11);
		al1.add(3);
		al1.add(4);
		al1.add(5);
		al1.add(7);
		ArrayList answer = new ArrayList();
		answer.add(4);
		answer.add(7);
		answer.add(10);
		answer.add(14);
		answer.add(9);
		answer.add(11);
		ArrayListAssessment.removeAllBetween(al2, al1);
		assertEquals(answer, al2);

	}
	
	@Test
	public void removeAllBetweenTest2() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(14);
		al2.add(3);
		al2.add(5);
		al2.add(9);
		al2.add(11);
		al1.add(0);
		al1.add(4);
		al1.add(6);
		al1.add(9);
		ArrayList answer = new ArrayList();
		
		answer.add(14);
		answer.add(3);
		ArrayListAssessment.removeAllBetween(al2, al1);
		assertEquals(answer, al2);

	}	
	@Test
	public void removeAllBetweenTest3() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(14);
		al2.add(3);
		al2.add(5);
		al2.add(9);
		al2.add(11);
		al1.add(0);
		ArrayList answer = new ArrayList();
		
		ArrayListAssessment.removeAllBetween(al2, al1);
		assertEquals(answer, al2);

	}
	
	@Test
	public void removeAllBetweenTest4() {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Comparable> al2= new ArrayList<Comparable>();
		al2.add(4);
		al2.add(7);
		al2.add(10);
		al2.add(12);
		al2.add(14);
		al2.add(3);
		al2.add(5);
		al2.add(9);
		al2.add(11);
		al2.add(13);
		al2.add(8);
		al2.add(4);
		al1.add(1);
		al1.add(3);
		al1.add(4);
		al1.add(6);
		al1.add(8);
		ArrayList answer = new ArrayList();
		answer.add(4);
		answer.add(12);
		answer.add(5);
		answer.add(9);
		
		ArrayListAssessment.removeAllBetween(al2, al1);
		assertEquals(answer, al2);

	}
}
