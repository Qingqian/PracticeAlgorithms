package DataStructures;

public class BinarySearchTree {
	// In java, BST is a reference to the root node 
	private Node root;
	
	public class Node {
		int key;
		int value;
		int size;     // the number of child nodes rooted at the current node
		Node left;
		Node right;
		public Node(int key, int value, int size) {
			this.key = key;
			this.value = value;
			this.size = size;
		}
	}
	
	public BinarySearchTree() {
		
	}
	
	//APIs
	public boolean isEmpty() {
		return this.size() ==0;
	}
	
	public Node put(int key, int value) {
		return put(root, key, value);
	}
	
	public Node put(Node root, int key, int value) {
		if(root == null)
			return new Node(key, value, 1);
		if(root.key == key)
			root.value = value;
		else if(key < root.key)
			root.left = put(root.left, key, value);
		else
			root.right = put(root.right, key, value);
		root.size = 1 +size(root.left) + size(root.right);
		return root;
	}
	
	// get th value from the key in a symbol table
	public int get(int key) {
		return get(root,key);
	}
	
	public int get(Node root, int key) {
		if(root == null)
			return Integer.MIN_VALUE;
		if(root.key == key)
			return root.value;
		else if(key < root.key) 
			return get(root.left, key);
		else
			return get(root.right, key);
	}
 	
	// Return the total number of node in a BST
	public int size() {
		 return size(root);
	}
	
	// helper function to the size() one
	public int size(Node root) {
		if(root == null)
			return 0;
		return root.size;
		
	}
	
	//Ordered operations
	public int max() {
		return max(root);
	}
	
	public int max(Node root) {
		if(root.right == null)
			return root.value;
		return max(root.right);
	}
	public int min() {
		return min(root).value;
	}
	
	public Node min(Node root) {
		if(root.left == null)
			return root;
		return min(root.left);
	}
	
	public int floor(int k) {
		return floor(root, k).value;
	}
	
	public Node floor(Node root, int k) {
		if(root == null)
			return null;
		if(root.value == k)
			return root;
		else if(root.value > k) {
			return floor(root.left, k);
		} else {
			Node potentialResult = floor(root.right, k);
			if(potentialResult != null)
				return potentialResult;
			else
				return root;
		}
	}
	
	public int ceiling(int k) {
		return ceiling(root,k).value;
	}
	
	public Node ceiling(Node root, int k) {
		if(root == null)
			return null;
		if(root.value == k)
			return root;
		else if(root.value > k) {
			Node potentialResult = ceiling(root.right, k);
			if(potentialResult != null)
				return potentialResult;
			else
				return root;
		} else {
			return ceiling(root.left, k);
		}
	}
	
	// number of nodes whose key are smaller than k
	public int rank(int key) {
		return rank(root, key);
	}
	
	public int rank(Node root, int key) {
		if(root == null)
			return 0;
		if(root.value == key)
			return size(root.left);
		else if(root.value > key) {
			return rank(root.left, key);
		} else {
			return 1 + size(root.left) + rank(root.right, key);
		}
	}
	
	// select the kth smallest/largest in the symbol table
	public int select(int k) {
		return select(root, k).value;
	}
	
	public Node select(Node root, int k) {
		if(root == null)
			return null;
		int count = size(root.left);
		if(count == k)
			return root;
		else if(count > k) {
			return select(root.left, k);
		} else {
			return select(root.right, k-count-1);
		}
	}
	//Delete min/max
	//The min/max node may have 1 child, we need to make sure that child is still maintained in the tree
	public Node deleteMin(Node root) {
		if(root.left == null)
			return root.right;
		root.left = deleteMin(root.left);
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}
	
	public Node deleteMax(Node root) {
		if(root.right == null)
			return root.left;
		root.right = deleteMax(root.right);
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}
	//General deletion in BST
	public Node delete(Node root, int key) {
		if(root == null) 
			return null;
		if(key <root.value) {
			return delete(root.left, key);
		} else if(key > root.value) {
			return delete(root.right, key);
		} else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				Node current = root;
				root = min(current.right);
				root.right = deleteMin(current.right);
				root.left = current.left;
			}	
		}
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}
}
