package edu.fcps.ab;

import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})
public class MapManipulations {

	
	/**
	 * Takes in a key base and adds sequential numbers to the map
	 * with the key base.
	 * buildMap("bob", 5) --> {"bob0":0,"bob1":1,"bob2":2,"bob3":3"bob4":4}
	 * @param key
	 * @return
	 */
	public static <E,F> Map<E,F> buildMap(E key, int count){
		Map<E, F> map = new HashMap<E, F>();
		int i = 0;
		while(i != count) {
			E e;
			if(key.getClass().getTypeName().equals("java.lang.Integer")) 
				e = (E)(new Integer(Integer.parseInt(key+"") + i));
			else
				e = (E)(key+(i+""));
			F f = (F)(new Integer(i++));
			map.put(e, f);
		}
		return map;
	}

	/**
	 * returns the number keys that have the value given
	 */
	
	public static <E,F> int countValues(Map<E,F> map, F value){
		int count = 0;
		for(Map.Entry<E, F> entry : map.entrySet()) {
			if(entry.getValue().equals(value))
				count++;
		}
		return count;
	}
	
	/**
	 * Takes in a Map and returns the values sorted by key. 
	 * i.e. {"a":"robert","z":"sam","d":"frank","c":"nikki"} 
	 * Would return {"robert","nikki","frank","sam"}
	 */
	public static <E,F> ArrayList<F> sortKeys(Map<E,F> map){
		List sortKeys = new ArrayList(map.keySet());
		Collections.sort(sortKeys);
		ArrayList<F> sort = new ArrayList<F>();
		for(Object o : sortKeys)
			sort.add(map.get(o));
		return sort;
		
	}
	
	/**
	 * returns a list of keys of all elements with the substring of
	 * ss in the values.
	 */
	
	public static ArrayList<String> subStringSet(Map<String, String> map, String ss){
		ArrayList<String> sub = new ArrayList<String>();
		for(Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getValue().contains(ss))
				sub.add(entry.getKey());
		}
		Collections.sort(sub);
		return sub;
	}
	
	
	/**
	 * returns the ArrayList value that has the longest length.
	 */
	
	public static <E,F> ArrayList<F> longestArrayList(Map<E, ArrayList<F>> map){
		ArrayList<F> longest = new ArrayList<F>();
		for(Map.Entry<E, ArrayList<F>> entry : map.entrySet()) {
			if(entry.getValue().size() > longest.size())
				longest = entry.getValue();
		}
		for(Map.Entry<E, ArrayList<F>> entry : map.entrySet()) {
			if(entry.getValue().size() == longest.size())
				return entry.getValue();
		}
		return longest;
	}
	
		
}
