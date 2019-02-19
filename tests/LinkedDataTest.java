package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LinkedDataTest {

	public List<String> makeList(int count){
		List <String> list = new ArrayList<String>();
		list.add("Fred 0");
		for(int i=1;i<count;i++) {
			list.add("Fred "+i);
		}
		return list;
	}
	public LinkedData.Node<String> makeStructure(int count){
		LinkedData.Node<String> node1 = new LinkedData.Node<String>("Fred 0");
		LinkedData.Node<String> node = node1;
		for(int i = 1;i< count;i++) {
			LinkedData.Node<String> n = new LinkedData.Node<String>("Fred "+i);
			n.previous=node;
			node.next = n;
			node = n;
		}
		return node1;
	}
	
	public LinkedData.Node<String> makeCircularStructure(int count){
		LinkedData.Node<String> node1 = new LinkedData.Node<String>("Fred 0");
		LinkedData.Node<String> node = node1;
		for(int i = 1;i< count;i++) {
			LinkedData.Node<String> n = new LinkedData.Node<String>("Fred "+i);
			n.previous=node;
			node.next = n;
			node = n;
			n.next = node1;
			node1.previous = n;
		}
		
		return node1;
	}
	
	public LinkedData.Node<String> makeStructureWithout(int count, List<Integer> list){
		LinkedData.Node<String> node1 = null;
		LinkedData.Node<String> node = null;
		for(int i = 0;i< count;i++) {
			if(list.contains(i)) continue;
			LinkedData.Node<String> n = new LinkedData.Node<String>("Fred "+i);
			if(node == null) {
				node = n;
				node1 = n;
				continue;
			}
			n.previous=node;
			node.next = n;
			node = n;
		}
		return node1;
	}
	@Test
	public void countNodesTest1() {
		LinkedData.Node<String> node = makeStructure(10);
		int c = LinkedData.countNodes(node);
		assertEquals(10,c);
	}

	@Test
	public void countNodesTest2() {
		LinkedData.Node<String> node = makeStructure(0);
		int c = LinkedData.countNodes(node);
		assertEquals(1,c);
	}
	
	@Test
	public void countNodesTest3() {
		LinkedData.Node<String> node = null;
		int c = LinkedData.countNodes(node);
		assertEquals(0,c);
	}
	
	@Test
	public void getHeadTest1() {
		LinkedData.Node<String> node = makeStructure(10);
		LinkedData.Node<String> ret = LinkedData.getHead(node);
		assertEquals(node,ret);
	}
	
	@Test
	public void getHeadTest2() {
		LinkedData.Node<String> node = makeStructure(10);
		LinkedData.Node<String> node1 = node;
		for (int i = 0; i<5;i++) {
			node1 = node1.next;
		}
		LinkedData.Node<String> ret = LinkedData.getHead(node1);
		assertEquals(ret, node);
	}
	@Test
	public void getHeadTest3() {
		LinkedData.Node<String> node = makeStructure(10);
		LinkedData.Node<String> node1 = node;
		while(node1.next != null) {
			node1 = node1.next;
		}
		LinkedData.Node<String> ret = LinkedData.getHead(node1);
		assertEquals(ret, node);
	}
	
	@Test
	public void getHeadTest4() {
		LinkedData.Node<String> node = null;
		LinkedData.Node<String> ret = LinkedData.getHead(node);
		assertNull(ret);
	}
	
	@Test
	public void removeAllTest1() {
		LinkedData.Node<String> node = makeStructure(10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(8);
		LinkedData.Node<String> node1 = makeStructureWithout(10, list);
		List<String> toBe = new ArrayList<String>();
		toBe.add("Fred 1");
		toBe.add("Fred 8");
		
		node = LinkedData.removeAll(node, toBe);
		assertEquals(node1, node);
		
	}
	@Test
	public void removeAllTest2() {
		LinkedData.Node<String> node = makeStructure(10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(9);
		LinkedData.Node<String> node1 = makeStructureWithout(10, list);
		List<String> toBe = new ArrayList<String>();
		toBe.add("Fred 0");
		toBe.add("Fred 9");
		
		node = LinkedData.removeAll(node, toBe);
		assertEquals(node1, node);
		
	}
	
	@Test 
	public void removeAllTest3() {
		LinkedData.Node<String> node = makeStructure(10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		LinkedData.Node<String> node1 = makeStructureWithout(10, list);
		List<String> toBe = new ArrayList<String>();
		toBe.add("Fred 0");
		toBe.add("Fred 8");
		node = LinkedData.removeAll(node.next.next.next, toBe);
		assertEquals(node1, node);		
	}
	
	@Test
	public void convertToListTest1() {
		LinkedData.Node<String> node = makeStructure(10);
		List<String> list = makeList(10);
		List<String> ret = LinkedData.convertToList(node);
		assertEquals(list,ret);
	}
	
	@Test
	public void convertToListTest2() {
		LinkedData.Node<String> node = makeStructure(1);
		List<String> list = makeList(1);
		List<String> ret = LinkedData.convertToList(node);
		assertEquals(list,ret);
		
	}
	
	@Test
	public void convertToListTest3() {
		LinkedData.Node<String> node = null;
		List<String> list = LinkedData.convertToList(node);
		assertEquals(0,list.size());
	}
	
	@Test
	public void countCircularTest1() {
		LinkedData.Node<String> node = makeCircularStructure(10);
		int count = LinkedData.countCircular(node);
		assertEquals(10, count);
		
	}
	
	@Test
	public void countCircularTest2() {
		LinkedData.Node<String> node = makeCircularStructure(20);
		for(int i = 0; i<9;i++) {
			node = node.next;
		}
		int count = LinkedData.countCircular(node);
		assertEquals(20,count);
	}
	
	@Test
	public void combineNodesTest1() {
		LinkedData.Node<String> node = makeStructure(10);
		LinkedData.Node<String> node2 = makeStructure(10);
		LinkedData.Node<String> ret = new LinkedData.Node<String>("Fred 0");
		ret.next = new LinkedData.Node<String>("Fred 0");
		LinkedData.Node<String> r = ret.next;
			for(int i = 1; i<10;i++) {
			r.next = new LinkedData.Node<String>("Fred "+i);
			r = r.next;
			r.next = new LinkedData.Node<String>("Fred "+i);
			r = r.next;
		}
		LinkedData.Node<String> answer = LinkedData.combineNodes(node, node2);
		assertEquals(ret, answer);
	}
	@Test
	public void combineNodesTest2() {
		LinkedData.Node<String> node = makeStructure(20);
		LinkedData.Node<String> node2 = makeStructure(10);
		LinkedData.Node<String> ret = new LinkedData.Node<String>("Fred 0");
		ret.next = new LinkedData.Node<String>("Fred 0");
		LinkedData.Node<String> r = ret.next;
		for(int i = 1; i<10;i++) {
			r.next = new LinkedData.Node<String>("Fred "+i);
			r = r.next;
			r.next = new LinkedData.Node<String>("Fred "+i);
			r =r.next;
		}
		for(int i = 10;i<20;i++) {
			r.next = new LinkedData.Node<String>("Fred "+i);			
			r = r.next; 
		}
		LinkedData.Node<String> answer = LinkedData.combineNodes(node, node2);
		assertEquals(ret, answer);
	}
	@Test
	public void combineNodesTest3() {
		LinkedData.Node<String> node = makeStructure(20);
		LinkedData.Node<String> node2 = makeStructure(10);
		LinkedData.Node<String> ret = new LinkedData.Node<String>("Fred 0");
		ret.next = new LinkedData.Node<String>("Fred 0");
		LinkedData.Node<String> r = ret.next;
			for(int i = 1; i<10;i++) {
			r.next = new LinkedData.Node<String>("Fred "+i);
			r = r.next;
			r.next = new LinkedData.Node<String>("Fred "+i);
			r =r.next;
		}
		for(int i = 10;i<20;i++) {
			r.next = new LinkedData.Node<String>("Fred "+i);			
			r = r.next; 
		}
		LinkedData.Node<String> answer = LinkedData.combineNodes(node2, node);
		assertEquals(ret, answer);
	}
	@Test
	public void combineNodesTest4() {
		LinkedData.Node<String> node = makeStructure(20);
		LinkedData.Node<String> node2 = null;;
		LinkedData.Node<String> ret = new LinkedData.Node<String>("Fred 0");
		LinkedData.Node<String> r = ret;
		for(int i = 1; i<20;i++) {
			r.next = new LinkedData.Node<String>("Fred "+i);
			r = r.next;
		}
		LinkedData.Node<String> answer = LinkedData.combineNodes(node, node2);
		assertEquals(ret, answer);
	}
}
