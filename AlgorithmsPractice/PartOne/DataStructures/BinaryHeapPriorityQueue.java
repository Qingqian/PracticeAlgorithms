package DataStructures;

public class BinaryHeapPriorityQueue {
	int[] array;
	int size;
	
	public BinaryHeapPriorityQueue(int capacity) {
		array = new int[capacity+1];
		size=0;
	}
	
	public void insert(int number) {
		array[++size] = number;
		swim(size);
	}
	
	public int deleteMax() {
		int max = array[1];
		swap(array, 1, size);
		size--;
		sink(1);
		//set array[size+1] to null to prevent loitering
		return max;
	}
	
	public void swim(int k){
		int parent = k/2;
		while(k/2 <1 && array[parent] < array[k]) {
			swap(array,parent,k);
			k = k/2;
		}
	}
	
	public void sink(int k) {
		int child = 2*k;
		while(child <=size) {
			if(array[child] < array[child+1]) {
				child = child+1;
			}
			if(array[k] >= array[child])
				break;
			swap(array, k, child);
			k = child;
		}
	}
	
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
