package Sorting;

public class InsertionSort {
	
	public static void insertionSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=i;j>0;j--) {
				if(array[j] < array[j-1]) {
					swap(array,j,j-1);
				//break when there is no value on the left is larger than the current one
				//this will reduce the running time, especially for the sorted array-- no swap
				} else {
					break;
				}	
			}
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void print(int[] array) {
		for(int ele:array)
			System.out.print(ele + " ");
	}
	
	public static void main(String[] args) {
		int[] array = {7,9,10,2,4,6,1};
		insertionSort(array);
		print(array);
	}
}
