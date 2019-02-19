package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import edu.fcps.ab.LinkedDataAssessment.Node;
@SuppressWarnings({"unchecked", "rawtypes"})
public class LinkedDataAssessmentTest {


	public Node<Integer> buildStructure(int count){
		return buildStructure(0,count, null);
	}
	
	public Node<Integer> buildStructure(int start, int end, List<Integer> skipped){
		return buildStructure(null, start, end, skipped);
	}
	
	public Node<Integer> buildStructure(Node<Integer> node, int start, int end, List<Integer> skipped){
		if(node == null) {
			node = new Node<>(start);
			start++;
		}
		Node<Integer> current = node;
		while(current.next != null) {
			current = current.next;
		}
		for(int i = start;i<= end;i++) {
			if(skipped != null && skipped.contains(new Integer(i))) {
				
				continue;
			}
			
			Node<Integer> n = new Node<>(i);
			current.next = n;
			n.previous=current;
			current = n;
		}
		return node;

	}
	
	public Node<Integer> scrambleStructure(Node<Integer> node, int length, int times){
		
		Random gen = new Random();
		for(int i = 0;i< times;i++) {
			int place = gen.nextInt(length+1);
			Node<Integer> n = node;
			while(place > 0 && n != null ) {
				n = n.next;
				place--;
			}
			if(n == node) continue;
			if(n.next != null)
				n.next.previous=n.previous;
			if(n.previous != null)
				n.previous.next=n.next;
			n.previous = null;
			n.next = node;
			node.previous = n;
			node = n;
		
			
		}
		return node;
	}
	
	public Node<Integer> duplicateStructure(Node<Integer> node){
		if(node == null) return null;
		Node<Integer> current = new Node<Integer>(node.data);
		Node<Integer> front = current;
		node = node.next;
		while(node != null) {
			current.next = new Node<Integer>(node.data);
			current.next.previous=current;
			current = current.next;
			node = node.next;
		}
		return front;
	}
	
	@Test
	public void countValuesTest1() {
		Node<Integer> node = buildStructure(10);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(4);
		int count = LinkedDataAssessment.countValues(node, al);
		assertEquals(2, count);
		node = scrambleStructure(node,10,100);
		count = LinkedDataAssessment.countValues(node, al);
		assertEquals(2, count);
	}
	
	@Test
	public void countValuesTest2() {
		Node<Integer> node = buildStructure(10);
		node = buildStructure(node, 0, 10, null);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(4);
		int count = LinkedDataAssessment.countValues(node, al);
		assertEquals(4, count);
		node = scrambleStructure(node,20,100);
		count = LinkedDataAssessment.countValues(node, al);
		assertEquals(4, count);
		
	}
	
	@Test
	public void countValuesTest3() {
		Node<Integer> node = buildStructure(1);
		node = buildStructure(node, 0, 1, null);
		node = buildStructure(node, 0, 1, null);
		node = buildStructure(node, 0, 1, null);
		node = buildStructure(node, 0, 1, null);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(4);
		int count = LinkedDataAssessment.countValues(node, al);
		assertEquals(0, count);
		node = scrambleStructure(node,5,100);
		count = LinkedDataAssessment.countValues(node, al);
		assertEquals(0, count);
		
	}
	
	@Test
	public void countValuesTest4() {
		Node<Integer> node = buildStructure(1);
		node = buildStructure(node, 0, 1, null);
		node = buildStructure(node, 0, 1, null);
		node = buildStructure(node, 0, 1, null);
		node = buildStructure(node, 0, 1, null);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		int count = LinkedDataAssessment.countValues(node, al);
		assertEquals(5, count);
		node = scrambleStructure(node,5,100);
		count = LinkedDataAssessment.countValues(node, al);
		assertEquals(5, count);
	}
	@Test
	public void countValuesTest5() {
		Node<Integer> node = buildStructure(20);
		node = buildStructure(node, 0, 20, null);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(-1);
		al.add(2);
		al.add(35);
		int count = LinkedDataAssessment.countValues(node, al);
		assertEquals(2, count);
		node = scrambleStructure(node,40,100);
		count = LinkedDataAssessment.countValues(node, al);
		assertEquals(2, count);
	}
	
	@Test
	public void countSpaces1() {
		Node<Integer> node = buildStructure(10);
		int count = LinkedDataAssessment.countSpaces(node, 2);
		assertEquals(-1,count);
		count = LinkedDataAssessment.countSpaces(node, 11);
		assertEquals(-2,count);
		
	}
	
