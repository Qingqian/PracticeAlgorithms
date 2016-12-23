package Sorting;

public class HeapSort {
	
	public static void heapSort(int[] array) {
		int n = array.length;
		buildHeap(array, n-1);
		while(n >=1) {
			swap(array,0,n-1);
			n--;
			sink(array,0,n-1);	
		}
	}
	// Build the max-heap from bottom up
	public static void buildHeap(int[] array, int high) {
		for(int i=high/2 -1; i>=0 ;i--) {
			sink(array,i,high);
		}
	}
	// sink the node 
	public static void sink(int[]array, int index, int high) { 
		while(2*index <= high) {
			int childIndex = index *2+1;
			if(childIndex < high && array[childIndex] < array[childIndex+1]) {
				childIndex += 1;
			}
			if(array[index] >= array[childIndex])
				break;
			swap(array, index, childIndex);
			index = childIndex;
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void print(int[] array) {
		for(int ele: array)
			System.out.print(ele + " ");
	}
	public static void main(String[] args) {
		int[] array = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		heapSort(array);
		print(array);
	}
	
}
