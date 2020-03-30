import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public final class MaxPQ<Key extends Comparable<Key>> {
    private int size;
    private Key[] pq;
    
    // Constructor 
    MaxPQ(){
        this.size = 0;
        this.pq = (Key[]) new Comparable[2];
        
    }
    
    MaxPQ(Key [] keys){
        // Implement later
    }
    
    public void insert(Key v) {
        pq[++size]= v;
        swim(size);
        if(pq.length - 1 <= size ) resize(pq.length*2);
        
    }
    
    public Key delMax() {
        Key max = pq[1];
        exchange(1,size--);
        sink(1);
        pq[size+1] = null;
        return max;
        
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public Key Max() {
        return pq[1];
    }
    
    public int size() {
        return this.size;
    }
    
    private void resize(int newSize) {
        Key [] newKeys = (Key[])new Comparable[newSize];
        for(int k = 1; k < pq.length; k++ ) {
              newKeys[k] = pq[k];
        }
        pq = newKeys;
    }
    
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k,k/2);
            k = k/2;
            
        }
        
    }
    
    private void sink(int k) {
        while(2 * k <= size) {
            int j = k * 2;
            if( j < size && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exchange(k,j);
            k = j;
        }
    }
    
    private void exchange(int k, int j) {
        Key tmp = pq[k];
        pq[k] = pq[j];
        pq[j] = tmp;        
        
    }
    private boolean less(int j, int k) {
        return pq[j].compareTo(pq[k]) < 0;
    }
    
    public static void main(String[]args) {
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>();
        while (StdIn.hasNextLine()) {
            String nextLine = StdIn.readLine();
            Transaction item = new Transaction(nextLine);
            pq.insert(item);
            if(pq.size()> 5) {
              System.out.println(pq.delMax());
            }
        }
    }

}
