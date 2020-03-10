import java.util.Iterator;


public class Bag<Item> implements Iterable<Item> {
    private class Node{
        Item content;
        Node next;
        
    }
    //Do something
    Node next = null;
    int size = 0;
    public Bag(){
        
    }
    public void put(Item item) {
        Node first = new Node();
        first.content = item;
        first.next = next;
        next = first;
        size ++;
        
        
    }
    public int size() {
        return size;
    }
    
    
    public Iterator<Item> iterator () {
        return new LinkedListIterator();
    }
    
    
    private class LinkedListIterator implements Iterator<Item> {
        public boolean hasNext() {
            return  next!= null;
        }
        
        public Item next() {
            Item value = next.content;
            next = next.next;
            size --;
            return value;
        }
        
        
        
        
        
    }
    
    
}    

