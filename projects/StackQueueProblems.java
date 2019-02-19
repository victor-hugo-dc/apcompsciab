package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Collections;

public class StackQueueProblems<E> {
	
	/**
	 * Using only Stacks and/or Queues (and any control structure you want)
	 * reverse the ArrayList in place (You may use clear)
	 * @param al
	 */
	public void reverseArrayList(ArrayList<E> al){
		MyStack<E> stack = new MyStack<E>();
		stack.addAll(al);
		al.clear();
		al.addAll(stack);
	}
	
	/**
	 * You must use a Stack or Queue to sort the given arrayList
	 * This is not terribly efficient but its a good exercise
	 */
	public void sortArrayList(ArrayList<E> al){
		MyQueue<E> queue = new MyQueue<E>();
		while(!al.isEmpty()) {
			queue.enqueue(al.remove(al.indexOf(findMin(al))));
		} al.addAll(queue);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private E findMin(ArrayList<E> al) {
		E min = al.get(0);
		for(int i = 1; i < al.size(); i++) {
			Comparable c = (Comparable)min;
			Comparable c2 = (Comparable)al.get(i);
			if(c.compareTo(c2) > 0) {
				min = al.get(i);
			}
		}
		return min;
	}
	/**
	 * Using only Stacks and queues "Butterfly" the ArrayList
	 * In other words the first half of the List is reversed 
	 * and the second half is reversed. For example:
	 *     { 1 2 3 4 5 6 7 8 9 0} becomes {5 4 3 2 1 0 9 8 7 6}
	 */
	
	public void butterFlyArrayList(ArrayList<E> al){
		MyStack<E> stackOne = new MyStack<E>();
		MyStack<E> stackTwo = new MyStack<E>();
		
		for(int i = 0; i < al.size()/2; i++) {
			stackOne.push(al.get(i));
			stackTwo.push(al.get(i + al.size()/2));
		}
		for(int i = 0; i < al.size()/2; i++) {
			al.set(i, stackOne.pop());
			al.set(i + al.size()/2, stackTwo.pop());
		}
	}
	
	/**
	 * Using only a stack and Queue (Do not use arraylists)
	 * group all the with equal 1 digits together in the ArrayList (in the order they appear originally)
	 * and return the mode. (The numbers will be all non-negative)
	 */
	
	public int groupAndMode(ArrayList<Integer> al){
		MyQueue<Integer> queue = new MyQueue<Integer>();
		for(int i = 0; !al.isEmpty(); i++) {
			for(int j = 0; j < al.size(); j++) {
				if(al.get(j) % 10 == i) {
					queue.add(al.remove(j--));
				}
			}
		}
		al.addAll(queue);
		return findMode(al);
	}
	
	private int findMode(ArrayList<Integer> al) {
		int mode = Collections.frequency(al, al.get(0));
		for(Integer i : al) {
			mode = Math.max(mode, Collections.frequency(al, i));
		}
		return mode;
	}
}
