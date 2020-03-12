public class Shell {
    public static Comparable[] sort(Comparable[] a){
        
        int N = a.length;
      
        // Define the h sequence
        // we consider we will devide the array in min 3 parts
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        System.out.println("highest h: " + h);
            
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for ( int j = i; j >= h ; j = j - h) {
                    if (less(a[j], a[j - h])) swap(a, j, j-h);
                    else break;
                    
                }
            }
            h = h/3;
        }
        
        return a;
    }

    private static void swap(Comparable[] a, int j, int j_h) {
        Comparable buf = a[j_h];
        a[j_h] = a[j];
        a[j] = buf;
        
    }
    
    private static boolean less(Comparable a_j, Comparable a_j_h) {
        if (a_j.compareTo(a_j_h) < 0) return true;
        else return false;
    }
}
