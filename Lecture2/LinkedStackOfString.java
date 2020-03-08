public class LinkedStackOfString {
	private class Node{
		String item;
		Node node;
	}
	
	private Node first = null;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(String item) {
		Node next = new Node();
		next.item = item;
		next.node = first;
		first = next;	
	}
	
	public String pop() {
	    if (first == null) throw new NullPointerException("The linked list is empty");
	    
		String item = first.item;
		first = first.node;
		return item;
		
	}
	
	public int size() {
	    int count = 0;
	    Node temp = first;
	    
	    while(!(temp == null)) {
	          temp = temp.node;
	        count ++;
	    }
	    
	    return count;
	}
}
