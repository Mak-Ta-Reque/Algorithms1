public class Insertion {
    public static Comparable [] sort(Comparable[] a) {
        int N = a.length;
        
        for (int i = 0; i < N; i++ ) {
            
            for (int j = i; j > 0; j--) {
                
                if (less(a[j], a[j-1])) {
                    swap(a, j, j-1);
                }
                else break;
            }
        }
            
           
        
        return a;
    }
    private static void swap(Comparable [] a, int j, int j_1) {
        Comparable buf = a[j];
        a[j] = a[j_1];
        a[j_1] = buf;
    }
    
    
    
      
    private static boolean less(Comparable p, Comparable q) {
        if (p.compareTo(q) < 0) { 
            return true;
            }
        else {
            return false;   
        }
            
    }
}
    
        
    
    
    



