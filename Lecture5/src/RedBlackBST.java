
public class RedBlackBST<Key extends Comparable, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    
    private class Node{
        Key key;
        Value value;
        Node left, right;
        boolean color;
        
    }
    
    public RedBlackBST() {
        
    }
    
    public void put(Key key, Value value) {
        
    }
    
    public Value get(Key key) {
        Node x = root;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if(cmp > 0) x =x.right;
            else return x.value;
        }
        return null;
        
    }
    
    public void delte(Key key){
        
    }
    
    public boolean contains(Key key) {
        
    }
    
    public int size() {
        
    }
    
    public Iterable<Key> keys(){
        
    }
    
    public static void main(String [] args) {
        
    }
    
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }
    
    private Node rotateLeft(Node h) {
        
    }
    

}
