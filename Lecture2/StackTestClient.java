import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class StackTestClient {
	public static void main(String [] args) {
		//Yet to bild 
		LinkedStackOfString stack = new LinkedStackOfString();
		while(!StdIn.isEmpty()) {
			
			String s = StdIn.readString();
			
			if(s.equals("_") ) StdOut.println(stack.pop());
			else stack.push(s);
			
		
			
		}
	}
}
