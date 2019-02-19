package edu.fcps.ab;


public class WelcomeReview {

   /**
    * Counts the number of times value appears in list
    */
	public int occurences(int [] list, int value){
		int count = 0;
		for(int i : list) {
			if(i == value) {
				count++;
			}
		}
		return count;
	}
	
   /**
    * finds the maximum value in list
    */
	public int max(int [] list){
		int max = list[0];
		for(int i : list) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	
   /**
    * tests if the list is in ascending order returns true if it is, false if not
    */
	public boolean isAscending(int [] list){
		if(list.length == 0) return false;
		for(int i = 0; i < list.length; i++) {
			if(i != list.length-1 && list[i] >= list[i+1]) {
				return false;
			}
		}
		return true;
	}
	
   /**
    * Counts the number of odd numbers in list
    */
	public int countOdd(int [] list){
		int count = 0;
		for(int i : list) {
			if(i%2 != 0) {
				count++;
			}
		}
		return count;
		
	}
	
   /**
    * swaps the values at a and b (indexes)
    */
	public void swap(int [] list, int a, int b){
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}

   /**
    * does an in-place reversal of the list
    */	
	public void reverse(int [] list){
		for(int i = 0; i < list.length/2; i++) {
			swap(list,i, list.length-1-i);
		}
	}
}
