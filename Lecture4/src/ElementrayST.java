import java.util.Iterator;

public class ElementrayST <Key extends Comparable<Key>, Value>{
    private Node first;
    private int count;
    
    private class Node {
       Key key;
       Value val;
       Node next;
    }
    
    public ElementrayST() {
        first = null;
        count = 0;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public Value get(Key key) {
        Node temp = first;
        while(temp != null) {
            if(temp.key.equals(key)) return temp.val;
            temp = temp.next;
        }
        return null;
    }
      
    public void put(Key key, Value val) {
      delete(key);
      count++;
      Node newNode = new Node();  
      newNode.key = key;
      newNode.val = val;  
      newNode.next = first;
      first = newNode;
      
      
    }
    
    
    public boolean contains(Key key) {
        return (get(key) !=null);
    }
    
    public void delete(Key key) {
        Node temp = first, prev = null;
        if (temp != null && temp.key.equals(key)) {
            first = temp.next;
            count --;
            return;
        }
        
        while(temp != null && !temp.key.equals(key)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)return;
        prev.next = temp.next;
        count --;
        
        
        
    }
    
    
    int size () {
        return count;
    }
    
    public Iterable<Key> keys(){
        return new KeyIterable();
    }
    
    public class KeyIterable implements Iterable<Key>{

        @Override
        public Iterator<Key> iterator() {
            // TODO Auto-generated method stub
            return new KeyIterator();
        }
        
    }
    public class KeyIterator implements Iterator<Key>{
        private Node temp = first;
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return temp != null;
        }

        @Override
        public Key next() {
            // TODO Auto-generated method stub
            Key key = temp.key;
            temp = temp.next;
            return key;
        }
        
    }
    
    
}

