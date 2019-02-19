package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
@SuppressWarnings({"unchecked", "rawtypes"})
public class MyTreeMap<K, V> implements Map<K, V> {
	
	private BinarySearchTreeAPlus maps = new BinarySearchTreeAPlus();
	
	private class MyEntry implements java.util.Map.Entry<K, V>, Comparable<Entry<K,V>>{

		K key;
		V value;
		
		public MyEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public V setValue(V arg0) {
			V temp = value;
			value = arg0;
			return temp;
		}

		public int compareTo(java.util.Map.Entry<K, V> arg0) {
			return arg0.getKey().toString().compareTo(key.toString());
		}
	}

	public void clear() {
		maps = new BinarySearchTreeAPlus();
	}

	public boolean containsKey(Object key) {
		for(K entry : keySet()){
		  	if(entry.equals(key))
		  		return true;
		 }
		 return false;
	}

	public boolean containsValue(Object value) {
		for(V values : values()) {
			if(values.equals(value))
				return true;
		}
		return false;
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return new java.util.TreeSet<java.util.Map.Entry<K, V>>(maps.inOrder());
	}

	public V get(Object key) {
		if(!containsKey(key)) return null;
		for(Entry<K,V> entry : entrySet()) {
			if(entry.getKey().equals(key))
				return entry.getValue();
		}
		return null;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Set<K> keySet() {
		Set<K> set = new java.util.TreeSet<K>();
		for(Entry<K, V> en : entrySet())
			set.add(en.getKey());
		return set;
	}

	public V put(K key, V value) {
		if(key == null || value == null)
			throw new NullPointerException();

		maps.add(new MyEntry(key,value));
		return value;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		for(Entry<? extends K, ? extends V> map : m.entrySet())
			put(map.getKey(), map.getValue());
	}

	public V remove(Object key) {
	for(Map.Entry<K,V> entry : entrySet()) {
			if(key.equals(entry.getKey()) && get(key).equals(entry.getValue()))
				return (V) maps.remove((Comparable) entry);
		}
		return null;
	}

	public int size() {
		return maps.size();
	}

	public Collection<V> values() {
		Collection<V> values = new ArrayList<V>();
		for(Entry<K, V> entry : entrySet())
			values.add(entry.getValue());
		return values;
	}

}