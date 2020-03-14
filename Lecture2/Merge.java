public class Merge {

    public static Comparable [] sort(Comparable [] a) {
        int hi = a.length;
        int lo = 0;
        Comparable[] aux = new Comparable [hi];
        sort(a, aux, lo, hi);
        
    
        
        return a;
    }
    private static void merge(Comparable [] aux, Comparable []a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] =  a[k];
        }
        int i = lo;
        int j = mid +1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid) { a[k] = aux[j++];}
            else if (j > hi) { a[k] = aux[i++];}
            else if (less(aux[j],aux[i])) {a[k] = aux[j ++];}
            else { a[k] = aux[i ++];}
            
        }
        
    }
    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0 )return true;
        else return false;
    }
    
    private static void sort(Comparable [] aux, Comparable [] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (hi - lo)/2 +lo;
        sort(aux, a, lo, mid);
        sort(aux, a, mid +1, hi);
        merge(aux, a, lo, mid, hi);
        
    }
}