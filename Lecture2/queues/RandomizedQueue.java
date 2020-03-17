import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size ;
    private Item[] s;
    private int capacity;
    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        capacity = 10;
        s = (Item[]) new Object[capacity];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
       return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Null input");
        if (size == capacity) capacity *= 2; resize(capacity);
        s[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int r = StdRandom.uniform(size);
        Item item = s[r];
        s[r] = s[--size];
        s[size] = null;
        if (size < capacity/4) {
            capacity /= 2;
            resize(capacity);
        }
        
        return item;
        
    }
    
    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int r = StdRandom.uniform(size);
        return s[r];
        
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new IterableQueue();
    }
    
    private void resize(int newsSize) {
        Item [] newArray = (Item[]) new Object[newsSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = s[i];
        }
        s = newArray;
        
    }
 

    // unit testing (required)
    public static void main(String[] args) {
        
    }
    
    private class IterableQueue implements Iterator<Item>{
        private int[] iterArray ;
        private int m ;
        
        public IterableQueue() {
            // TODO Auto-generated constructor stub
            iterArray = new int[size];
            m = 0;
            for (int i = 0; i < size; i++) {
                iterArray[i] = i;
            }
            for (int j = 0; j < size; j++) {
                int toSwap = StdRandom.uniform(j+1);
                int temp = iterArray[j];
                iterArray[j] = iterArray[toSwap];
                iterArray[toSwap] = temp;
            }
            
        }
        public boolean hasNext() {
            return ( m < size);
            

            
        }
        public Item next() {
           if (!hasNext()) throw new NoSuchElementException("Empty queue");
           return s[iterArray[m++]];
           
        }
       public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
            
        }
        
    }

}