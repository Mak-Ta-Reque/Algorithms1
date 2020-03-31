import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class HeapSort {
    public static void sort(Comparable [] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while(N > 1) {
            exchange(a, 1, N);
            sink(a,1, --N);
        }
        
    }
    
    private static void sink(Comparable[] a, int k, int N) {
        
        while(2 * k <= N) {
            int j = 2 * k;
            if((j < N) && less(a, j, j+1)) j ++;
            if (!less(a, k, j)) break;
            exchange(a, k, j);
            k = j;
                    
        }
        
    }
     private static void exchange(Comparable a [], int k, int j) {
         Comparable temp = a[k-1];
         a[k-1] = a[j-1];
         a[j-1] = temp;
     }
     
     private static boolean less(Comparable [] a, int j, int j_1) {
         return a[j-1].compareTo(a[j_1-1]) < 0;
         
     }
     public static void main(String []args) {
         int N = Integer.parseInt(args[0]);
         Double[] a = new Double[N];
         for (int i = 0; i < N; i++) {
             a[i] = StdRandom.uniform();
             
         }
         // Sort algorithm 
         long startTime = System.nanoTime();
         
         sort(a);
         long endTime =  System.nanoTime();
         System.out.println("Time spent in sorting " + (endTime - startTime)+ " ns");
         
         for ( int  i = 0; i < N; i ++) {
             StdOut.println(a[i]);
             
         }
     }
}
