package edu.fcps.ab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DifferentSortsAPlus {
	
	
	/**
	 * Write a insertion sort that will sort the given List from least to greatest
	 * The sort should be done in place
	 * 
	 * @param list
	 */
	public static <T> void insertionSort(List<T> list, Comparator<T> c ){
		int i, j;
		T check, temp;
		for(i = 1; i < list.size(); i++) {
			check = list.get(i);
			j = i - 1;
			while(j >= 0 && c.compare(check, list.get(j)) < 0) {
				temp = list.set(j, list.get(j+1));
				list.set(j+1, temp);
				j--;
			}
		}
	}
	
	/**
	 * Using a selection sort, sort list in place from least to greatest
	 * @param list
	 */
	public static <T> void selectionSort(List<T> list, Comparator<T> c){
		int i, j, minIndex = 0;
		T minValue;
		for(i = 0; i < list.size(); i++) {
			minValue = list.get(i);
			minIndex = i;
			for(j = i; j < list.size(); j++) {
				if(c.compare(list.get(j), minValue) < 0) {
					minValue = list.get(j);
					minIndex = j;
				}
			}
			if(c.compare(minValue, list.get(i)) < 0) {
				T e = list.set(i, minValue);
				list.set(minIndex, e);
			}
		}
	}
	
	
	/**
	 * Using MergeSort, sort the list in place from least to greatest
	 * 
	 * @param list
	 */
	public static <T> void mergeSort(List<T> list, Comparator<T> c) {
		mergeSort(list,0, list.size(),c);
	}
	private static <T> void mergeSort(List<T> list, int begin, int end, Comparator<T> c){
		if(end - begin<=1) {
			return;
		}
		int mid = (begin + end) / 2;
		mergeSort(list, begin, mid, c);
		mergeSort(list, mid, end, c);
		merge(list, begin, mid, end, c);
	}
	
	private static <T> void merge(List<T> list, int beg, int mid, int end, Comparator<T> c) {
		List<T> sort = new ArrayList<T>();
		int begin = beg, middle = mid;
		while(begin < mid && middle < end) {
			if(c.compare(list.get(begin), list.get(middle)) < 0) {
				sort.add(list.get(begin));
				begin++;
			} else {
				sort.add(list.get(middle));
				middle++;
			}
		}
		if(begin == mid) {
			while(middle < end) {
				sort.add(list.get(middle));
				middle++;
			}
		} else {
			while(begin < mid) {
				sort.add(list.get(begin));
				begin++;
			}
		}
		for(int i = beg,k=0; k <sort.size(); i++,k++)
			list.set(i, sort.get(k));
	}


}
