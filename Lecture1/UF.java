import java.util.Arrays;

public class UF {
	int arr[];
	public UF(int N) {
		this.arr = new int [N];
		for (int i = 0; i<N; i++) {
			arr[i]=i;
		}
	}
	public void union(int p, int q) {
		System.out.print(Arrays.toString(arr));
		int p_val = arr[p];
		int q_val = arr[q];
		int i = 0;
		while (i < arr.length-1) {
			if(arr[i]==q_val) {
				arr[i]= p_val;
			}
			
			i++;
		}
		
			
		
	}
	public boolean connected(int p, int q) {
		return arr[p]==arr[q];
	}
}
