package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class SortTestAPlus {
	Random gen = new Random();
	
	class Student {
		String firstName, lastName;
		public Student(String l, String f){
			firstName = f;
			lastName = l;
		}
		
		public String getFirstName(){
			return firstName;
		}
		
		public String getLastName(){
			return lastName;
		}
		
		public String toString(){
			
			return "{"+lastName+", "+firstName+"}";
		}
		
		public boolean equals(Object o) {
			Student s = (Student)o;
			return s.getFirstName().equals(firstName) && s.getLastName().equals(lastName);
		}
	}
	
	class MyComparator implements Comparator<Student> {
		
		public int compare(Student s1, Student s2){
			if(s1.getLastName().compareTo(s2.getLastName()) < 0)
				return -1;
			if(s1.getLastName().compareTo(s2.getLastName()) > 0)
				return 1;
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
	}
	
	Comparator<Student> myComp = new MyComparator();
	
	private List<Student> createRandomList(int size) {
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < size; i++) {
			String word = "";
			if (gen.nextInt(2) == 0)
				word += (char) (gen.nextInt(26) + 65);
			else
				word += (char) (gen.nextInt(26) + 97);

			while (gen.nextInt(10) != 0)
				if (gen.nextInt(2) == 0)
					word += (char) (gen.nextInt(26) + 65);
				else
					word += (char) (gen.nextInt(26) + 97);
			String word2 = "";
			if (gen.nextInt(2) == 0)
				word2 += (char) (gen.nextInt(26) + 65);
			else
				word2 += (char) (gen.nextInt(26) + 97);
		
			while (gen.nextInt(10) != 0)
				if (gen.nextInt(2) == 0)
					word2 += (char) (gen.nextInt(26) + 65);
				else
					word2 += (char) (gen.nextInt(26) + 97);
			
			list.add(new Student(word,word2));
		}
		return list;
	}
	
	@Test 
	public void testInsertionSortReallySmall() {
		List<Student> list = createRandomList(10);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.insertionSort(list, myComp);
		assertEquals(list, list2);

	}
	@Test
	public void testInsertionSortSmall(){
		List<Student> list = createRandomList(1000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.insertionSort(list, myComp);
		assertEquals(list, list2);
	}

	@Test
	public void testInsertionSortMedium(){
		List<Student> list = createRandomList(10000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.insertionSort(list, myComp);
		assertEquals(list, list2);
	}
	/*
	@Test
	public void testInsertionSortLarge(){
		List<Student> list = createRandomList(100000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.insertionSort(list, myComp);
		assertEquals(list, list2);
	}
	*/
	
	@Test 
	public void testSelectionSortReallySmall() {
		List<Student> list = createRandomList(10);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.selectionSort(list, myComp);
		assertEquals(list, list2);

	}
	@Test
	public void testSelectionSortSmall(){
		List<Student> list = createRandomList(1000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.selectionSort(list, myComp);
		assertEquals(list, list2);
		
	}

	@Test
	public void testSelectionSortMedium(){
		List<Student> list = createRandomList(10000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.selectionSort(list, myComp);
		assertEquals(list, list2);
	}
	
	/*@Test
	public void testSelectionSortLarge(){
		List<Student> list = createRandomList(100000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.selectionSort(list, myComp);
		assertEquals(list, list2);
	}*/

	
	@Test 
	public void testMergeSortReallySmall() {
		List<Student> list = createRandomList(10);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.mergeSort(list, myComp);
		assertEquals(list, list2);
	}
	@Test
	public void testMergeSortSmall(){
		List<Student> list = createRandomList(1000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.mergeSort(list, myComp);
		assertEquals(list, list2);
	}

	@Test
	public void testMergeSortMedium(){
		List<Student> list = createRandomList(10000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.mergeSort(list, myComp);
		//assertEquals(list, list2);
		for(int i = 0; i < list.size(); i++){
			assertEquals(list.get(i), list2.get(i));
		}
	}
	/*
	@Test
	public void testMergeSortLarge(){
		List<Student> list = createRandomList(100000);
		List<Student> list2 = new ArrayList<Student>(list);
		Collections.copy(list2, list);
		Collections.sort(list2, myComp);
		DifferentSortsAPlus.mergeSort(list, myComp);
		assertEquals(list, list2);
	}
*/
	
}
