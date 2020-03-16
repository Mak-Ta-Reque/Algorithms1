import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] s;
    // construct an empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[1];
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
        if (size == s.length) resize( size * 2);
        s[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException("Queue is empty");
        int r = StdRandom.uniform(size);
        if (size == s.length/4) resize(s.length/4);
        Item item = s[r];
        shiftArray(r);
        size--;
        return item;
        
    }
    
    // return a random item (but do not remove it)
    public Item sample() {
        if ( size == 0) throw new NoSuchElementException("Queue is empty");
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
    private void shiftArray(int r) {
        while(r < s.length - 1) {
            s[r] = s [r +1];
            r ++;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        
    }
    
    private class IterableQueue implements Iterator<Item>{
        private Item[] iterArray = s;
        private int iterSize = iterArray.length;
        public boolean hasNext() {
            return (iterArray.length > 0);
            

            
        }
        public Item next() {
           if (size == 0) throw new NoSuchElementException("Empty queue");
           int r = StdRandom.uniform(iterSize--);
           Item item = iterArray[r];
           squiz(r);
           return item;
           
        }
        private void squiz(int r) {
            while(r < iterSize) {
                iterArray[r] = iterArray[r+1];
                r ++;
            }
        }
       public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
            
        }
        
    }

}