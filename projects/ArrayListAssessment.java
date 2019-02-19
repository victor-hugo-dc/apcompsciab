package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListAssessment {

	/**
	 * Given an ArrayList, an Iterator, and a value
	 * populate the ArrayList with all elements that
	 * come after the value in the Iterator. 
	 */
	public static void allGreaterThan(ArrayList<Comparable> al, Iterator<Comparable> it, Comparable value) {
		while(it.hasNext()) {
			Comparable c = it.next();
			if(c.compareTo(value) >= 0)
					al.add(c);
		}
	}
	
	/**
	 * Given two ArrayLists that have been sorted or different lengths, create a sorted ArrayList by merging the two Lists
	 * Please note, you may not Sort the list, you must add them sorted. This means
	 * The sort should run in O(n+m) Not o(nSquared) david.
	 */
	
	public static ArrayList<Comparable> mergeSorted(ArrayList<Comparable> al1, ArrayList<Comparable> al2){
		if(al1.isEmpty()) return al2;
		if(al2.isEmpty()) return al1;
		ArrayList<Comparable> al = new ArrayList<Comparable>();
		boolean start1 = al1.get(0).compareTo(al2.get(0)) > 0;
		for(int i = 0; i < Math.min(al1.size(), al2.size()); i++) {
			if(start1) {
				al.add(al2.remove(i));
				al.add(al1.remove(i));
			} else {
				al.add(al1.remove(i));
				al.add(al2.remove(i));
			}
			i--;
		}
		al.addAll(al2);
		al.addAll(al1);
		return al;
	}
	
	/**
	 * Given an Iterator of Integers, return an ArrayList of Lists where the
	 * values in the inside lists are all the numbers that end with the indexed value
	 * i.e. 12,10,43,67, 23, 894, 77, 29, 22,32,44 would return:
	 * {{10},{},{12,22,32},{43, 23},{894, 44},{},{},{67,77},{},{29}}
	 */
	
	public static ArrayList<ArrayList<Integer>> sortThroughIntegers(Iterator<Integer> it){
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= 9; i++)
			al.add(new ArrayList<Integer>());
		
		while(it.hasNext()) {
			int i = it.next();
			al.get(i%10).add(i);
		}
		
		return al;
	}
	
	/**
	 * Given an ArrayList of data and an ArrayList of indexes, remove all contained between each pair of numbers
	 * i.e. {3,5,7,9} removes all value from [3-5) and from [7-9). In the case of an odd
	 * number of indexes, the last number remove to the end of the List. The ranges will
	 * not overlap
	 */
	
	public static void removeAllBetween(ArrayList values, ArrayList<Integer> indexes) {
		if(indexes.size() % 2 != 0) {
			indexes.add(new Integer(values.size()));
		}
		ArrayList<Object> obj = new ArrayList<Object>();
		int j = 0;
		for(int i = 0; i < values.size(); i++) {
			if(j >= indexes.size()) {
				obj.add(values.get(i));
			} else if(j < indexes.size()-1 && !(i >= indexes.get(j) && i < indexes.get(j+1))) {
				obj.add(values.get(i));
			} if(j < indexes.size()-1 && i >= indexes.get(j+1)) {
				j += 2;
			} 
		}
		values.clear();
		values.addAll(obj);
	}
	
}
