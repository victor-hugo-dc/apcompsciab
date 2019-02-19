package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class StackQueueProblemsTest {
	private String [] names = {"Bob","Ralph","Jason","Simon","Sam", "Michelle", "Judy","Alvin"};
	private int [] ints = {134,2,43,5, 60,234,43,7,8,8365,34,6,6745,34,65,787,34,56,54,34,23,0,0,10,54,89,20};
	
	public ArrayList<String> makeArrayList(){
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 0;i < names.length;i++){
			al.add(names[i]);
		}
		return al;
	}
	
	public ArrayList<Integer> makeIntArrayList(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0;i < ints.length;i++){
			al.add(ints[i]);
		}
		return al;

	}

	@Test
	public void reverseArrayListTest1(){
		StackQueueProblems<String> sqp = new StackQueueProblems<String>();
		ArrayList<String> al = makeArrayList();
		sqp.reverseArrayList(al);
		for(int i = names.length-1, j = 0;i>=0;i--, j++){
			assertEquals(names[i], al.get(j));
		}
	}
	
	@Test
	public void reverseArrayListTest2(){
		StackQueueProblems<String> sqp = new StackQueueProblems<String>();
		ArrayList<String> al = new ArrayList<String>();
		sqp.reverseArrayList(al);
		assertEquals(0,al.size());
	}
	
	@Test
	public void sortArrayListTest1(){
		StackQueueProblems<String> sqp = new StackQueueProblems<String>();
		ArrayList<String> al = makeArrayList();
		ArrayList<String> dumby = makeArrayList();
		Collections.sort(dumby);
		sqp.sortArrayList(al);
		for(int i = 0;i < al.size();i++){
			assertEquals(dumby.get(i), al.get(i));
		}

	}
	@Test
	public void sortArrayListTest2(){
		StackQueueProblems<String> sqp = new StackQueueProblems<String>();
		ArrayList<String> al = new ArrayList<String>();
		sqp.sortArrayList(al);
		assertEquals(0,al.size());
	}
	
	@Test
	public void butterFlyArrayListTest1(){
		StackQueueProblems<String> sqp = new StackQueueProblems<String>();
		ArrayList<String> al = makeArrayList();
		sqp.butterFlyArrayList(al);
		int j = 0;
		for(int i = names.length/2-1;i>=0;i--, j++){
			assertEquals(names[i], al.get(j));
		}
		for(int i = names.length-1;i >= names.length/2;i--, j++){
			assertEquals(names[i], al.get(j));
		}
	}
	
	@Test
	public void groupAndModeTest1(){
		StackQueueProblems<String> sqp = new StackQueueProblems<String>();
		ArrayList<Integer> al = this.makeIntArrayList();
		int mode = sqp.groupAndMode(al);
		assertEquals(4, mode);
		assertEquals((Integer)60, al.get(0));
		assertEquals((Integer)0, al.get(1));
		assertEquals((Integer)0, al.get(2));
		assertEquals((Integer)10, al.get(3));
		assertEquals((Integer)20, al.get(4));
		assertEquals((Integer)2, al.get(5));
		//Etc.
		
	}


}
