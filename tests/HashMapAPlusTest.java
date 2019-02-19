package edu.fcps.ab;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
@SuppressWarnings({"rawtypes"})
public class HashMapAPlusTest {

	public class MyDumbyData {
		private String name;
		private Color color;
		
		public MyDumbyData(String n, Color c) {
			name = n;
			color = c;
		}
		
		public String getName() {
			return name;
		}
		
		public Color getColor() {
			return color;
		}
		
		public boolean equals(MyDumbyData dd) {
			return name.equals(dd.getName()) && color.equals(dd.getColor());
		}
		public boolean equals(Object o) {
			MyDumbyData dd = (MyDumbyData)o;
			return name.equals(dd.getName()) && color.equals(dd.getColor());
		}
		
		public int hashCode() {
			return name.hashCode() + color.hashCode();
		}
		
		public String toString() {
			return name+": "+color.toString();
		}
	}
	
	public HashMapAPlus<MyDumbyData, String> buildReHashHashMap(int l){
		HashMapAPlus<MyDumbyData, String> bob = new HashMapAPlus<>(l);
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		bob.put(d,  "Love ya");
		d = new MyDumbyData("Ralph", Color.blue);
		bob.put(d,  "Snake");
		d = new MyDumbyData("Blake", Color.black);
		bob.put(d,  "Something");
		d = new MyDumbyData("Roman", Color.white);
		bob.put(d,  "Something else");
		d = new MyDumbyData("Sam", Color.magenta);
		bob.put(d,  "Nothing much");
		d = new MyDumbyData("Victor", Color.cyan);
		bob.put(d,  "Something more");
		d = new MyDumbyData("Nick", Color.yellow);
		bob.put(d,  "Don't know");
		d = new MyDumbyData("Frank", Color.orange);
		bob.put(d,  "Not sure");
		d = new MyDumbyData("Aaron", Color.green);
		bob.put(d,  "Not at all");
		d = new MyDumbyData("Brit", Color.red);
		bob.put(d,  "Not sure what");
		return bob;
	}
	public HashMapAPlus<MyDumbyData, String> buildLLHashMap(int l){
		HashMapAPlus<MyDumbyData, String> bob = new HashMapAPlus<>(true, l);
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		bob.put(d,  "Love ya");
		d = new MyDumbyData("Ralph", Color.blue);
		bob.put(d,  "Snake");
		d = new MyDumbyData("Blake", Color.black);
		bob.put(d,  "Something");
		d = new MyDumbyData("Roman", Color.white);
		bob.put(d,  "Something else");
		d = new MyDumbyData("Sam", Color.magenta);
		bob.put(d,  "Nothing much");
		d = new MyDumbyData("Victor", Color.cyan);
		bob.put(d,  "Something more");
		d = new MyDumbyData("Nick", Color.yellow);
		bob.put(d,  "Don't know");
		d = new MyDumbyData("Frank", Color.orange);
		bob.put(d,  "Not sure");
		d = new MyDumbyData("Aaron", Color.green);
		bob.put(d,  "Not at all");
		d = new MyDumbyData("Brit", Color.red);
		bob.put(d,  "Not sure what");
		return bob;
	}
	
