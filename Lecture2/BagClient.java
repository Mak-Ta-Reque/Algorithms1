import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class BagClient {
    public static void main(String [] args) {
        //Yet to bild 
        Bag<String> bag = new Bag<String>();
           while(!StdIn.isEmpty()) {
         
            String s = StdIn.readString();
            if(s.equals("_") ) {
                Iterator<String> iterator = bag.iterator();
                while (iterator.hasNext()) {
                    StdOut.println(iterator.next());
                    
                }
            }
                
            
            else bag.put(s);
            StdOut.println(bag.size());
        
        }
    }
}
