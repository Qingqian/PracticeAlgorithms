
public class UnionFindBalancedTree {
	
	private int[] parent;  
	private int[] size;   // the number of nodes in the subtree rooted at i
	private int count;    // the number of connected components
	
	public UnionFindBalancedTree(int N) {
		parent = new int[N];
		size = new int[N];
		count=N;;
		for(int i=0;i<N;i++) {
			parent[i]=i;
			size[i]=1;
		}
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public void union(int p, int q) {
		int rootp = find(p);
		int rootq = find(q);
		if(rootp == rootq) return;
		if(size[rootp] < size[rootq]) {
			parent[rootp] = rootq;
			size[rootq] += size[rootp];
		} else {
			parent[rootq] = rootp;
			size[rootp] += size[rootq];
		}
		count--;
	}
	
	public int find(int p){
		while(p != parent[p]){
			p = parent[p];
		}
		return p;
	}
	
	public int count(){
		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionFindBalancedTree balancedTree = new UnionFindBalancedTree(10);
		balancedTree.union(0, 5);
		balancedTree.union(5, 6);
		balancedTree.union(6, 1);
		balancedTree.union(1, 2);
		balancedTree.union(2, 7);
		balancedTree.union(3, 8);
		balancedTree.union(4, 9);
		balancedTree.union(3, 4);
		System.out.println(balancedTree.count());
	}

}