	@Test
	public void testBuild1() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(10);
		assertEquals(10, bob.size());
		assertTrue(bob.physicalSize()>=20);
	}
	
	@Test
	public void testBuild2() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(4);
		assertEquals(10, bob.size());
		assertEquals(4, bob.physicalSize());
	}
	
	@Test
	public void testAddGet1() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(10);
		assertEquals(10, bob.size());
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		assertEquals("Love ya", bob.get(d));
		d = new MyDumbyData("Ralph", Color.blue);
		assertEquals("Snake", bob.get(d));
		d = new MyDumbyData("Blake", Color.black);
		assertEquals("Something", bob.get(d));
		d = new MyDumbyData("Roman", Color.white);
		assertEquals("Something else", bob.get(d));
		d = new MyDumbyData("Sam", Color.magenta);
		assertEquals("Nothing much", bob.get(d));
		d = new MyDumbyData("Victor", Color.cyan);
		assertEquals("Something more", bob.get(d));
		assertNull(bob.getLinkedListArray());
		assertNotNull(bob.getMapEntryArray());
	}
	
	@Test
	public void testAddGet2() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(5);
		assertEquals(10, bob.size());
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		assertEquals("Love ya", bob.get(d));
		d = new MyDumbyData("Ralph", Color.blue);
		assertEquals("Snake", bob.get(d));
		d = new MyDumbyData("Blake", Color.black);
		assertEquals("Something", bob.get(d));
		d = new MyDumbyData("Roman", Color.white);
		assertEquals("Something else", bob.get(d));
		d = new MyDumbyData("Sam", Color.magenta);
		assertEquals("Nothing much", bob.get(d));
		d = new MyDumbyData("Victor", Color.cyan);
		assertEquals("Something more", bob.get(d));
		assertNotNull(bob.getLinkedListArray());
		assertNull(bob.getMapEntryArray());
	}

	@Test
	public void testAddGet3() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(10);
		MyDumbyData d = new MyDumbyData("Victor", Color.cyan);
		bob.put(d, "Replace me");
		assertEquals("Replace me",bob.get(d));
		HashMapAPlus<MyDumbyData, String>.MyMapEntry[] mmE = bob.getMapEntryArray();
		int hash = Math.abs(d.hashCode());
		assertEquals("Replace me", mmE[hash%mmE.length].getValue());
	}
	
	@Test
	public void testAddGet4() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(4);
		MyDumbyData d = new MyDumbyData("Victor", Color.cyan);
		bob.put(d, "Replace me");
		assertEquals("Replace me",bob.get(d));
		int hash = Math.abs(d.hashCode());
		LinkedList<HashMapAPlus<MyDumbyData, String>.MyMapEntry>[] arrayOfLists = bob.getLinkedListArray();
		LinkedList<HashMapAPlus<MyDumbyData, String>.MyMapEntry> list = arrayOfLists[hash%arrayOfLists.length];
		boolean present = false;
		for(HashMapAPlus<MyDumbyData, String>.MyMapEntry var: list) {
			if(var.getKey().equals(d)) present = true;
		}
		assertTrue(present);
	}
	
	@Test(expected=java.lang.NullPointerException.class)
	public void testAddGet5() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(10);
		bob.put(null, "is Null");
		assertEquals("is Null",bob.get(null));
	}
	
	@Test(expected=java.lang.NullPointerException.class)
	public void testAddGet6() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(10);
		bob.put(null, "is Null");
		assertEquals("is Null",bob.get(null));
	}

	@Test
	public void testRemove1() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(10);
		assertEquals(10, bob.size());
		MyDumbyData d = new MyDumbyData("Bobby", Color.red); 
		assertEquals("Love ya", bob.remove(d));
		assertEquals(9, bob.size());
		d = new MyDumbyData("Ralph", Color.blue);
		assertEquals("Snake", bob.remove(d));
		assertEquals(8, bob.size());
		d = new MyDumbyData("Blake", Color.black);
		assertEquals("Something", bob.remove(d));
		assertEquals(7, bob.size());
		d = new MyDumbyData("Roman", Color.white);
		assertEquals("Something else", bob.remove(d));
		assertEquals(6, bob.size());
		d = new MyDumbyData("Sam", Color.magenta);
		assertEquals("Nothing much", bob.remove(d));
		assertEquals(5, bob.size());
		d = new MyDumbyData("Victor", Color.cyan);
		assertEquals("Something more", bob.remove(d));
		assertEquals(4, bob.size());
	}

	@Test
	public void testRemove2() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(5);
		assertEquals(10, bob.size());
		MyDumbyData d = new MyDumbyData("Bobby", Color.red); 
		assertEquals("Love ya", bob.remove(d));
		assertEquals(9, bob.size());
		d = new MyDumbyData("Ralph", Color.blue);
		assertEquals("Snake", bob.remove(d));
		assertEquals(8, bob.size());
		d = new MyDumbyData("Blake", Color.black);
		assertEquals("Something", bob.remove(d));
		assertEquals(7, bob.size());
		d = new MyDumbyData("Roman", Color.white);
		assertEquals("Something else", bob.remove(d));
		assertEquals(6, bob.size());
		d = new MyDumbyData("Sam", Color.magenta);
		assertEquals("Nothing much", bob.remove(d));
		assertEquals(5, bob.size());
		d = new MyDumbyData("Victor", Color.cyan);
		assertEquals("Something more", bob.remove(d));
		assertEquals(4, bob.size());	
	}
	
	@Test
	public void testRemove3() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(5);
		MyDumbyData d = new MyDumbyData("Charlie", Color.darkGray);
		String res = bob.remove(d);
		assertNull(res);
		assertEquals(10, bob.size());
	}
	@Test
	public void testRemove4() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(5);
		MyDumbyData d = new MyDumbyData("Charlie", Color.darkGray);
		String res = bob.remove(d);
		assertNull(res);
		assertEquals(10, bob.size());
	}
	@Test
	public void testClear1() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(5);
		int p = bob.physicalSize();
		bob.clear();
		assertEquals(0, bob.size());
		assertEquals(p, bob.physicalSize());
	}
	
	@Test
	public void testClear2() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(5);
		int p = bob.physicalSize();
		bob.clear();
		assertEquals(0, bob.size());
		assertEquals(p, bob.physicalSize());
	}
	
	@Test 
	public void testContains1() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildReHashHashMap(5);
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		assertTrue(bob.containsKey(d));
		
		d = new MyDumbyData("Ralph", Color.blue);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Blake", Color.black);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Roman", Color.white);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Sam", Color.magenta);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Victor", Color.cyan);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Nick", Color.yellow);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Frank", Color.orange);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Aaron", Color.green);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Brit", Color.red);
		assertTrue(bob.containsKey(d));
		assertFalse(bob.containsKey(new MyDumbyData("Chase", Color.lightGray)));
	}
	@Test 
	public void testContains2() {
		HashMapAPlus<MyDumbyData, String> bob = this.buildLLHashMap(5);
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		assertTrue(bob.containsKey(d));
		
		d = new MyDumbyData("Ralph", Color.blue);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Blake", Color.black);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Roman", Color.white);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Sam", Color.magenta);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Victor", Color.cyan);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Nick", Color.yellow);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Frank", Color.orange);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Aaron", Color.green);
		assertTrue(bob.containsKey(d));
		d = new MyDumbyData("Brit", Color.red);
		assertTrue(bob.containsKey(d));
		assertFalse(bob.containsKey(new MyDumbyData("Chase", Color.lightGray)));
	}
	
	@Test
	public void entrySetTest1() {
		HashMapAPlus<MyDumbyData, String> map = this.buildReHashHashMap(10);

		Set<Map.Entry<MyDumbyData, String>> set = map.entrySet();
		assertEquals(10, set.size());
		for(Map.Entry<MyDumbyData,String> en: set){
			assertTrue(map.containsKey(en.getKey()));
			assertTrue(map.containsValue(en.getValue()));
		}
	}
	
	@Test
	public void entrySetTest2() {
		HashMapAPlus<MyDumbyData, String> map = this.buildLLHashMap(10);

		Set<Map.Entry<MyDumbyData, String>> set = map.entrySet();
		assertEquals(10, set.size());
		for(Map.Entry<MyDumbyData,String> en: set){
			assertTrue(map.containsKey(en.getKey()));
			assertTrue(map.containsValue(en.getValue()));
		}
	}
	@Test
	public void keySetTest1() {
		HashMapAPlus<MyDumbyData, String> map = this.buildReHashHashMap(10);
		Set<MyDumbyData> set = map.keySet();
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Ralph", Color.blue);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Blake", Color.black);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Roman", Color.white);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Sam", Color.magenta);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Victor", Color.cyan);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Nick", Color.yellow);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Frank", Color.orange);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Aaron", Color.green);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Brit", Color.red);
		assertTrue(set.contains(d));
		assertFalse(set.contains(new MyDumbyData("Chase", Color.LIGHT_GRAY)));
	}
	@Test
	public void keySetTest2() {
		HashMapAPlus<MyDumbyData, String> map = this.buildLLHashMap(10);
		Set<MyDumbyData> set = map.keySet();
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Ralph", Color.blue);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Blake", Color.black);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Roman", Color.white);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Sam", Color.magenta);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Victor", Color.cyan);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Nick", Color.yellow);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Frank", Color.orange);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Aaron", Color.green);
		assertTrue(set.contains(d));
		d = new MyDumbyData("Brit", Color.red);
		assertTrue(set.contains(d));
		assertFalse(set.contains(new MyDumbyData("Chase", Color.LIGHT_GRAY)));
	}

	@Test
	public void valuesSetTest1() {
		HashMapAPlus<MyDumbyData, String> map = this.buildReHashHashMap(10);
		Collection<String> values = map.values();
		assertTrue(values.contains("Love ya"));
		assertTrue(values.contains(  "Snake"));
		assertTrue(values.contains( "Something"));
		assertTrue(values.contains( "Something else"));
		assertTrue(values.contains( "Nothing much"));
		assertTrue(values.contains("Something more"));
		assertTrue(values.contains("Don't know"));
		assertTrue(values.contains("Not sure"));
		assertTrue(values.contains("Not at all"));
		assertTrue(values.contains("Not sure what"));
		assertFalse(values.contains("Nothing in here"));
	}
	
	@Test
	public void valuesSetTest2() {
		HashMapAPlus<MyDumbyData, String> map = this.buildLLHashMap(10);
		Collection<String> values = map.values();
		assertTrue(values.contains("Love ya"));
		assertTrue(values.contains(  "Snake"));
		assertTrue(values.contains( "Something"));
		assertTrue(values.contains( "Something else"));
		assertTrue(values.contains( "Nothing much"));
		assertTrue(values.contains("Something more"));
		assertTrue(values.contains("Don't know"));
		assertTrue(values.contains("Not sure"));
		assertTrue(values.contains("Not at all"));
		assertTrue(values.contains("Not sure what"));
		assertFalse(values.contains("Nothing in here"));
	}
	
	@Test
	public void storageTest1() {
		HashMapAPlus<MyDumbyData, String> map = this.buildReHashHashMap(5);
		HashMapAPlus.MyMapEntry[] entries = map.getMapEntryArray();
		
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		int hashCode = d.hashCode();
		int mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Ralph", Color.blue);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Blake", Color.black);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Roman", Color.white);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Sam", Color.magenta);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Victor", Color.cyan);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = Math.abs(mod);
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Nick", Color.yellow);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Frank", Color.orange);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Aaron", Color.green);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());
		d = new MyDumbyData("Brit", Color.red);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertEquals(d, entries[mod].getKey());	

	}
	
	private boolean containsKey(LinkedList<HashMapAPlus<MyDumbyData, String>.MyMapEntry> ll, MyDumbyData d) {
		for(HashMapAPlus<MyDumbyData, String>.MyMapEntry e:ll) {
			if(e.getKey().equals(d)) {
				return true;
			}
		}
		return false;
		//return ll.contains(new HashMapAPlus<MyDumbyData, String>.MyMapEntry(d,null));
	}
	@Test
	public void storageTest2() {
		HashMapAPlus<MyDumbyData, String> map = this.buildLLHashMap(5);
		LinkedList<HashMapAPlus<MyDumbyData, String>.MyMapEntry>[] entries = map.getLinkedListArray();
		
		MyDumbyData d = new MyDumbyData("Bobby", Color.red);
		int hashCode = d.hashCode();
		int mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Ralph", Color.blue);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Blake", Color.black);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Roman", Color.white);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Sam", Color.magenta);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Victor", Color.cyan);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = Math.abs(mod);
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Nick", Color.yellow);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Frank", Color.orange);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Aaron", Color.green);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));
		d = new MyDumbyData("Brit", Color.red);
		hashCode = d.hashCode();
		mod = hashCode%map.physicalSize();
		mod = +mod;
		assertTrue(containsKey(entries[mod], d));

	}
}