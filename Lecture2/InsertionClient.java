
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionClient {
    public static void main (String [] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
            
        }
        // Sort algorithm 
        Merge.sort(a);
        
        for ( int  i = 0; i < N; i ++) {
            StdOut.println(a[i]);
            
        }
        
    }
}
