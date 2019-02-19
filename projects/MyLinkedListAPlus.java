package edu.fcps.ab;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@SuppressWarnings({"unchecked", "rawtypes","hiding"})
public class MyLinkedListAPlus<E> implements List<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public class Node<E>{
		private Node<E> next;
		private Node<E> previous;
		private E data;
		
		public Node(E arg0) {
			data = arg0;
			next = null;
			previous = null;
		}
		public void setNext(Node<E> arg0){next = arg0;}
		public void setPrevious(Node<E> arg0) {previous = arg0;}
		public E getData() {return data;}
		public Node<E> getNext(){return next;}
		public Node<E> getPrevious(){return previous;}
		public void setData(E e) {data = e;}
		public void clear() {
			data = null;
			next = null;
			previous = null;
		}
	}
	
	public MyLinkedListAPlus() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	private Node<E> getNode(int index){
		Node<E> node = head;
		for(int i = 0; i < size; i++) {
			if(i == index) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
	
	private void checkBounds(int index){
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
	}
	public boolean add(E e) {
		// TODO Auto-generated method stub
		Node<E> arg0 = new Node<E>(e);
		if(size == 0) {
			head = arg0;
			tail = arg0;
		} else {
			tail.setNext(arg0);
			arg0.setPrevious(tail);
			tail = tail.getNext();
		}
		size++;
		return true;
	}

	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBounds(index);
		if(index == size) {
			add(element);
			return;
		}
		Node<E> node = new Node<E>(element);
		if(index == 0) {
			head.setPrevious(node);
			node.setNext(head);
			head = node;
		} else {
			node.setNext(getNode(index));
			node.setPrevious(getNode(index-1));
			getNode(index-1).setNext(node);
			getNode(index).setPrevious(node);
		}
		size++;
	}

	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		for(Iterator<? extends E> it = c.iterator(); it.hasNext();)
			add((E)it.next());
		return !c.isEmpty();
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		for(Iterator<? extends E> it = c.iterator(); it.hasNext();)
			add(index++,(E)it.next());
		return !c.isEmpty();
	}

	public void clear() {
		// TODO Auto-generated method stub
		if(size == 0) return;
		else {
			head.clear();
			tail.clear();
		}
		size = 0;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		Node<E> check = head;
		while(check.getNext() != null) {
			if(check.getData().equals((E)o))
				return true;
			check = check.getNext();
		}
		return tail.getData().equals(o);
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		if(c.size() > size) return false;
		for(Object e : c) {
			if(!contains(e))
				return false;
		}
		return true;
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		return getNode(index).getData();
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for(int i = 0; i < size; i++) {
			if(getNode(i).getData().equals(o))
				return i;
		} return -1;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListItr();
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		int index = -1;
		for(int i = 0; i < size; i++) {
			if(getNode(i).getData().equals(o))
				index = i;
		} return index;
	}

	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return new LinkedListItr();
	}

	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return new LinkedListItr(index);
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(!contains(o))
			return false;
		remove(indexOf(o));
		return true;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		Node<E> remove;
        if (size == 1) {
            remove = head;
            head = null;
            tail = null;
        } else if (index == 0) {
			remove = head;
			Node<E> t = head.next;
			t.previous = null;
			head = t;
		} else if (index == size - 1) {
			remove = tail;
			Node<E> t = tail.previous;
			t.next = null;
			tail = t;
		} else {
			Node<E> before = getNode(index - 1);
			remove = getNode(index);
			Node<E> after = getNode(index + 1);
			before.setNext(after);
			after.setPrevious(before);
		}
		size--;
		return remove.getData();
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		for(Iterator it = c.iterator(); it.hasNext();) {
			Object o = it.next();
			if(contains(o)) {
				remove(o);
			}
		}
		return true;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		if(c.isEmpty()) {
			clear();
			return false;
		}
		boolean flag = containsAll(c);
		for(int i = 0; i < size; i++) {
			if(!c.contains(get(i)))
				remove(i--);
		}
		return flag;
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if(index == size) {
			add(element);
			return element;
		}
		E e = getNode(index).getData();
		getNode(index).setData(element);
		return e;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		List<E> al = new MyLinkedListAPlus<E>();
		Node<E> current = getNode(fromIndex);
		while(fromIndex < toIndex) {
			al.add(current.getData());
			fromIndex++;
			current = current.getNext();
		}
		return al;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] arg = new Object[size];
		
		Node<E> current = head;
		int i = 0;
		while(current != null) {
			arg[i] = current.getData();
			i++;
			current = current.getNext();;
		}
		return arg;
	}

	//Do not implement
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean equals(Collection<E> c) {
		int index = 0;
		for(E e : c) {
			if(!getNode(index++).getData().equals(e)) {
				return false;
			}
		}
		return true;
	}
	
	
	public class LinkedListItr implements ListIterator<E>{
		private int index;
		private Node<E> current;
		private boolean canRemove = false;
		
		public LinkedListItr() {
			this.index = 0;
			this.current = getNode(index);
		}
		public LinkedListItr(int i) {
			this.index = i;
			this.current = getNode(this.index);
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();
			E temp = current.getData();
			current = current.getNext();
			canRemove = true;
			index++;
			return temp;
		}

		@Override
		public boolean hasPrevious() {
			return current.getPrevious() != null;
		}

		@Override
		public E previous() {
		    if(current == null){
		        current = tail;
		        return current.getData();
            }
			index--;
			current = current.getPrevious();
			canRemove = true;
			return  current.getData();
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
		    if (!canRemove) {
		    	throw new ConcurrentModificationException();
		    }
            MyLinkedListAPlus.this.remove(--index);
            canRemove = false;
		}

		@Override
		public void set(E e) {
            current.getPrevious().setData(e);
            canRemove = false;
		}

		@Override
		public void add(E e) {
			MyLinkedListAPlus.this.add(index - 1, e);
			canRemove = false;
		}
	}
}
