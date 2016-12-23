import java.util.HashSet;


public class QuickFindDataType {
	
	private int[] array;
	
	public QuickFindDataType(int N){
		array = new int[N];
		for(int i=0; i<N;i++) {
			array[i]=i;
		}
	}
	
	public void union(int i, int j){
		int source = array[i];
		int destination = array[j];
		
		for(int k=0;k<array.length;k++){
			if(array[k] == source){
				array[k] = destination;
			}
		}
	}
	
	public boolean connected(int i, int j){
		return (array[i] == array[j]);
	}
	
	//component that node p located 
	public int find(int p) {
		return array[p];
	}
	
	//Number of connected components
	public int count(){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<array.length;i++) {
			set.add(array[i]);
		}
		return set.size();
	}
	
	public void Print(){
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + ", ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickFindDataType quickFind = new QuickFindDataType(10);
		quickFind.union(0, 5);
		quickFind.union(5, 6);
		quickFind.union(6, 1);
		quickFind.union(1, 2);
		quickFind.union(2, 7);
		quickFind.union(3, 8);
		quickFind.union(4, 9);
		quickFind.union(3, 4);
		System.out.println(quickFind.count());
		quickFind.Print();

	}
	
}
