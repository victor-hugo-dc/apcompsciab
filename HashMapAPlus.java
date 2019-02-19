package edu.fcps.ab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
@SuppressWarnings({"unchecked", "rawtypes"})

public class HashMapAPlus<K,V> implements Map<K, V> {
	
	private MyMapEntry [] arImp = null;
	private LinkedList<MyMapEntry> [] listImp = null;
	private int size = 0;

	class MyMapEntry implements Entry<K,V>{

		private K key;
		private V value;
	
		public MyMapEntry(K k) {
			key = k;
		}
		
		public MyMapEntry(K k, V v) {
			this(k);
			value = v;
		}
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V v) {
			V oldValue = value;
			value = v;
			return oldValue;
		}
		
		public boolean equals(MyMapEntry bob) {
			return key.equals(bob.key);
		}
		
	    public int hashCode() { return key.hashCode();}
 
	}
	
	/*
	 * Void Constructor that will default the storage mechanism to 
	 * an array of Entries that are rehashed on collision. Array 
	 * should default to 50 long
	 */
	public HashMapAPlus() {
		this(50);
	}
	
	/**
	 * constructor that defaults to using an array of Entries
	 * but the length of the initial array is the parameter given
	 * @param length initial length of the storage array
	 */
	public HashMapAPlus(int length) {
		this(false, length);
	}
	
	/**
	 * Constructor which parameter indicates either an array of Entries
	 * or an Array of LinkedList<Entry>. Default length of 50
	 * @param imp true indicates using a linked list implementation
	 *            false indicates using a array of Entries
	 */
	public HashMapAPlus(boolean imp) {
		this(imp, 50);
		
	}
	
	/**
	 * Constructor which indicates which implementation of the table
	 * and the initial length of the storage array
	 * @param imp true indicates using a linked list implementation
	 *            false indicates using a array of Entries
	 * @param length initial length of the storage array
	 */
	public HashMapAPlus(boolean imp, int length) {
		//Insert constructor code here 
		if(imp)
			this.listImp = new LinkedList[length];
		else
			this.arImp = (HashMapAPlus<K, V>.MyMapEntry[]) Array.newInstance(MyMapEntry.class, length);
	}
	
	private int index(int hashcode) {
		int index = Math.abs(hashcode);
		index = (arImp != null)? index % arImp.length : index % listImp.length;
		return index;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		int len = (listImp != null)? listImp.length : arImp.length;
		if(listImp != null)
			this.listImp = new LinkedList[len];
		else
			this.arImp = (HashMapAPlus<K, V>.MyMapEntry[]) Array.newInstance(MyMapEntry.class, len);
		this.size = 0;
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		for(K k : keySet()) {
			if(k.equals(arg0) || k.hashCode() == arg0.hashCode())
				return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return values().contains(value);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Entry<K,V>> set = new java.util.HashSet<Entry<K,V>>();
		if(listImp != null) {
			for(LinkedList<MyMapEntry> l : listImp) {
				if(l != null && !l.isEmpty())
					set.addAll(l);
			}
		} else {
			for(MyMapEntry mme : arImp) {
				if(mme != null)
					set.add(mme);
			}
		}
		return set;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		Set<K> set = new HashSet<K>();
		if(listImp != null) {
			for(LinkedList<MyMapEntry> l : listImp) {
				if(l != null && !l.isEmpty()) {
					for(MyMapEntry mme : l)
						set.add(mme.key);
				}
			}
		} else {
			for(MyMapEntry mme : arImp) {
				if(mme != null)
					set.add(mme.key);
			}
		}
		return set;
	}

	@Override
	public V put(K key, V value) {
		if(key == null || value == null) 
			throw new NullPointerException();
		MyMapEntry mme = new MyMapEntry(key, value);
		int index = index(mme.key.hashCode());
		if(listImp != null) {
			if(listImp[index] == null) {
				listImp[index] = new LinkedList();
				listImp[index].add(mme);
				size++;
				return value;
			} else {
				boolean flag = true;
				for(int i = 0; i < listImp[index].size(); i++) {
					if(listImp[index].get(i).hashCode() == key.hashCode()) {
						listImp[index].get(i).setValue(value);
						flag = false;
						break;
					}
				}
				if(flag) {
					listImp[index].add(mme);
					size++;
					return value;
				}
			}
		} else {
			if(arImp[index] == null) {
				arImp[index] = mme;
				size++;
			} else if(arImp[index].key.hashCode() == key.hashCode() && key.equals(arImp[index].key)) {
				arImp[index] = mme;
			} else {
					rehash();
					put(key, value);
				}
			}
		return value;
	}
	
	private void rehash() {
		if(arImp != null) {
			MyMapEntry[] arr = (HashMapAPlus<K, V>.MyMapEntry[]) Array.newInstance(MyMapEntry.class, arImp.length * 2);
			for(MyMapEntry m : arImp) {
				if(m != null) {
					int index = Math.abs(m.getKey().hashCode() % arr.length);
					if(arr[index] == null)
						arr[index] = m;
					else {
						rehash();
						return;
					}
				}
			}	arImp = arr;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		for(Entry<? extends K, ? extends V> entry : m.entrySet()) 
			put(entry.getKey(), entry.getValue());
	}
	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		if(!containsKey(key))
			return null;
		MyMapEntry mme = new MyMapEntry((K) key, null);
		int index = index(mme.key.hashCode());
		
		if(arImp != null && arImp[index] != null) {
			mme = arImp[index];
			arImp[index] = null;
			size--;
		} else if(listImp != null && !listImp[index].isEmpty()){
			for(MyMapEntry temp : listImp[index]) {
				if(temp != null && (temp.getKey().equals(key) || temp.getKey().hashCode() == key.hashCode())) {
					MyMapEntry m = listImp[index].remove(listImp[index].indexOf(temp));
					size--;
					return m.value;
				}
					
			}
		}
		return mme.value;
	}
	@Override
	public int size() {
		return size;
	}

	public int physicalSize() {
		return (listImp != null)? listImp.length : arImp.length;
	}

	@Override
	public Collection<V> values() {
		Collection<V> values = new ArrayList<V>();
		for(Entry<K, V> entry : entrySet())
			values.add(entry.getValue());
		return values;
	}
	@Override
	public V get(Object key) {
		int index = index(key.hashCode());
		 if(arImp != null)
		 	return arImp[index].getValue();
		 else{
		 	if(listImp[index] != null)
		 	for(MyMapEntry mme : listImp[index]){
		 		if(mme.hashCode() == key.hashCode())
		 			return mme.getValue();
		 	}
		 }
		 return null;
	}

	public MyMapEntry[] getMapEntryArray() {
			return arImp;
	}

	public LinkedList<MyMapEntry>[] getLinkedListArray(){
			return listImp;
	}
}
