public class StackArray {
    private String [] s;
    private int n;
    
    public StackArray () {
        s = new String [1];
        n = 0;
    }
    // Check if the array is empty
    public boolean isEmpty () {
        return n == 0;
    }

    // Do a push operation 
    public void push (String item) {
        if (n == s.length) resize(2 * n);
        s[n++] = item;
    }
    
    // pop an item from stack
    public String pop () {
        if (n == 0) throw new NullPointerException("The stack is empty");
        if (n == s.length/4) resize(s.length * 1/4);
        return s[--n];
    }
    
    // Size of the stack 
    public int size () {
        return n;
    }
    
    private void resize(int sSize) {
        String [] newArray = new String[sSize];
        
        for (int i = 0; i< s.length; i++) {
            newArray[i] = s[i];
        }
        s = newArray;
    }
    
}
