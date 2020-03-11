
public class Selection {
    public static Comparable [] sort(Comparable []a) {
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[j])) {
                    min = j;
                }
            }
            if(min != i ) {
               swap(a, i, min); 
            }
            
        }
        
        
        
        return a;
    }
    
    private static void swap(Comparable [] a, int i, int min) {
        Comparable buf = a [i];
        a[i] = a[min];
        a[min] = buf;    
    }
    
    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) return true;
        else return false;
        
    }

}
