public class QuickUnionUF {
	private int arr [];
	public QuickUnionUF(int N) {
		arr = new int[N];
		for (int i= 0; i < N-1; i++ ) {
			arr[i]=i;
		}
	}
	
	private int root(int p) {
		while((arr[p]!= p)) {
			p = arr[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q) {
		return root(p)== root(q);
	}
	
	public void union(int p, int q) {
		int root_p = root(p);
		int root_q = root(q);
		arr[root_p] = root_q;
	}
	public int [] getArray(){
		return arr;
	}

}
