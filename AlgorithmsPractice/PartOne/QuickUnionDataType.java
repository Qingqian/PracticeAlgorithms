
public class QuickUnionDataType {

	private int[] array;
	
	public QuickUnionDataType(int N){
		array = new int[N];
		for(int i=0; i<N;i++) {
			array[i]=i;
		}
	}
	
	public void union(int p, int q){
		int root1 = root(p);
		int root2 = root(q);
		array[root1] = root2;
	}
	
	public boolean connected(int p, int q){
		return (root(p) == root(q));
	}
	
	//find the component
	public int find(int p){
		return root(p);
	}
	
	public int count(){
		//Counting the number of the roots -- the value should be the same as the index
		int total=0;
		for(int i=0; i<array.length;i++) {
			if(array[i] ==i){
				total +=1;
			}
		}
		return total;
	}
	
	private int root(int p){
		while(array[p] != p){
			p = array[p];
		}
		return p;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnionDataType quickUnion = new QuickUnionDataType(10);
		quickUnion.union(0, 5);
		quickUnion.union(5, 6);
		quickUnion.union(6, 1);
		quickUnion.union(1, 2);
		quickUnion.union(2, 7);
		quickUnion.union(3, 8);
		quickUnion.union(4, 9);
		quickUnion.union(3, 4);
		System.out.println(quickUnion.count());
	}

}