	@Test
	public void countSpaces2() {
		Node<Integer> node = buildStructure(5);
		node = buildStructure(node, 0,3,null);
		node = buildStructure(node, 0,5,null);
		node = buildStructure(node, 0,2, null);
		int count = LinkedDataAssessment.countSpaces(node, 2);
		assertEquals(5,count);		
	}
	
	@Test
	public void countSpaces3() {
		Node<Integer> node = buildStructure(10);
		node = buildStructure(node,0,10,null);
		int count = LinkedDataAssessment.countSpaces(node, 1);
		assertEquals(10, count);
	}
	
	@Test
	public void countSpaces4() {
		Node<Integer> node = buildStructure(1);
		node = buildStructure(node,1,10,null);
		int count = LinkedDataAssessment.countSpaces(node,  1);
		assertEquals(0,count);
	}
	@Test
	public void countSpaces5() {
		Node<Integer> node = buildStructure(10);
		node = buildStructure(node,1,1,null);
		node = buildStructure(node,1,10,null);
		int count = LinkedDataAssessment.countSpaces(node, 1);
		assertEquals(9,count);		
	}
	
	@Test
	public void removeEveryOther1() {
		Node<Integer> node = buildStructure(10);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(5);
		al.add(7);
		al.add(9);
		Node<Integer> answer = buildStructure(0,10,al);
		LinkedDataAssessment.removeEveryOther(node);
		assertEquals(answer,node);
	}
	@Test
	public void removeEveryOther2() {
		Node<Integer> node = buildStructure(11);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(5);
		al.add(7);
		al.add(9);
		al.add(11);
		Node<Integer> answer = buildStructure(0,11,al);
		LinkedDataAssessment.removeEveryOther(node);
		assertEquals(answer,node);
	}
	
	@Test
	public void removeEveryOther3() {
		Node<Integer> node = buildStructure(0);
		Node<Integer> answer = buildStructure(0);
		LinkedDataAssessment.removeEveryOther(node);
		assertEquals(answer, node);
	}
	
	@Test
	public void insertInFrontTest1() {
		Node<Integer> node = buildStructure(10);
		
		Node<Integer> answer = new Node(0);
		Node<Integer> current = answer;
		int i = 1;
		while(i<=10) {
			if(i == 4) {
				current.next = new Node<Integer>(10);
				current = current.next;
			}
			current.next = new Node<Integer>(i);
			current = current.next;
			i++;
		}
		Node<Integer> result = LinkedDataAssessment.insertInFront(node, 4, 10);
		assertEquals(answer, result);
	}

	@Test
	public void insertInFrontTest2() {
		Node<Integer> node = buildStructure(10);
		Node<Integer> n1 = new Node<>(0);
		n1.next=node;
		node.previous=n1;
		node = n1;
		n1 = new Node<>(0);
		n1.next=node;
		node.previous=n1;
		node = n1;
		
		Node<Integer> answer = new Node(10);
		Node<Integer> answer2 = answer;
		answer.next = new Node<Integer>(0);
		answer.next.previous=answer;
		answer = answer.next;
		answer.next = new Node<Integer>(10);
		answer.next.previous=answer;
		answer = answer.next;
		answer.next = new Node<Integer>(0);
		answer.next.previous=answer;
		answer = answer.next;
		answer.next = new Node<Integer>(10);
		answer.next.previous=answer;
		answer = answer.next;
		answer.next = new Node<Integer>(0);
		answer.next.previous=answer;
		answer = answer.next;
		answer = buildStructure(answer,1,10,null);
		Node<Integer> result = LinkedDataAssessment.insertInFront(node, 0, 10);
		assertEquals(answer2, result);
	}
	
	@Test
	public void structureSort1Test() {
		Node<Integer> node = buildStructure(10);
		Node<Integer> answer = duplicateStructure(node);
		node = this.scrambleStructure(node, 10, 100);
		Node<Integer> result = LinkedDataAssessment.sortStructure(node);
		assertEquals(answer,result);
	}
	
	@Test
	public void structureSort2Test() {
		Node<Integer> node = buildStructure(100);
		Node<Integer> answer = duplicateStructure(node);
		node = this.scrambleStructure(node, 100, 1000);
		Node<Integer> result = LinkedDataAssessment.sortStructure(node);
		assertEquals(answer,result);
		
	}
	@Test
	public void structureSort3Test() {
		Node<Integer> node = buildStructure(0);
		Node<Integer> answer = duplicateStructure(node);
		node = this.scrambleStructure(node, 1, 5);
		Node<Integer> result = LinkedDataAssessment.sortStructure(node);
		assertEquals(answer,result);		
	}
}