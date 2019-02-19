package edu.fcps.ab;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MyArrayListAPlus<E> implements List<E>{
	private Object[] data;
	private int size;
	
	public MyArrayListAPlus() {
		data = new Object[5];
		size = 0;
	}
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		data[size] = e;
		size++;
		if(size == data.length) {
			data = Arrays.copyOf(data, data.length*2);
		}
		return true;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(size + 1 >= data.length) { data = Arrays.copyOf(data, data.length*2);}
		if(!(index > -1 && index <= size)) {throw new IndexOutOfBoundsException();}
		for(int i = size+1; i > index; i--) {
			data[i] = data[i-1];
		}
		data[index] = element;
		size++;
		
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		Iterator it = c.iterator();
		while(it.hasNext()) {
			add((E)it.next());
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		if(!(index > -1 && index <= size)) {throw new IndexOutOfBoundsException();}
		for(E e : c) {
			add(index, e);
			index++;
		}
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data = new Object[5];
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for(Object obj : data) {
			if(o.equals(obj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		Iterator<?> it = c.iterator();
		while(it.hasNext()) {
			if(!contains(it.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return (E) data[index];
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for(int i = 0; i < size; i++) {
			if(o.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		int index = -1;
		for(int i = 0; i < data.length; i++) {
			if(o.equals(data[i])) {
				index = i;
			}
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return new MyIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		int index = indexOf(o);
		if(index == -1) return false;
		remove(index);
		return true;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(!(index >= 0 && index < size)) {throw new IndexOutOfBoundsException();}
		E e = (E) data[index];
		for(int i = index; i < size; i++) {
			data[i] = data[i+1];
		}
		size--;
		return e;
		
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		Iterator<?> it = c.iterator();
		while(it.hasNext()) {
			it.remove();
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean flag = containsAll(c);
		for(int i = 0; i < size; i++) {
			if(!c.contains(get(i))) {
				remove(i);
				i--;
			}
		}
		return flag;
		
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		if(!(index >= 0 && index <= size)) {
			throw new IndexOutOfBoundsException();
		}
		if(index == size) {
			add(element);
			return element;
		}
		E temp = (E)data[index];
		data[index] = element;
		return temp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		List<E> list = new MyArrayListAPlus<E>();
		for(int i = fromIndex; i <= toIndex; i++) {
			list.add(get(i));
		}
		return list;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] obj = Arrays.copyOf(data, size);
		return obj;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < size; i++) {
			a[i] = (T)data[i];
		}
		return a;
	}
	
	
	
	public class MyIterator implements ListIterator<E>{
		int index;
		int remove;
		
		public MyIterator() {
			this.index = 0;
			this.remove = index;
		}
		public MyIterator(int i) {
			this.index = i;
			this.remove = index;
		}
		
		@Override
		public void add(E arg0) {
			// TODO Auto-generated method stub
			if(index == 0) {
				MyArrayListAPlus.this.add(0, arg0);
				return;
			}
			MyArrayListAPlus.this.add(index-1, arg0);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index != size;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return (index - 1 >= 0);
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			
			E e = (E)MyArrayListAPlus.this.get(index);
			if(hasNext()) {
				index++;
			}
			remove = index;
			return e;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return index;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			E e = (E)MyArrayListAPlus.this.get(index);
			if(hasPrevious()) {
				index--;
			}
			remove = index;
			return e;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return index - 1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
			if(index == 0) {
				MyArrayListAPlus.this.remove(remove);
				index--;
				remove = -1;
			}
			else
			MyArrayListAPlus.this.remove(remove - 1);
			remove = -1;
			index--;
			
		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub
			if(index == 0) {
				MyArrayListAPlus.this.set(index, arg0);
			}
			MyArrayListAPlus.this.set(index - 1, arg0);
		}
		
	}

}
