package Sorting;
//This class implements an iterative implementation of merge sort
public class BottomUpMergeSort {
	
	public static void mergeSort(int[] array) {
		int length = array.length;
		int[] aux = new int[length];
		for(int size=1;size<length;size+=size) {
			for(int low =0; low<length-size; low +=size+size) {
				merge(array,aux, low, low+size-1, Math.min(length-1,low+size+size-1));
			}
		}
	}
	
	public static void merge(int[] array, int[] aux, int low, int mid, int high) {
		for(int i=low;i<=high;i++) {
			aux[i] = array[i];
		}
		int i=low;
		int j=mid+1;
		
		for(int k=low;k<=high;k++) {
			if(i >mid)
				array[k] = aux[j++];
			else if(j > high)
				array[k] = aux[i++];
			else if(aux[i] < aux[j])
				array[k] = aux[i++];
			else
				array[k] = aux[j++];
		}
	}
	
	public static void print(int[] array)
	{
		for(int ele: array)
			System.out.print(ele + " ");
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		mergeSort(array);
		print(array);
	}
	
	
}
