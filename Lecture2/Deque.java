import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    public Deque() {
        
    }
    
    private class Node {
        Item item;
        Node node;
    }
    Node firs;
    
    // construct an empty deque
    

    // is the deque empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return 1;
    }

    // add the item to the front
    public void addFirst(Item item) {
        
    }

    // add the item to the back
    public void addLast(Item item) {
        
    }

    // remove and return the item from the front
    public Item removeFirst() {
        
    }

    // remove and return the item from the back
    public Item removeLast() {
       
        
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        
    }

    // unit testing (required)
    public static void main(String[] args) {
        
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