import java.util.Arrays;
import java.util.Scanner;
// A client that test the dynamic connectivity algorithm
public class DynamicConnectivityClient {
	public static void main(String[] args){
		Scanner StdIn = new Scanner(System.in);
		int N = StdIn.nextInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while(StdIn.hasNextInt()) {
			int p = StdIn.nextInt();
			int q = StdIn.nextInt();
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
			System.out.println(Arrays.toString(uf.getArray()));
		}
		StdIn.close();
	}
}
