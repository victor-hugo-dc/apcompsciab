package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListAndIteratorAssessmentTest {


		@Test
		public void removeDuplicatesTest1() {
			List<Integer> list = new ArrayList<Integer>();
			list.add(10);
			list.add(20);
			list.add(10);
			list.add(40);
			list.add(10);
			list.add(10);
			list.add(10);
			list.add(40);
			list.add(40);
			list.add(10);
			List<Integer> result = new ArrayList<Integer>();
			result.add(10);
			result.add(20);
			result.add(40);
			ListAndIteratorAssessment.removeDuplicates(list);
			assertEquals(3, list.size());
			assertEquals(result,list);
		}
		@Test
		public void removeDuplicatesTest2() {
			List<Integer> list = new ArrayList<Integer>();
			list.add(10);
			list.add(20);
			list.add(30);
			list.add(40);
			list.add(50);
			list.add(60);
			list.add(70);
			list.add(80);
			list.add(90);
			list.add(100);
			List<Integer> result = new ArrayList<Integer>();
			result.add(10);
			result.add(20);
			result.add(30);
			result.add(40);
			result.add(50);
			result.add(60);
			result.add(70);
			result.add(80);
			result.add(90);
			result.add(100);
			ListAndIteratorAssessment.removeDuplicates(list);
			assertEquals(10, list.size());
			assertEquals(result,list);
		}
		
		@Test
		public void removeDuplicatesTest3() {
			List<Integer> list = new ArrayList<Integer>();
			list.add(10);
			list.add(10);
			list.add(10);
			list.add(10);
			list.add(10);
			list.add(10);
			list.add(10);
			List<Integer> result = new ArrayList<Integer>();
			result.add(10);
			ListAndIteratorAssessment.removeDuplicates(list);

			assertEquals(1,list.size());
			assertEquals(result,list);
		}
		
		@Test
		public void removeDuplicatesTest4() {
			List<Integer> list = new ArrayList<Integer>();
			List<Integer> result = new ArrayList<Integer>();
			ListAndIteratorAssessment.removeDuplicates(list);
			assertEquals(result, list);
		}
		
		@Test
		public void doubleArrayTest1() {
			Integer [] array = new Integer[] {1,2,3,4,5};
			Integer [] result = new Integer[] {1,2,3,4,5,1,2,3,4,5};
			Object [] answer = ListAndIteratorAssessment.doubleArray(array);
			assertEquals(10,answer.length);
			for(int i = 0;i<result.length;i++) {
				assertEquals(result[i], answer[i]);
			}
		}
		
		@Test
		public void doubleArrayTest2() {
			Integer [] array = new Integer[] {0,0,0,0,0};
			Integer [] result = new Integer[] {0,0,0,0,0,0,0,0,0,0};
			Object [] answer = ListAndIteratorAssessment.doubleArray(array);
			assertEquals(10,answer.length);
			for(int i = 0;i<result.length;i++) {
				assertEquals(result[i], answer[i]);
			}
		}
		
		@Test
		public void doubleArrayTest3() {
			String [] array = new String[] {"Sam","Fred","Nikki"};
			String [] result = new String[] {"Sam","Fred","Nikki","Sam","Fred","Nikki"};
			Object [] answer = ListAndIteratorAssessment.doubleArray(array);
			assertEquals(6,answer.length);
			for(int i = 0;i<result.length;i++) {
				assertEquals(result[i], answer[i]);
			}
		}
		
		@Test
		public void doubleArrayTest4() {
			String [] array = new String[0];
			Object [] answer =  ListAndIteratorAssessment.doubleArray(array);
			assertEquals(0,answer.length);
		}
		
		@Test
		public void reverseListUsingListIteratorTest1() {
			ArrayList<String> al = new ArrayList<String>();
			al.add("Sam");
			al.add("Fred");
			al.add("Ralph");
			al.add("Nikki");
			ArrayList<String> answer = new ArrayList<String>();
			answer.add("Nikki");
			answer.add("Ralph");
			answer.add("Fred");
			answer.add("Sam");
			ListAndIteratorAssessment.reverseListUsingListIterator(al.listIterator());
			assertEquals(answer,al);
		}
	
		@Test
		public void reverseListUsingListIteratorTest2() {
			ArrayList<String> al = new ArrayList<String>();
			al.add("Sam");
			al.add("Fred");
			al.add("Ralph");
			al.add("Nikki");
			al.add("Bob");
			ArrayList<String> answer = new ArrayList<String>();
			answer.add("Bob");
			answer.add("Nikki");
			answer.add("Ralph");
			answer.add("Fred");
			answer.add("Sam");
			ListAndIteratorAssessment.reverseListUsingListIterator(al.listIterator());
			assertEquals(answer,al);
		}
		
		@Test
		public void reverseListUsingListIteratorTest3() {
			ArrayList<String> al = new ArrayList<String>();
			ArrayList<String> answer = new ArrayList<String>();
			ListAndIteratorAssessment.reverseListUsingListIterator(al.listIterator());
			assertEquals(answer,al);
		}
		
		@Test
		public void reverseListUsingListIteratorTest4() {
			ArrayList<String> al = new ArrayList<String>();
			al.add("Sam");
			ArrayList<String> answer = new ArrayList<String>();
			answer.add("Sam");
			ListAndIteratorAssessment.reverseListUsingListIterator(al.listIterator());
			assertEquals(answer,al);
			
		}
		
		@Test
		public void replaceAverageTest1() {
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(10);
			al.add(20);
			al.add(30);
			al.add(40);
			al.add(50);
			ArrayList<Integer> answer = new ArrayList<Integer>();
			answer.add(30);
			answer.add(30);
			answer.add(30);
			answer.add(30);
			answer.add(30);
			ListAndIteratorAssessment.replaceWithAverage(al.listIterator());
			assertEquals(answer, al);
		}

		@Test
		public void replaceAverageTest2() {
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(10);
			al.add(20);
			al.add(30);
			al.add(40);
			al.add(50);
			al.add(60);
			ArrayList<Integer> answer = new ArrayList<Integer>();
			answer.add(35);
			answer.add(35);
			answer.add(35);
			answer.add(35);
			answer.add(35);
			answer.add(35);
			ListAndIteratorAssessment.replaceWithAverage(al.listIterator());
			assertEquals(answer, al);
		}
		
		@Test
		public void replaceAverageTest3() {
			ArrayList<Integer> al = new ArrayList<Integer>();
			ArrayList<Integer> answer = new ArrayList<Integer>();
			ListAndIteratorAssessment.replaceWithAverage(al.listIterator());
			assertEquals(answer,al);
		}
		
		@Test
		public void replaceAverageTest4() {
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(40);
			al.add(10);
			al.add(50);
			al.add(60);
			ArrayList<Integer> answer = new ArrayList<Integer>();
			answer.add(40);
			answer.add(40);
			answer.add(40);
			answer.add(40);
			ListAndIteratorAssessment.replaceWithAverage(al.listIterator());
			assertEquals(answer,al);
		}

}
