package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
@SuppressWarnings({"unused", "rawtypes"})
public class MapManipulationsTest {

	
	private void equalAssertion(Map map1, Map map2){
		Set keys = map1.keySet();
		Iterator iter = keys.iterator();
		Iterator iter2 = map2.keySet().iterator();
		while(iter.hasNext()){
			Object o1 = iter.next();
			Object o2 = iter2.next();
			assertEquals(map1.get(o1), map2.get(o2));
			
			
		}
		
	}
	@Test
	public void buildMapTest1(){
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("bob0",0 );
		map.put("bob1",1 );
		map.put("bob2",2 );
		map.put("bob3",3 );
		map.put("bob4",4 );
		map.put("bob5",5 );
		map.put("bob6",6 );
		map.put("bob7",7 );
		Map<String, Integer> result = MapManipulations.buildMap("bob", 8);
		assertEquals(map.size(), result.size());
		equalAssertion(map,result);
	}
	
	@Test
	public void buildMapTest2(){
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("bob0",0 );
		Map<String, Integer> result = MapManipulations.buildMap("bob", 1);
		assertEquals(map.size(), result.size());
		equalAssertion(map,result);
	}
	
	@Test
	public void buildMapTest3(){
		Map<String, Integer> map = new HashMap<String,Integer>();
		Map<String, Integer> result = MapManipulations.buildMap("bob", 0);
		assertEquals(map.size(), result.size());
		equalAssertion(map,result);
	}
	
	@Test
	public void buildMapTest4(){
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		map.put(10,0 );
		map.put(11,1 );
		map.put(12,2 );
		map.put(13,3 );
		map.put(14,4 );
		map.put(15,5 );
		map.put(16,6 );
		map.put(17,7 );
		Map<Integer, Integer> result = MapManipulations.buildMap(10, 8);
		assertEquals(map.size(), result.size());
		equalAssertion(map,result);
	}
	@Test
	public void countValuesTest1(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("Bob","Easy");
		map.put("Frank","Easy");
		map.put("Ralph","Not Easy");
		map.put("Theo","Not Easy");
		map.put("Sam","Easy");
		map.put("Mike","Not Easy");
		map.put("Julio","Easy");
		map.put("Jose","Easy");
		map.put("John","Not Easy");
		map.put("Helen","Not Easy");
		int result = MapManipulations.countValues(map, "Easy");
		assertEquals(5, result);
	}
	
	@Test
	public void countValuesTest2(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("Bob","Easy");
		map.put("Frank","Easy");
		map.put("Ralph","Not Easy");
		map.put("Theo","Not Easy");
		map.put("Sam","Easy");
		map.put("Mike","Not Easy");
		map.put("Julio","Easy");
		map.put("Jose","Easy");
		map.put("John","Not Easy");
		map.put("Helen","Not Easy");
		int result = MapManipulations.countValues(map, "So Easy");
		assertEquals(0, result);
	}
	@Test
	public void countValuesTest3(){
		Map<String,String> map = new HashMap<String,String>();
		int result = MapManipulations.countValues(map, "Easy");
		assertEquals(0, result);
	}
	@Test
	public void sortKeysTest1(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("Bob","Band");
		map.put("Frank","Camp");
		map.put("Ralph","Is");
		map.put("Theo","Not");
		map.put("Sam","Fun");
		map.put("Mike","Band");
		map.put("Julio","Camp");
		map.put("Jose","Is");
		map.put("John","Boring");
		ArrayList<String> answer = new ArrayList<String>();
		answer.add("Band");
		answer.add("Camp");
		answer.add("Boring");
		answer.add("Is");
		answer.add("Camp");
		answer.add("Band");
		answer.add("Is");
		answer.add("Fun");
		answer.add("Not");
		ArrayList<String> result = MapManipulations.sortKeys(map);
		assertEquals(answer.size(),result.size());
		assertEquals(answer, result);
	}
	@Test
	public void sortKeysTest2(){
		Map<String,String> map = new HashMap<String,String>();
		ArrayList<String> answer = new ArrayList<String>();
		ArrayList<String> result = MapManipulations.sortKeys(map);
		assertEquals(0, result.size());
	}
	@Test
	public void sortKeysTest3(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		map.put("Bob",15);
		map.put("Frank",16);
		map.put("Ralph",17);
		map.put("Theo",18);
		map.put("Sam",19);
		map.put("Mike",20);
		map.put("Julio",21);
		map.put("Jose",22);
		map.put("John",23);
		answer.add(15);
		answer.add(16);
		answer.add(23);
		answer.add(22);
		answer.add(21);
		answer.add(20);
		answer.add(17);
		answer.add(19);
		answer.add(18);
		ArrayList<Integer> result = MapManipulations.sortKeys(map);
		assertEquals(9, result.size());
		assertEquals(answer, result);
	}
	@Test
	public void sortKeyTest4(){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		map.put(18,15);
		map.put(9,16);
		map.put(10,17);
		map.put(7,18);
		map.put(4,19);
		map.put(6,20);
		map.put(1,21);
		map.put(15,22);
		map.put(12,23);
		answer.add(21);
		answer.add(19);
		answer.add(20);
		answer.add(18);
		answer.add(16);
		answer.add(17);
		answer.add(23);
		answer.add(22);
		answer.add(15);
		ArrayList<Integer> result = MapManipulations.sortKeys(map);
		assertEquals(9, result.size());
		assertEquals(answer, result);
	}
	
