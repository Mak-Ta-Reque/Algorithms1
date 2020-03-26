import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    
    public static void sort(Comparable a[]) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length -1;
        sort(a, lo, hi);
    }
    private static void sort(Comparable a[], int lo, int hi) {
        if (lo >=hi) return;
        int j = partition(a, lo, hi);
        sort (a, lo, j-1);
        sort (a, j+1, hi);
    }
    private static int partition(Comparable a[], int lo, int hi) {
        int i = lo; int j = hi+1;
        while(true) {
            while(less(a[++i], a[lo])) {
                if(i ==hi) break;
            }
            while(less(a[lo], a[--j])) {
                if (j == lo ) break;
                  
                
            }
            if(i >=j ) break;
            exchange(a,i,j);
            
            
        }
        exchange(a,lo,j);
        return j;
    }

    private static void exchange(Comparable[] a, int lo, int j) {
        Comparable tmp = a[lo];
        a[lo] = a[j];
        a[j] = tmp;
        
        
    }

    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) == -1;
    }
    public static void main(String []args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
            
        }
        // Sort algorithm 
        long startTime = System.nanoTime();
        
        QuickSort.sort(a);
        long endTime =  System.nanoTime();
        System.out.println("Time spent in sorting " + (endTime - startTime)+ " ns");
        
        for ( int  i = 0; i < N; i ++) {
            StdOut.println(a[i]);
            
        }
    }

}
