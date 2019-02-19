package edu.fcps.ab;

import java.util.ArrayList;
//import java.util.Stack;
@SuppressWarnings({"unchecked", "rawtypes"})
public class BinaryTreeAPlus<E extends Comparable<E>> {

	private TreeNode<E> root;

	public TreeNode<E> getRoot() {
		return root;
	}
	 
	public static class TreeNode<F extends Comparable<F>> {
		private F data;
		private TreeNode<F> left;
		private TreeNode<F> right;
		int size;

		public TreeNode(F data) {
			this.data = data;
		}

		public TreeNode(F d, TreeNode<F> l, TreeNode<F> r) {
			data = d;
			left = l;
			right = r;
		}

		public void setData(F d) {
			data = d;
		}

		public F getData() {
			return data;
		}

		public void setLeft(TreeNode<F> l) {
			left = l;
		}

		public TreeNode<F> getLeft() {
			return left;
		}

		public void setRight(TreeNode<F> t) {
			right = t;
		}

		public TreeNode<F> getRight() {
			return right;
		}
		
		public boolean equals(Object o) {
			TreeNode<F> t = (TreeNode<F>)o;
			boolean d;
			d = data.equals(t.data);
			if(t.left != null)
				d = d&& left.equals(t.left);
			if(t.right != null)
				d = d && right.equals(t.right);
			return d;
			
		}
	}

	public void setRoot(TreeNode<E> t) {
		root = t;
	}

	public ArrayList<E> preOrder() { //root left right
		ArrayList<E> al = new ArrayList<E>();
		preOrderRecursive(al, root);
		return al;
	}
	
	private void preOrderRecursive(ArrayList<E> al, TreeNode tree){
		if(tree != null) {
			al.add((E)tree.data);
			preOrderRecursive(al, tree.left);
			preOrderRecursive(al, tree.right);
		}
	}

	public ArrayList<E> postOrder() { //left right root
		ArrayList<E> al = new ArrayList<E>();
		postOrderRecursive(al, root);
		return al;
	}
	
	private void postOrderRecursive(ArrayList<E> al, TreeNode tree){
		if(tree != null) {
			postOrderRecursive(al, tree.left);
			postOrderRecursive(al, tree.right);
			al.add((E)tree.data);
		}
	}

	public ArrayList<E> inOrder() { //left root right
		ArrayList<E> al = new ArrayList<E>();
		inOrderRecursive(al, root);
		return al;
	}
	
	private void inOrderRecursive(ArrayList<E> al, TreeNode tree){
		if(tree != null) {
			inOrderRecursive(al, tree.left);
			al.add((E)tree.data);			
			inOrderRecursive(al, tree.right);
		}
	}
}
