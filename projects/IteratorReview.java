package edu.fcps.ab;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
@SuppressWarnings({"unchecked", "rawtypes"})
public class IteratorReview {

	
	//Removes all elements from the iterator 
	// places all elements in a new ArrayList in reverse order
	public static ArrayList removeAll(Iterator it) {
		ArrayList<Object> al = new ArrayList<Object>();
		while(it.hasNext()) {
			Object o = it.next();
			al.add(o);
			it.remove();
		}
		ArrayListReview.reverseArrayList(al);
		return al;
	}
	
	// Populates the given List with every other element
	// from the iterator
	public static void everyOther(Iterator it, List list) {
		while(it.hasNext()) {
			list.add(it.next());
			if(it.hasNext()) {
				it.next();
			}
		}
	}
	
	// Uses the ListIterator to remove the value that preceeds
	// any instances of value. In the case of it being the first element
	// do nothing.
	public static void removePreceeding(ListIterator it, Object value) {
		while(it.hasNext()) {
			if(it.next().equals(value)) {
				it.previous();
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
				it.next();
			}
		}
	}
	
	// replaces all instances of value with the 
	// value that comes after it. In the case of the last element
	// removes that element
	public static void removeSucceeding(ListIterator it, Object value) {
		while(it.hasNext()) {
			Object o = it.next();
			if(it.hasNext() && o.equals(value)) {
				Object o2 = it.next();
				it.previous();
				it.previous();
				it.set(o2);
			}
			else if(!it.hasNext() && o.equals(value)) {
				it.remove();
			}
		}
	}
	
	// returns an arrayList of all elements that preceed
	// the instances of value. In the case of index of the value being 0
	// add a -1
	
	public static ArrayList<Integer> preceedingIndex(ListIterator it, Object value){
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(it.hasNext()) {
			if(it.next().equals(value)) {
				al.add(it.nextIndex()-2);
			}
		}
		return al;
	}
}
