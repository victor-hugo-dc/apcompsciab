package edu.fcps.ab;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class MyStack<E> implements Collection<E> {
	private LinkedList<E> list;
	
	public MyStack() {
		list = new LinkedList<E>();
	}
	public boolean push(E e) {
		return list.add(e);
	}
	public E pop() {
		if(list.isEmpty())
			throw new IndexOutOfBoundsException();
		return list.removeLast();
	}
	
	public E peek() {
		return list.getLast();
	}
	
	public boolean add(E e) {
		return push(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return list.addAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return list.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Collections.reverse(list);
		return list.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < a.length; i++)
			a[i] = (T)list.get(list.size() - 1 - i);
		return a;
	}

}
