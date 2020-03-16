import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {
    
    public Deque() {
       first = null;
       Node last = null;
       size = 0;
    }
    
    private class Node {
        Item item;
        Node next;
    }
    //private Node initNode = null;
    private Node first;
    private Node last;
    private int size;
    
    // construct an empty deque
    

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("The value of item is null");
        Node new_first = new Node();
        new_first.item = item;
        new_first.next = first;
        first = new_first;
        size ++;
        
        if (last == null) {
            last = first;
        }
        
        
        
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("The value of item is null");
        Node new_last = new Node();
        new_last.item = item;
        new_last.next = null;
        last.next = new_last;
        last = new_last;
        size ++;
        if (first == null) {
            first = last;
        }
       
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) throw new NoSuchElementException("Deque is empty");
        Item item = first.item;
        first = first.next;
        size --;
        return item;    
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (last == null) throw new NoSuchElementException("Deque is empty");
        Item item = last.item;
        Node last= first;
        int i = 0;
        while(i < size - 2) {
            last = last.next;

            i ++;
        }
        last.next = null;
        size --;
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
            if (current == null) throw new NoSuchElementException("Deque is empty");
            Item value = current.item;
            current = current.next;
            //size --;
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
        deque.addFirst("Updated first");
        String updatedFirst = (String) deque.removeFirst();
        System.out.println("Updated First Item removed : " + updatedFirst);
        System.out.println("Size of deque: " + deque.size); 
        deque.removeFirst();
        
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