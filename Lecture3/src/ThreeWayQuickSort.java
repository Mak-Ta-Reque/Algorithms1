import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeWayQuickSort {
    public static void sort (Comparable []a) {
        sort(a, 0, a.length-1);
        
    }

    private static void sort(Comparable [] a, int lo, int hi ) {
        if (hi <= lo) return;
        Comparable v = a[lo];
        int gt = hi;
        int lt = lo;
        int i = lo;
        while(i <= gt) {
            int cmp = a[i].compareTo(v);
            if ( cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else i++;
        }
        sort(a, lo , lt-1);
        sort(a, gt + 1, hi);
        
    }
    
    private static void swap(Comparable[]a, int lt, int i ) {
        Comparable temp = a[lt];
        a[lt] = a[i];
        a[i] = temp;
    }
    
    public static void main(String [] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
            
        }
        // Sort algorithm 
        ThreeWayQuickSort.sort(a);
        
        
        for ( int  i = 0; i < N; i ++) {
            StdOut.println(a[i]);
            
        }
        
    }
}
