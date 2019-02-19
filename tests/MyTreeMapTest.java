package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class MyTreeMapTest {

	@Test
	public void mapTestPutGet1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		assertEquals(5, map.size());
		assertEquals("12345",map.get("Nikki"));
		assertEquals("09876",map.get("Huy"));
		assertEquals("00000",map.get("Mark"));
		assertEquals("12345",map.get("Caton"));
		assertEquals("11111",map.get("Sam"));
		
	}
	@Test
	public void mapTestPutGet2(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		map.put("Nikki","99999");  //replace
		assertEquals(5, map.size());
		assertEquals("99999",map.get("Nikki"));
		assertEquals("09876",map.get("Huy"));
		assertEquals("00000",map.get("Mark"));
		assertEquals("12345",map.get("Caton"));
		assertEquals("11111",map.get("Sam"));
		assertNull(map.get("Oli"));
	}
	
	@Test (expected=java.lang.NullPointerException.class)
	public void mapTestPutGet3(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put(null, "12345");
	}
	
	@Test (expected=java.lang.NullPointerException.class)
	public void mapTestPutGet4(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Sam", null);
	}
	
	@Test
	public void mapClearTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		assertTrue(map.isEmpty());
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		assertFalse(map.isEmpty());
		map.clear();
		assertTrue(map.isEmpty());
		assertEquals(0, map.size());
		map.put("Sam","99999");
		assertEquals(1,map.size());
		assertEquals("99999", map.get("Sam"));
	}
	
	@Test
	public void mapContainsTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		assertTrue(map.containsKey("Nikki"));
		assertTrue(map.containsKey("Sam"));
		assertFalse(map.containsKey("Fred"));
		assertTrue(map.containsValue("12345"));
		assertTrue(map.containsValue("09876"));
		assertFalse(map.containsValue("99999"));
	}
	
	@Test
	public void mapEntrySetTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		Set<Map.Entry<String, String>> set = map.entrySet();
		assertEquals(5, set.size());
		for(Map.Entry<String,String> en: set){
			assertTrue(map.containsKey(en.getKey()));
			assertTrue(map.containsValue(en.getValue()));
		}
	}
	
	@Test
	public void mapKeySetTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345"); 
		map.put("Sam", "11111");
		Set<String> keys = map.keySet();
		assertEquals(5, keys.size());
		assertTrue(keys.contains("Nikki"));
		assertTrue(keys.contains("Huy"));
		assertTrue(keys.contains("Mark"));
		assertTrue(keys.contains("Caton"));
		assertTrue(keys.contains("Sam"));
	}
	
	@Test
	public void mapKeySetTest2(){
		Map<String, String> map = new MyTreeMap<String, String>();
		Set<String> keys = map.keySet();
		assertEquals(0,keys.size());
	}
	
	@Test
	public void mapPutAllTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		Map<String, String> map2 = new MyTreeMap<String, String>();
		map2.put("Isablle", "12345");
		map2.put("Yurie", "09876");
		map2.put("Jake", "00000");
		map2.put("Jason", "12345");
		map2.put("Joanna", "11111");
		map.putAll(map2);
		assertEquals(10, map.size());
		assertEquals("11111", map.get("Sam"));
		assertEquals("11111",map.get("Joanna"));
		assertNull(map.get("Fred"));
		assertEquals(5,map2.size());
	}
	@Test
	public void mapPutAllTest2(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		Map<String, String> map2 = new MyTreeMap<String, String>();
		
		map.putAll(map2);
		assertEquals(5, map.size());
		assertEquals("11111", map.get("Sam"));
		assertNull(map.get("Fred"));
	}

	@Test
	public void mapPutAllTest3(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		Map<String, String> map2 = new MyTreeMap<String, String>();
		map2.putAll(map);
		assertEquals(5, map2.size());
		assertEquals("11111", map2.get("Sam"));
		assertNull(map2.get("Fred"));
		assertEquals(5, map.size());
	}
	
	@Test
	public void mapRemoveTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "12345");
		map.put("Sam", "11111");
		map.remove("Nikki");
		assertEquals(4, map.size());
		assertNull(map.get("Nikki"));
		map.remove("Sam");
		assertEquals(3,map.size());
		assertNull(map.get("Sam"));
		map.remove("Huy");
		assertEquals(2, map.size());
		assertNull(map.get("Huy"));
		map.remove("Mark");
		assertEquals(1, map.size());
		assertNull(map.get("Mark"));
		map.remove("Caton");
		assertEquals(0, map.size());
		assertNull(map.get("Caton"));
	}
	
	@Test
	public void mapRemoveTest2(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "99999");
		map.put("Sam", "11111");
		map.remove("Nikki");
		Set<String> keys = map.keySet();
		assertFalse(keys.contains("Nikki"));
		Collection<String> values = map.values();
		assertFalse(values.contains("12345"));
		map.remove("Caton");
		Set<String> keys2 = map.keySet();
		Collection<String> values2 = map.values();
		assertFalse(keys2.contains("Caton"));
		assertFalse(values2.contains("99999"));

	}
	
	@Test
	public void mapRemoveTest3(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "99999");
		map.put("Sam", "11111");
		map.remove("Huy");
		assertEquals(4, map.size());
		map.put("Jason","55667");
		assertEquals(5,map.size());
		assertEquals("55667", map.get("Jason"));
		assertEquals("99999", map.get("Caton"));
		map.remove("Caton");
		assertEquals(4, map.size());
		assertNull(map.get("Caton"));
		map.remove("Jason");
		assertEquals(3, map.size());
		assertNull(map.get("Jason"));
	}
	
	@Test
	public void mapValuesTest1(){
		Map<String, String> map = new MyTreeMap<String, String>();
		map.put("Nikki", "12345");
		map.put("Huy", "09876");
		map.put("Mark", "00000");
		map.put("Caton", "99999");
		map.put("Sam", "11111");
		Collection<String> values = map.values();
		assertEquals(5, values.size());
		assertTrue(values.contains("12345"));
		assertTrue(values.contains("09876"));
		assertTrue(values.contains("00000"));
		assertTrue(values.contains("99999"));
		assertTrue(values.contains("11111"));
		assertFalse(values.contains("Something not in the values"));
	}
	
	@Test
	public void mapDifferentTypeTest1(){
		Map<Double, Integer> map = new MyTreeMap<Double, Integer>();
		map.put(1.2, 1);
		map.put(4.3, 4);
		map.put(5.7, 6);
		map.put(9.8, 10);
		map.put(3.1, 3);
		assertEquals(5, map.size());
		assertEquals(new Integer(1), map.get(1.2));
		assertEquals(new Integer(3), map.get(3.1));
		assertEquals(new Integer(6), map.get(5.7));
		assertTrue(map.containsKey(4.3));
		assertTrue(map.containsValue(10));
		
		map.remove(9.8);
		assertNull(map.get(9.8));
		assertEquals(4, map.size());
		map.remove(1.2);
		assertEquals(3, map.size());
		assertNull(map.get(1.2));
		
		
	}

}
