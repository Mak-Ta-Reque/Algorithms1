
public class ST<Key extends Comparable<Key>, Value> {
    private Key [] key; // = (Key[])new Object[];
    private Value [] value;
    private int count;
    
    public ST() {
        key = (Key[])new Object[1];
        value = (Value[])new Object[1];
        count = 0;
    }
    
    public boolean isEmpty() {
       return count == 0; 
    }
    
    public int size() {
        return count;
    }
    
    public void delete(Key k) {
        
    }
    
    public boolean contains(Key key) {
        
    }
    
    public Key min() {
        
    }
    
    public Key max() {
        
    }
    
    public Key floor() {
        
    }
    
    public Key ceiling() {
        
    }
    
    public int rank(Key k) {
        
    }
    
    public Key select(int k) {
        
    }
    
    public void deleteMin() {
        
    }
    
    public void deleteMax() {
        
    }
   
    public int size(Key lo, Key hi) {
        
    }
    
    public Iterable<Key> keys(){
        
    }
    
    public Iterable<Key> keys(Key lo, Key hi){
        
    }
    public void put(Key k, Value val) {
        if(get(k)== null) {
            key[count] = k; value[count] = val;
            count ++;
            if (count >= key.length ) resize(2*count);
        }
        else {
            int m = rank(k);
            value[m] = val; 
            
            
        }
    }
    
    
    
    
    public Value get(Key k) {
        if(k == null) return null;
        int m = rank(k);
        if (m <= count && key[m].compareTo(k)==0) {count -- ;return value[m];}
        else return null;
    }
    
    private int rank(Key k) {
        int lo = 0;
        int hi = key.length - 1;
        while(lo <= hi) {
            int m = lo + (hi -lo)/2;
            int cmp =  k.compareTo(key[m]);
            if (cmp < 0) hi = m -1;
            else if(cmp > 0 ) lo = m +1; 
            else return m;
            
        }
       return lo;
        
    }
    
    private void resize(int size) {
        Key [] newKey = (Key[])new Object[size];
        Value [] newValue = (Value[])new Object[size];
        for (int i = 0; i< key.length; i++) {
            newKey[i] = key[i];
            newValue[i] = value[i];
        }
        value = newValue;
        key = newKey;
    }
}
