package edu.fcps.ab;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
public class LinkedData {

	public static class Node<E>{
		public Node<E> next;
		public Node<E> previous;
		public E data;
		
		public Node(E d) {
			data = d;
		}
		
		public String toString() {
			if(next == null) return "";
			return data+", "+next.toString();
		}
		
		public boolean equals(Object o) {
			Node<E> node = (Node<E>)o;
			if(node == null) return false;
			Node<E> current = this;
			while(current != null && node != null) {
				if(!current.data.equals(node.data)) {
					return false;
				}
				current = current.next;
				node = node.next;
			}
			return current == null && node == null;
		}
	}
	
	
	/**
	 * Returns the number of nodes linked together after 
	 * the node current is given
	 */
	public static <E> int  countNodes(Node<E> current) {
		Node<E> loop = current;
		int count = 0;
		while(loop != null) {
			count++;
			loop = loop.next;
		}
		return count;
	}
	
	
	/**
	 * Returns the head of the linked data structure.
	 * IE returns the first in the list given some 
	 * other element in the list
	 *
	 */
	
	public static <E> Node<E> getHead(Node<E> current){
		if(current == null) {
			return current;
		}
		Node<E> head = current;
		while(head.previous != null) {
			head = head.previous;
		}
		return head;
	}
	
	/**
	 * removes all instances of all elements in toBe from the
	 * data structure AFTER the node current. Return the current
	 * node except in the case of it being removed, then return
	 * the next valid node
	 * @param current
	 * @param toBe
	 */
	public static <E> Node<E> removeAll(Node<E> current, List<E> toBe){
		if(toBe.contains(current.data)) {
			if(current.previous == null) {
				current = current.next;
				current.previous = null;
			} else {
				current.previous.next = current.next;
				current.next.previous = current.previous;
				current = current.next;
			}
		}
		Node<E> ret = current;
		while(current != null) {
			if(toBe.contains(current.data) && current.next != null) {
				current.previous.next = current.next;
				current.next.previous = current.previous;
			} else if(toBe.contains(current.data) && current.next == null) {
				current.previous.next = null;
			}
			current = current.next;
		}
		return getHead(ret);
	}
	
	/**
	 * Returns a List of all elements in the data structure. 
	 * 
	 * @param current
	 * @return
	 */
	public static <E> List<E> convertToList(Node<E> current) {
		Node<E> loop = current;
		List<E> al = new ArrayList<E>();
		while(loop != null) {
			al.add(loop.data);
			loop = loop.next;
		}
		return al;
	}
	
	/**
	 * A circular linked dta structure is one where the last
	 * element points to the first element. This presents
	 * and interesting coding problem to know where to stop
	 * Find the size of the given data structure
	 */
	
	public static<E> int countCircular(Node<E> current) {
		Node<E> check = current.next;
		int count = 0;
		while(check != current) {
			count++;
			check = check.next;
		}
		return count + 1;
	}
	
	/**
	 * Given two data structures of Nodes, combine by 
	 * alternating data structures. In the case that
	 * one is longer than the other add the remaining
	 * at the end
	 * 
	 */
	public static <E> Node<E> combineNodes(Node<E> current, Node<E> current2) {
		return mergeNodes(current, current2, new Node<E>(null), true);
	}
	
	private static <E> Node<E> mergeNodes(Node<E> current, Node<E> current2, Node<E> node, boolean alternate){
		if(current == null) return current2;
		if(current2 == null) return current;
		
		if(alternate) {
			node = current;
			node.next = mergeNodes(current.next, current2, node,!alternate);
		} else {
			node = current2;
			node.next = mergeNodes(current, current2.next, node,!alternate);
		}
		return node;
	}

	
}
