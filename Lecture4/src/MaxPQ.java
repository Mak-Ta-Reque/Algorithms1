
public final class MaxPQ<Key extends Comparable<Key>> {
    private int size;
    private Key[] pq;
    
    // Constructor 
    MaxPQ(){
        this.size = 0;
        this.pq = (Key[]) new Object[1];
        
    }
    
    MaxPQ(Key [] keys){
        // Implement later
    }
    
    public void insert(Key v) {
        
    }
    
    public Key delMax() {
        
    }
    
    public boolean isEmpty() {
        
    }
    
    public Key Max() {
        
    }
    
    public int size() {
        return this.size;
    }
    
    private void resize(int newSize) {
        Key [] newKeys = (Key[])new Object[newSize];
        for(int k = 0; k < pq.length; k++ ) {
              newKeys[k] = pq[k];
        }
        pq = newKeys;
    }
    
    private void swim(int k) {
        
    }
    
    private void sink(int k) {
        
    }
    

}
