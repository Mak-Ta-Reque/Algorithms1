public final class BSTST<Key extends Comparable<Key>, Value> {
    private Node root;
    
    private final class Node{
        private Key key; 
        private Value value;
        private Node left;
        private Node right;
        private int count;
        private Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
    
    public void put(Key key, Value value) {
        root = put(root, key, value);
        
    }
    
    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key,value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
        
        
    }
    
    public int size() {
       return size(root);
        
    }
    private int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }
    
    public int rank(Key key) {
        return rank(key, root);
    }
    
    private int rank(Key key, Node node) {
         if(node == null) return 0;
         int cmp = key.compareTo(node.key);
         if (cmp < 0) return rank(key, node.left);
         if( cmp > 0) return 1 + size(node.left) + rank(key, node.right);
         else return size(node);
    }
    
    
    public Value get(Key key) {
        
        Node x = root; 
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
        
    }
    
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right,key);
        if(t != null) return t;
        return x;
    }
    
    public Key celing(Key key) {
        Node x = celing(root, key);
        if(x == null) return null;
        return x.key;
        
    }
    
    private Node celing(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if (cmp > 0) return celing(x.right, key);
        Node t = celing(x.left, key);
        if(t != null) return t;
        return x;
        
    }
    
    public Key min() {
        Node x = root;
        if (x == null) return null;
        while(x.left != null) {
            x = x.left;
        }
        return x.key;
        
    }
    
    public Key max() {
        Node x = root;
        if (x == null) return null;
        while(x.right != null) {
            x = x.right;
            
        }
        return x.key;
    }
    public void delte(Key key) {
        
        
    }
    
    public Iterator<Key> iterator(){
        
    }
    

}
