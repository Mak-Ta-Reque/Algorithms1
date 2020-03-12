
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShuffleClient {
    public static void main (String [] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
            
        }
        StdOut.println("Before shuffle");
        for ( int  i = 0; i < N; i ++) {
            StdOut.println(a[i]);
            
        }
        StdOut.println();
        StdOut.println("After shuffle");
        // Sort algorithm 
        a = (Double[]) Shauffle.shuffle(a);
        
        for ( int  i = 0; i < N; i ++) {
            StdOut.println(a[i]);
            
        }
        
    }
}
