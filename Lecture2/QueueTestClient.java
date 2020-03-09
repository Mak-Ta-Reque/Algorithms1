import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class QueueTestClient {
	public static void main(String [] args) {
		//Yet to bild 
		Queue queue = new Queue();
		while(!StdIn.isEmpty()) {
			
			String s = StdIn.readString();
			
			if(s.equals("_") ) StdOut.println(queue.dequeue());
			
			else queue.enqueue(s);
			StdOut.println(queue.size());
		
		}
	}
}
