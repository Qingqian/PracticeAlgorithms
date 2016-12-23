package Sorting;

public class QuickSort {
	
	public static void quickSort(int[] array) {
		//Shuffle array to ensure the performance
		sort(array,0,array.length-1);
	}
	
	public static void sort(int[] array, int low, int high) {
		// To improve, it is better to use insertion sort for small size subarrays
		if(low >= high) return;
		// To improve, find the median of low, low+(high-low)/2, high and swap the median index with the low index
		// int median = medianOf3(low, low+(high-low)/2, high);
		// swap(array,low,median);
		int pivot = partition(array,low,high);
		sort(array,low,pivot-1);
		sort(array,pivot+1,high);
	}
	
	public static int partition(int[] array, int low, int high) {
		//set the two pointers -1/+1 to avoid index out of bound exception
		int i = low;
		int j = high+1;
		
		while(true) {
			while(array[++i] < array[low]) {
				if(i == high) break;
			}
			while(array[--j] > array[low]) {
				if(j == low) break;
			}
			//check if the points get across
			if(i >=j) break;
			//swap a[i] and a[j]
			swap(array, i, j);	
		}
		//swap a[low] with a[j]
		swap(array, low, j);
		return j;
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void print(int[] array) {
		for(int ele: array) {
			System.out.print(ele + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		quickSort(array);
		print(array);
	}
}
