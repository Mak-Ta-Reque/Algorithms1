import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quickselect {
    
    public static Comparable select(Comparable []a, int k) {
        int lo = 0;
        StdRandom.shuffle(a);
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if(j < k) lo = j + 1;
            else if(j > k) hi = j -1;
            else return a[k];
            
        }
        return a[k];
        
        
        
    }
    
    
    private static int partition(Comparable []a, int lo, int hi ) {
        int i = lo; int j = hi +1;
        while(true) {
            
            while(less(a[++i], a[lo])){
                if( i == hi) break;
            }
            
            while(less(a[lo], a[--j])) {
                if (j == lo ) break;
            }
            if (i >= j) break;
            swap(a, i, j);
            
        }
        swap(a, lo, j);
        return j;
    }
    
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) == -1;
    }
    
    private static void swap(Comparable []a, int lo, int j) {
        Comparable temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
                
        
    }
    
    public static void main(String[]args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
            
        }
        // Sort algorithm 
        System.out.println(Quickselect.select(a, 2));
        System.out.println("____________________");
        
        for ( int  i = 0; i < N; i ++) {
            StdOut.println(a[i]);
            
        }
    }

}
