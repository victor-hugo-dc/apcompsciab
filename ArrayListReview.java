package edu.fcps.ab;

import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ArrayListReview {

	/**
	 * removes all elements with the given value
	 */
	public static void removeAllElements(ArrayList al, Object value) {
		Iterator<Object> it = al.iterator();
		while(it.hasNext()) {
			if(it.next().equals(value))
				it.remove();
		}
	}
	
	/**
	 * reverses the ArrayList values
	 */
	public static void reverseArrayList(ArrayList al) {
		for(int i = 0; i < al.size()/2; i++) {
			Object o = al.get(al.size()-1-i);
			al.set(al.size()-1-i, al.get(i));
			al.set(i, o);
		}
	}
	
	/**
	 * Removes all instances of the maximum and minimum values
	 */
	public static void removeMaxMin(ArrayList<Comparable> al) {
		Object min = al.get(0), max = al.get(0);
		for(int i = 0; i < al.size(); i++) {
			if(al.get(i).compareTo(max) > 0)
				max = al.get(i);
			else if(al.get(i).compareTo(min) < 0)
				min = al.get(i);
		}
		removeAllElements(al, min);
		removeAllElements(al, max);
	}
	
	/**
	 * merges the two arraylists into a new list. Alternates 
	 * values from each list
	 */
	public static ArrayList merge(ArrayList al1, ArrayList al2) {
		ArrayList al = new ArrayList<Object>();
		Iterator<Object> it1 = al1.iterator();
		Iterator<Object> it2 = al2.iterator();
		while(it1.hasNext() && it2.hasNext()) {
			al.add(it1.next());
			al.add(it2.next());
			it1.remove();
			it2.remove();
		}
		al.addAll(al1);
		al.addAll(al2);
		return al;
	}
	
	/**
	 * removes all values between the given indexes
	 * Including given indexes
	 * 
	 */
	public static void removeAllBetween(ArrayList al, int index1, int index2) {
		Object o1 = al.get(Math.min(index1, index2)), o2 = al.get(Math.max(index1, index2));
		for(int i = 0; i < al.size(); i++) {
			if(i >= al.indexOf(o1) && i <= al.indexOf(o2))
				al.remove(i--);
		}
	}
	
	/**
	 * keeps only the values between the given indexes
	 * including the given indexes
	 */
	public static void keepAllBetween(ArrayList al, int index1, int index2) {
		Object o1 = al.get(Math.min(index1, index2)), o2 = al.get(Math.max(index1, index2));
		for(int i = 0; i < al.size(); i++) {
			if(i < al.indexOf(o1) || i > al.indexOf(o2))
				al.remove(i--);
		}
	}
	
	
}
