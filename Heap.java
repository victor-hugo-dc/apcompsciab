package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Heap<E extends Comparable<E>>  {

	private List<E> heap = new ArrayList<E>();
	private int size = 0;
	private boolean min;

	public Heap() { this(true);}
	public Heap(boolean b) { min = b;}
	
	public E get() {
		E c = heap.remove(0);
		size--;
		heapify(0);
		return c;
	}

	public boolean add(E arg0) {
		boolean b = heap.add(arg0);
		size++;
		buildHeap();
		return b;
	}

	public boolean addAll(Collection<? extends E> arg0) {
		boolean b = heap.addAll(arg0);
		size += arg0.size();
		buildHeap();
		return b;
	}

	public void clear() {
		heap.clear();
		size = 0;
	}

	public boolean isEmpty() { return heap.isEmpty();}
	public int size() { return size;}
	private int left(int i) { return 2 * i + 1;}
	private int right(int i) { return 2 * (i + 1);}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void heapify(int i) {
		if (size == 0) return;
		int largest, left = left(i), right = right(i);
		Comparable<?> c = heap.get(i);
		if(min) {
			if (left < size && ((Comparable) heap.get(left)).compareTo(c) < 0)
				largest = left;
			else
				largest = i;
			if (right < size && ((Comparable) heap.get(right)).compareTo(heap.get(largest)) < 0)
				largest = right;
			if (largest != i) {
				Collections.swap(heap, i, largest);
				heapify(largest);
			}
		} else {
			if (left < size && ((Comparable) heap.get(left)).compareTo(c) > 0)
				largest = left;
			else
				largest = i;
			if (right < size && ((Comparable) heap.get(right)).compareTo(heap.get(largest)) > 0)
				largest = right;
			if (largest != i) {
				Collections.swap(heap, i, largest);
				heapify(largest);
			}
		}
	}

	private void buildHeap() {
		int i = size / 2;
		while(i >= 0)
			heapify(i--);
	}

	public List<E> getStructure(){ return heap;}
	
	public String[] heapSort() {
		String[] arr = new String[size];
		int i = size - 1;
		while (arr[0] == null) {
			E temp = heap.remove(0);
			heap.add(temp);
			size--;
			buildHeap();
			arr[i--] = (String) temp;
		}
		buildHeap();
		return arr;
	}
}