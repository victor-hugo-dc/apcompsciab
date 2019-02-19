package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
@SuppressWarnings({"unchecked", "rawtypes"})
public class ListAndIteratorAssessment {

	/*
	 * Removes all duplicate values in col. You may use
	 * additional Lists but do not try to convert col
	 * to a List 
	 */
	public static void removeDuplicates(Collection col) {
		Iterator it = col.iterator();
		ArrayList al = new ArrayList();
		while(it.hasNext()) {
			Object o = it.next();
			if(!al.contains(o)) {
				al.add(o);
			}
			else it.remove();
		}
	}
	
	/**
	 * returns a new array with the values of arr entered twice.
	 * ie 1,2,3,4,5 becomes 1,2,3,4,5,1,2,3,4,5
	 * Do not use more than 1 loop.
	 * @param arr
	 * @return
	 */
	public static Object[] doubleArray(Object [] arr) {
		Object [] obj = new Object[arr.length*2];
		for(int i = 0; i < arr.length; i++) {
			obj[i] = arr[i];
			obj[i+arr.length] = arr[i];
		}
		return obj;
	}
	
	/**
	 * using only an ListIterator reverse the values of the
	 * List. 
	 * 
	 * @param li
	 */
	public static void reverseListUsingListIterator(ListIterator li) {
		ArrayList al = new ArrayList();
		while(li.hasNext()) {
			al.add(li.next());
		}
		int index = 0;
		while(li.hasPrevious()) {
			li.previous();
			li.set(al.get(index));
			index++;
		}
	}
	
	/**
	 * finds the average of the values in li and replaces all
	 * the values with that average.
	 * @param li
	 */
	public static void replaceWithAverage(ListIterator<Integer> li) {
		int avg = 0;
		int div = 0;
		while(li.hasNext()) {
			avg += li.next();
			div ++;
		}
		if(div == 0) {div++;}
		avg /= div;
		while(li.hasPrevious()) {
			li.previous();
			li.set(avg);
		}
	}
}
