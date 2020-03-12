
import edu.princeton.cs.algs4.StdRandom;

public class Shauffle {
    public static Object[] shuffle(Object [] a) {
        int N = a.length; 
        for (int i = 0; i < N; i++ ) {
            int r = StdRandom.uniform(i+ 1);
            if(r != i) swap(a, r, i);
        }
        return a;
    }
    
    private static void swap(Object[] a, int r, int i) {
        Object buf = a[r];
        a[r] = a[i];
        a[i] = buf;
        
    }

}
