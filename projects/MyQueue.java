package edu.fcps.ab;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue<E> implements Collection<E> {
	private LinkedList<E> list;
	
	public MyQueue() {
		list = new LinkedList<E>();
	}
	
	public boolean enqueue(E arg0) {
		return list.add(arg0);
	}
	
	public E dequeue() {
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		return list.removeFirst();
	}
	
	public E peek() {
		return list.getFirst();
	}
	
	@Override
	public boolean add(E arg0) {
		return enqueue(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return list.addAll(arg0);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return list.contains(arg0);
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

	// Not supported by Queue
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	// Not supported by Queue
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	// Not supported by Queue
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	// Not supported by Queue
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
		return list.toArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		int i = 0;
		for(E e : list)
			a[i++] = (T)e;
		return a;
	}
}
