package edu.fcps.ab;

public class WelcomeReview2 {
	
	// Removes an element at the given index and then collapses
	// the array leaving an empty value at the end (0)
	public void removeElementAt(int [] list, int index){
		if(index < 0 || index >= list.length) return;
		for(int i = index; i < list.length-1; i++){
			list[i] = list[i+1];
			}
		list[list.length-1] = 0 ;

	}
	// inserts the value at the index given
	// Always assume you can drop the last element
	public void insertElement(int [] list, int index, int value){
		if(index < 0 || index >= list.length) return;
		for(int i = list.length-1; i > index; i--){
			list[i] = list[i-1];
		}
		list[index] = value;
	}
	
	//doubles the size of the array
	//but does not lose any data
	public int [] expandArray(int [] list){
		int[] expand = new int[list.length*2];
		for(int i = 0; i < list.length; i++){
			expand[i] = list[i];
		}return expand;
	}
	
	// Remove all the instances of value from the list
	// use existing code.
	public void removeAllOfElement(int [] list, int value){
		for(int i = 0; i < list.length; i++){
			if(list[i] == value){
				removeElementAt(list, i);
				i--;
			}
		}
	}
	
	// Adds all the values in addition to list at index position
	// Add them so they appear in order they exist in addition array
	
	public int [] addAllElements(int [] list, int [] additions, int position){
		if(position < 0 || position > list.length) throw new IndexOutOfBoundsException();
		int [] arr = new int[list.length + additions.length];
		for(int i = 0; i < list.length; i++){
			arr[i] = list[i];
		}
		
		for(int i = 0; i < additions.length; i++){
			insertElement(arr, position, additions[i]);
			position++;
		}
		return arr;
	}
	
	// Removes all instances of each element in toGo 
	// From list
	public void removeAllElements(int [] list, int [] toGo){
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < toGo.length; j++){
				if(list[i] == toGo[j]){
					removeElementAt(list, i);
				}
			}
		}
	}
	
	
	
	

}
