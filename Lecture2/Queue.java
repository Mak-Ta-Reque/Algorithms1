public class Queue {
    private Node first, last;
    private int n = 0;
    
    private class Node {
        String value;
        Node next;
    }
    
    public void enqueue(String value) {
        n ++;
        Node oldLast = last;
        last = new Node();
        last.value = value;
        last.next = null;
        if (isEmpty()) first = last;
        
        else {
            oldLast.next = last;
        }
    }
    
    public String dequeue() {
        n --;
        String value = first.value;
        first = first.next;
        if (isEmpty()) last = null;
        return value;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
   
        return n;
    }
}
