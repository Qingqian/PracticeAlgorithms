package Sorting;

public class SelectionSort {
	
	public static void selectionSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			int min = i;
			for(int j=i+1;j<array.length;j++) {
				if(array[j] < array[min])
					min = j;
			}
			swap(array,i, min);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void print(int[] array){
		for(int ele: array)
			System.out.print(ele + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		selectionSort(input1);
		print(input1);
	}
	

}
