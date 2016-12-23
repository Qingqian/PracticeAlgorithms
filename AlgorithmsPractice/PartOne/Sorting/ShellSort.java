package Sorting;

public class ShellSort {

	public static void shellSort(int[] array) {
		int length = array.length;
		int h =1;
		while(h <length/3)
			h = h*3+1;
		while(h >=1) {
			for(int i=h;i<length;i++) {
				for(int j=i;j>=h;j-=h){
					if(array[j] < array[j-h]){
						swap(array, j,j-h);
					} else {
						break;
					}
				}
			}
			h /=3;
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
		// TODO Auto-generated method stub
		int[] array = {2,5,78,9,3,6,1,67,35,1,43,8,24};
		shellSort(array);
		print(array);
	}

}
