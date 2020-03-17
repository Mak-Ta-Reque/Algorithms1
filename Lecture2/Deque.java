import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {
    
    public Deque() {
       first = null;
       last = null;
       size = 0;
    }
    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    //private Node initNode = null;
    private Node first;
    private Node last;
    private int size;
    
    
    // construct an empty deque
    

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("The value of item is null");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (isEmpty()) {
           last = first;
        }
        else {
            oldFirst.prev = first; 
        }
        size ++;

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("The value of item is null");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size ++;
       
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = first.item;
        first = first.next;
        size --;
        if(isEmpty()) {
            last = first;
        }
        else {
            first.prev = null;
        }
        return item;    
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = last.item;
        last = last.prev;
        size --;
        if (isEmpty()) {
            first = last;
        }
        else {
            last.next = null;
        }
        return item;
        
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
        
    }
    
    
private class LinkedListIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public boolean hasNext() {
            return  current!= null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("Deque is empty");
            Item value = current.item;
            current = current.next;
            return value;
        }
        
        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }
        
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String >deque = new Deque<String>();
        
        
        
        System.out.println("Size of deque: " + deque.size);
        deque.addFirst("First");
        deque.addLast("Last");
        String removedString = deque.removeLast();
        System.out.println("Last: " + removedString);
        removedString = deque.removeLast();
        System.out.println("First: " + removedString);
        deque.addFirst("Updated first");
        String updatedFirst = deque.removeFirst();
        System.out.println("Updated First: " + updatedFirst);
        System.out.println("Size of deque: " + deque.size); 

        System.out.println("Size of deque: " + deque.size); 
        
        deque.addLast("Updated Last");
        deque.addLast("last");
        deque.addFirst("First");
        deque.removeLast();
        System.out.println("Size of deque: " + deque.size); 
        
        for (String it : deque) {
            System.out.println(it);
        }
        
        
    }

}