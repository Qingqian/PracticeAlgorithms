package Sorting;

public class FindKthSmallestQuickSelect {
	
	public static int getKthSmallest(int[] array, int k) {
		//shuffle the array to ensure the performance
		int low = 0;
		int high = array.length-1;
		while(high > low) {
			int j = partition(array,low, high);
			if(j > k) 
				high = j-1;
			else if (j <k) 
				low = j+1;
			else
				return array[k];
		}
		// The only situation that will execute the below code is that the high index is equal to low
		// And they are both pointing to the kth index. So in this case, we can just return array[k]
		return array[k];

	}
	
	public static int partition(int[] array, int low, int high) {
		int pivot = array[low];
		int i = low;
		int j = high +1;
		while(true) {
			while(array[++i] < pivot) 
				if(i == high) break;
			while(array[--j] > pivot)
				if(j == low) break;
			if(i >=j) break;
			swap(array,i,j);
		}
		swap(array,low,j);
		return j;
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		int result =getKthSmallest(array,3);
		System.out.println(result);
	}
}
