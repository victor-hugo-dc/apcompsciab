package edu.fcps.ab;

import java.util.List;

@SuppressWarnings("unchecked")
public class LinkedDataAssessment {


	public static class Node<E>{
		public Node<E> next;
		public Node<E> previous;
		public E data;
		
		public Node(E d) {
			data = d;
		}
		
		public String toString() {
			if(next == null) return ""+data;
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
	
	
	private static <T> Node<T> getHead(Node<T> node){
		while(node.previous != null) {
			node = node.previous;
		}
		return node;
	}

	/**
	 * Please count how many times each of the toBe 
	 * values appear in the Node.
	 */
	public static <T> int countValues(Node<T> node, List<T> toBe) {
		int count = 0;
		node = getHead(node);
		while(node != null) {
			if(toBe.contains(node.data)) {
				count++;
			}
			node = node.next;
		}
		return count;
	}
	 
	/**
	 * Count the largest number of spaces between two instances of the given
	 * value exclusive. In the case the value does not appear return -2
	 * In the case the value appears only once return -1
	 */
	
	public static <T> int countSpaces(Node<T> node, T value) {
		node = getHead(node);
		int firstIndex = -1, secondIndex = -1, current = 0;
		while(node != null) {
			if(firstIndex == -1 && node.data.equals(value)) {
				firstIndex = current;
			} else if(secondIndex == -1 && node.data.equals(value)) {
				secondIndex = current;
			}
			node = node.next;
			current++;
		}
		if(firstIndex == secondIndex) {return -2;}
		if(secondIndex == -1) {return -1;}
		return secondIndex - firstIndex - 1;
	}
	
	/**
	 * Remove every other element in the data structure, starting
	 * with the second. (i.e. don't remove the 1st but remove the 
	 * 2nd 4th 6th etc.
	 */
	
	public static <T> void removeEveryOther(Node<T> node) {
		node = getHead(node);
		int even = 1;
		while(node != null) {
			if(even%2 == 0 && node.next == null) {
				node.previous.next = null;
			} else if(even%2 == 0) {
				node.previous.next = node.next;
				node.next.previous = node.previous;
			}
			node = node.next;
			even++;
		}
	}
	 
	/**
	 * Inserts inserted in front of every instance of of the given
	 * value.
	 */
	public static <T> Node<T> insertInFront(Node<T> node, T value, T insert){
		node = getHead(node);
		while(node.next != null) {
		Node<T> n = new Node<T>(insert);	
			if(node.data.equals(value) && node.previous == null) {
				node.previous = n;
				n.next = node;
			} else if(node.data.equals(value)) {
				node.previous.next = n;
				n.previous = node.previous;
				n.next = node;
				node.previous = n;
			}
			node = node.next;
		}
		return getHead(node);
	}
	/**
	 * Extra credit:
	 * In place sort (using any technique) of the given node
	 * to the end of the structure (please note: I could ask 
	 * you to sort from the middle to the end) It's extra
	 * credit for a reason. Also please note: If you are only
	 * in Pre calc you need not attempt :)
	 */
	public static <T extends Comparable<T>> Node<T> sortStructure(Node<T> node){
		return null;
	}
}
