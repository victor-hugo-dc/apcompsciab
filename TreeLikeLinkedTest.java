package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import edu.fcps.ab.BinaryTreeAPlus.TreeNode;

public class TreeLikeLinkedTest<E> {

	//Assume the following Node class
	public  static  class TestNode<E extends Comparable<E>>{
		//Left child < node
		TestNode<E> left;
		//right child > node
		TestNode<E> right;
		//The parent node of this node, null if no parent
		TestNode<E> parent;
		//The data stored in the node
		E data;
		
		public TestNode(E d) {
			data = d;
		}
		
		public String toString() {
			return left.toString() + "-" + data + "-" + right.toString();
		}
	}
	
	
	//You may assume all test tree structures are organized 
	// as a BinarySearchTree would be organized.

	/**
	 * returns the node that contains the element given
	 * @param node the tree structure
	 * @param element the element being searched for
	 * @return the TestNode that contains the element
	 */
	public static <E extends Comparable<E>> TestNode<E> getNode(TestNode<E> node, E element){
		return get(node, element);
	}
	
	private static <E extends Comparable<E>> TestNode<E> get(TestNode<E> node, E element){
		if(node.data.equals(element)) return node;
		if(node.data.compareTo(element) > 0) {
			if(node.left == null) return null;
			else return get(node.left, element);
		} else {
			if(node.right == null) return null;
			else return get(node.right, element);	
		}
	}
	
	
	/**
	 * Return the smallest element in the tree structure given 
	 * by the TestNode assigned. 
	 * @param node TreeNode to search for smallest item
	 * @return the smallest value in the given tree structure
	 */
	
	public static <E extends Comparable<E>> E getSmallestElement(TestNode<E> node) {
		if(node == null) 
			return null;
		TestNode<E> tn = node;
		while (tn.left != null)
			tn = tn.left;
		return tn.data;
		
	}
	
	/**
	 * Returns a List of leaf elements. Please note: a leaf is an element
	 * with NO children. 
	 * @param node TestNode to search for leaves
	 * @return List of elements that are the leaf data
	 */

	public static <E extends Comparable<E>> List<E> getAllLeaves(TestNode<E> node){
		List<E> leaves = new ArrayList<E>();
		if(node == null) 
			return null;
		getLeaves(node.left, leaves);
		getLeaves(node.right, leaves);
		return leaves;
	}

	private static <E extends Comparable<E>> void getLeaves(TestNode<E> node, List<E> list){
		if(node == null) return;
		if(node.left == null && node.right == null)
			list.add(node.data);
		if(node.left != null) 
			getLeaves(node.left, list);
		if(node.right != null) 
			getLeaves(node.right, list);
	}
	/**
	 * Returns a list which is the individual path from the root to
	 * an indicated node. In the case of the node being the root, return
	 * an empty List. If the node does not appear in the tree return
	 * an empty List.
	 * @param Node TestNode that is the tree structure
	 * @param element element you need the path to
	 * @return List that contains the path from the root to the element 
	 * 			(Not including the element)
	 * 
	 */
	
	public static <E extends Comparable<E>> List<E> getPathTo(TestNode<E> node, E data){
		TestNode<E> trav = getNode(node, data);
		if(trav == null || trav.parent == null)
			return new ArrayList<E>();
		trav = trav.parent;
		List<E> path = new ArrayList<E>();
		while(trav != null) {
			path.add((E) trav.data);
			trav = trav.parent;
		}
		Collections.reverse(path);
		return path;
	}
	
	/**
	 * Returns the number of nodes in the structure pointed to by
	 * node. 
	 * @param node the TestNode that you are counting
	 * @return the number of elements in the structure
	 * 
	 */
	
	public static <E extends Comparable<E>> int getTotalCount(TestNode<E> node) {
		if(node == null) return 0;
		List<E> trav = new ArrayList<E>();
		traverse(node, trav);
		return trav.size();
	}
	private static <E extends Comparable<E>> void traverse(TestNode<E> node, List<E> trav) {
		if(node == null) return;
		traverse(node.left, trav);
		trav.add(node.data);
		traverse(node.right, trav);
	}
	
	/**
	 * Node is part of a larger tree. Return the largest element
	 * in the whole tree, of which node is part of.
	 * 
	 * @param node the node that is part of the larger tree
	 * @return the element of the largest element in the whole tree
	 * 
	 */
	
	public static <E extends Comparable<E>> E getLargestInTree(TestNode<E> node) {
		if(node == null) return null;
		TestNode<E> tn = node;
		while (tn.parent != null)
			tn = tn.parent;
		while(tn.right != null)
			tn = tn.right;
		return tn.data;
	}
}
