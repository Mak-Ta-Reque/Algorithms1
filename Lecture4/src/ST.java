import java.util.Iterator;

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
        int m = rank(k);
        if ( key[m].compareTo(k) == 0) {
            //key[m] = null;
            //value[m] = null;
            leftShift(m);
        }
        
    }
    
    public boolean contains(Key k) {
        int m = rank(k);
        if ( key[m].compareTo(k) == 0) {
            return true;
        }
        else return false;
        
    }
    
    public Key min() {
       return key[0]; 
    }
    
    public Key max() {
        return key[count];
        
    }
    

    
    public void deleteMin() {
        
    }
    
    public void deleteMax() {
        leftShift(count);
    }
   
    public int size(Key lo, Key hi) {
        return rank(hi) -rank(lo);
        
    }
    
    
    public void put(Key k, Value val) {
        int m = rank(k);
        if(key[m].compareTo(k) == 0) {
            value[m] = val;
        }
        else {
            rightShift(m);
            key[m] = k;
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
    private void rightShift(int index) {
        resize(key.length +1);
        for ( int i = key.length -1 ; i > index - 1; i -- ) {
            key [i] = key[i-1];
            value[i] = value[i-1];  
        }
    }
    
    private void leftShift(int m) {
        for (int i = m; i < key.length - 1; i ++) {
            key[i] = key[i+1];
            value[i] = value[i+1];
        }
        key[key.length - 1] = null;
        value[key.length - 1] = null;
    }
    
    
    private class KeyIterator implements Iterator<Key>{
        Key lo, hi;
        Key[] temp = key;
        int c = count;
        public KeyIterator(Key lo, Key hi){
            this.lo = lo;
            this.hi = hi;
        }
        
        
        
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return c > 0;
        }

        @Override
        public Key next() {
            // TODO Auto-generated method stub
            return key[c--];
        }
       
    }

    
}

