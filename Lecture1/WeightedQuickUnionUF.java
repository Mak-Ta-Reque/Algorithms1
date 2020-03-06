public class WeightedQuickUnionUF {
	int[] arr;
	int[] tree_sz;
	public WeightedQuickUnionUF(int N) {
		tree_sz = new int[N];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
	}
	
	private int root(int p) {
		while(arr[p]!= p) {
			p = arr[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q) {
		int p_root = root(p);
		int q_root = root(q);
		return p_root == q_root;
	}
	
	public void union(int p, int q) {
		int p_root = root(p);
		int q_root = root(q);
		if (p_root==q_root) return;
		if (tree_sz[p]< tree_sz[q]) {
			arr[p] = q_root;
			tree_sz[q]  += tree_sz[p];
		}
		else {
			arr[q] = p_root;
			tree_sz[p]  += tree_sz[q];
					
			
		}
		
	}
	
	public int [] getArray(){
		return arr;
	}
}
