package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BinaryTreeAPlusTest {


	
	public BinaryTreeAPlus.TreeNode<String> makeTree(){
		BinaryTreeAPlus.TreeNode<String> root = new BinaryTreeAPlus.TreeNode<String>("Bob");
		BinaryTreeAPlus.TreeNode<String> l1 = new BinaryTreeAPlus.TreeNode<String>("Frank");
		BinaryTreeAPlus.TreeNode<String> r1 = new BinaryTreeAPlus.TreeNode<String>("Sam");
		BinaryTreeAPlus.TreeNode<String> l2 = new BinaryTreeAPlus.TreeNode<String>("Michelle");
		BinaryTreeAPlus.TreeNode<String> r2 = new BinaryTreeAPlus.TreeNode<String>("Nikki");
		BinaryTreeAPlus.TreeNode<String> l3 = new BinaryTreeAPlus.TreeNode<String>("Ralph");
		BinaryTreeAPlus.TreeNode<String> r3 = new BinaryTreeAPlus.TreeNode<String>("Sid");
		BinaryTreeAPlus.TreeNode<String> l4 = new BinaryTreeAPlus.TreeNode<String>("Mark");
		BinaryTreeAPlus.TreeNode<String> r4 = new BinaryTreeAPlus.TreeNode<String>("David");
		BinaryTreeAPlus.TreeNode<String> l5 = new BinaryTreeAPlus.TreeNode<String>("Jason");
		BinaryTreeAPlus.TreeNode<String> r5 = new BinaryTreeAPlus.TreeNode<String>("Phillip");
		BinaryTreeAPlus.TreeNode<String> l6 = new BinaryTreeAPlus.TreeNode<String>("Mike");
		BinaryTreeAPlus.TreeNode<String> l7 = new BinaryTreeAPlus.TreeNode<String>("Neil");
		
		root.setLeft(l1);
		root.setRight(r1);;
		l1.setLeft(l2);
		l1.setRight(r2);;
		r1.setLeft(l3);
		r1.setRight(r3);
		l2.setLeft(l4);
		l2.setRight(r4);
		r2.setLeft(l5);
		r2.setRight(r5);
		l3.setLeft(l6);
		l6.setLeft(l7);
	
		return root;
		
	}
	
	@Test
	public void testBinaryTree1(){
		BinaryTreeAPlus<String> bt = new BinaryTreeAPlus<String>();
		bt.setRoot(makeTree());
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> result = bt.postOrder();
		al.add("Mark");
		al.add("David");
		al.add("Michelle");
		al.add("Jason");
		al.add("Phillip");
		al.add("Nikki");
		al.add("Frank");
		al.add("Neil");
		al.add("Mike");
		al.add("Ralph");
		al.add("Sid");
		al.add("Sam");
		al.add("Bob");
		
		assertEquals(al, result);
		
	}

	@Test
	public void testBinaryTree2(){
		BinaryTreeAPlus<String> bt = new BinaryTreeAPlus<String>();
		bt.setRoot(makeTree());
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> result = bt.inOrder();
		al.add("Mark");
		al.add("Michelle");
		al.add("David");
		al.add("Frank");
		al.add("Jason");
		al.add("Nikki");
		al.add("Phillip");
		al.add("Bob");
		al.add("Neil");
		al.add("Mike");
		al.add("Ralph");
		al.add("Sam");
		al.add("Sid");
		
		assertEquals(al, result);
		
	}

	@Test
	public void testBinaryTree3(){
		BinaryTreeAPlus<String> bt = new BinaryTreeAPlus<String>();
		bt.setRoot(makeTree());
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> result = bt.preOrder();
		al.add("Bob");
		al.add("Frank");
		al.add("Michelle");
		al.add("Mark");
		al.add("David");
		al.add("Nikki");
		al.add("Jason");
		al.add("Phillip");
		al.add("Sam");
		al.add("Ralph");
		al.add("Mike");
		al.add("Neil");
		al.add("Sid");
		
		assertEquals(al, result);
		
	}

}