	@Test
	public void subStringSetTest1(){
		Map<String, String> map = new HashMap<String,String>();
		
		ArrayList<String> result = new ArrayList<String>();
		map.put("Bob", "Fee");
		map.put("Ralph", "Tree");
		map.put("Kim", "Boo");
		map.put("Nikki", "Bee");
		map.put("Mark", "Scoop");
		map.put("Sam", "Free");
		map.put("Evan", "Root");
		map.put("Mike", "Mee");
		result.add("Bob");
		result.add("Ralph");
		result.add("Nikki");
		result.add("Sam");
		result.add("Mike");
		Collections.sort(result);
		ArrayList<String> answer = MapManipulations.subStringSet(map, "ee");
		assertEquals(5,answer.size());
		assertEquals(result, answer);	
	}
	@Test
	public void subStringSetTest2(){
		Map<String, String> map = new HashMap<String,String>();
		
		ArrayList<String> result = new ArrayList<String>();
		map.put("Bob", "Fee");
		map.put("Ralph", "Tree");
		map.put("Kim", "Boo");
		map.put("Nikki", "Bee");
		map.put("Mark", "Scoop");
		map.put("Sam", "Free");
		map.put("Evan", "Root");
		map.put("Mike", "Mee");
		result.add("Kim");
		result.add("Mark");
		result.add("Evan");
		Collections.sort(result);
		ArrayList<String> answer = MapManipulations.subStringSet(map, "oo");
		assertEquals(3,answer.size());
		assertEquals(result, answer);	
	}
	@Test
	public void subStringSetTest3(){
		Map<String, String> map = new HashMap<String,String>();
		
		ArrayList<String> result = new ArrayList<String>();
		map.put("Bob", "Fee");
		map.put("Ralph", "Tree");
		map.put("Kim", "Boo");
		map.put("Nikki", "Bee");
		map.put("Mark", "Scoop");
		map.put("Sam", "Free");
		map.put("Evan", "Root");
		map.put("Mike", "Mee");
	
		ArrayList<String> answer = MapManipulations.subStringSet(map, "some");
		assertEquals(0,answer.size());
		assertEquals(result, answer);		
	}
	@Test
	public void subStringSetTest4(){
		Map<String, String> map = new HashMap<String,String>();
		
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> answer = MapManipulations.subStringSet(map, "ee");
		assertEquals(0,answer.size());
		assertEquals(result, answer);		
	}
	@Test
	public void longestArrayListTest1(){
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		ArrayList<String> a4 = new ArrayList<String>();
		ArrayList<String> a5 = new ArrayList<String>();
		ArrayList<String> a6 = new ArrayList<String>();
		ArrayList<String> a7 = new ArrayList<String>();
		a1.add("Bob");
		a1.add("Ralph");
		a1.add("Sam");
		a1.add("Mike");
		map.put("a1", a1);
		a2.add("Nikki");
		a2.add("Joanna");
		a2.add("Melody");
		a2.add("Isabelle");
		a2.add("Yuie");
		map.put("a2", a2);
		map.put("a3", a3);
		a4.add("Jason");
		a4.add("David");
		a4.add("Justin");
		a4.add("Paul");
		a4.add("Cameron");
		a4.add("Jake");
		map.put("a4",a4);
		a5.add("Evan");
		a5.add("Caton");
		map.put("a5",a5);
		a6.add("Huy");
		a6.add("Rithika");
		map.put("a6", a6);
		a7.add("Reed");
		a7.add("Nathan");
		a7.add("Michelle");
		map.put("a7",a7);
		ArrayList<String> result = MapManipulations.longestArrayList(map);
		assertEquals(a4,result);
	}
	@Test
	public void longestArrayListTest2(){
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		ArrayList<String> a4 = new ArrayList<String>();
		ArrayList<String> a5 = new ArrayList<String>();
		ArrayList<String> a6 = new ArrayList<String>();
		ArrayList<String> a7 = new ArrayList<String>();
		map.put("a1", a1);
		map.put("a2", a2);
		map.put("a3", a3);
		map.put("a4", a4);
		map.put("a5", a5);
		map.put("a6", a6);
		map.put("a7", a7);
		ArrayList<String> result = MapManipulations.longestArrayList(map);
		assertTrue(a1==result); //check the pointer
	}
	@Test
	public void longestArrayListTest3(){
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		ArrayList<String> a4 = new ArrayList<String>();
		ArrayList<String> a5 = new ArrayList<String>();
		ArrayList<String> a6 = new ArrayList<String>();
		ArrayList<String> a7 = new ArrayList<String>();
		a1.add("Bob");
		a1.add("Ralph");
		a1.add("Sam");
		a1.add("Mike");
		map.put("a1", a1);
		a2.add("Nikki");
		a2.add("Joanna");
		a2.add("Melody");
		a2.add("Isabelle");
		a2.add("Yuie");
		map.put("a2", a2);
		map.put("a3", a3);
		a4.add("Jason");
		a4.add("Justin");
		a4.add("Paul");
		a4.add("Cameron");
		a4.add("Jake");
		map.put("a4",a4);
		a5.add("Evan");
		a5.add("Caton");
		map.put("a5",a5);
		a6.add("Huy");
		a6.add("Rithika");
		map.put("a6", a6);
		a7.add("Reed");
		a7.add("Nathan");
		a7.add("Michelle");
		map.put("a7",a7);
		ArrayList<String> result = MapManipulations.longestArrayList(map);
		assertEquals(a2,result);
	}
}
	