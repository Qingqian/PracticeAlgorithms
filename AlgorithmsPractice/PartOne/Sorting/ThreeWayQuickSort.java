package Sorting;

//This class is used for doing quick sort on array with duplicate keys
public class ThreeWayQuickSort {
	
	public static void threeWayQuickSort(int[] array) {
		quickSort(array, 0, array.length -1);
	}
	
	public static void quickSort(int[] array, int low, int high) {
		if(high <= low) 
			return;
		int i = low;
		int lt = low;   // lt always points to the pivot item
		int gt = high;
		int pivot = array[low];
		while(i <= gt) {
			if(array[i] < pivot) {
				swap(array,i, lt);
				i++;
				lt++;
			} else if(array[i] > pivot) {
				swap(array,i, gt);
				gt--;
			} else {
				i++;
			}				
		}
		//skip the equal key items and then sort
		quickSort(array, low, lt-1);
		quickSort(array, gt+1, high);
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void print(int[] array) {
		for(int ele : array)
			System.out.print(ele + " ");
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,2,9,3,2,4,1,35,1,43,2,24};
		threeWayQuickSort(array);
		print(array);
	}
}
