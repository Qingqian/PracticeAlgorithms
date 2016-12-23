package Sorting;

// MergeSort is kind of like post-order tree traversal
public class MergeSort {
	
	public static void mergeSort(int[] array) {
		int[] aux = new int[array.length];
		//the auxiliary array is used to make the comparison but not to store the final sorted results
		mergeSort(array,aux,0,array.length-1);
	}
	
	public static void mergeSort(int[] array, int[] aux, int low, int high) {
		//To improve, we can define a limit size for mergeSort. For subarrays that are under limit size,
		//we use insertionSort
		if(low >= high)
			return;
		int middle = low + (high-low)/2;
		mergeSort(array, aux, low, middle);
		mergeSort(array, aux, middle+1, high);
		//To improve, we can check whether the largest item in the first half is smaller than the 
		//smallest item in the second half. If it is, we don't need to do the merge since they are all sorted
		//if(array[middle] < array[middle+1]) return;
		merge(array, aux, low, middle, high);
	}
	
	public static void merge(int[] array, int[] aux, int low, int middle, int high){
		//copy the array into the auxiliary array
		for(int i=low; i<=high;i++) {
			aux[i] = array[i];
		}
		int i = low; 
		int j = middle+1;
		for(int k=low; k<=high; k++) {
			// entries in the left sub-array are all in the original array
			if(i >middle)
				array[k] = aux[j++];
			else if(j > high)
				array[k] = aux[i++];
			else if(aux[i] < aux[j])
				array[k] = aux[i++];
			else 
				array[k] = aux[j++];
		}
	}
	
	public static void print(int[] array) {
		for(int ele: array)
			System.out.print(ele + " ");
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		mergeSort(array);
		print(array);
	}

}
