import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;

public class KdTree{
    // construct an empty KdTree
    private Node root;
    private boolean even = true;
    public KdTree() {
        
    }
    // is the set empty? 
    public boolean isEmpty() {
        if (root == null) return true;
        else return false;
                
    }
    
    // number of points in the KdTree
    public int size() {
        return size(root);
    }
    
    // add the point to the KdTree (if it is not already in the KdTree)
    public void insert(Point2D p) {
        root = put(root, p.x(), p.y(), 1.0, true);
        
    }
    
    private Node put(Node x, double xKey, double yKey, double value, boolean even) {
        if(x == null) return new Node(xKey, yKey, value, 1, even);
        if(x.even) {
            if( xKey < x.xKey && ) x.left = put(x.left, xKey, yKey, value, !even);
            else if (xKey > x.xKey) x.right = put(x.right, xKey, yKey, value, !even);
            else {
                x.value = value;
            
            }
            this.even = !this.even;
            x.count = 1 + size(x.left) + size(x.right);
            
        }
        else {
            if( yKey < x.yKey) x.left = put(x.left, xKey, yKey, value, !even);
            else if (yKey > x.yKey) x.right = put(x.right, xKey, yKey, value, !even);
            else {
                x.value = value;
              
            }
            x.count = 1 + size(x.left) + size(x.right);
            this.even = !this.even;
        }
        
        
        return x;

    }
    
    private int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }
    
    // does the KdTree contain point p? 
    public boolean contains(Point2D p)  {
        if(get(p.x(), p.y()) != 0.0) return true;
        else return false;
    }
    
    // draw all points to standard draw 
    public void draw() {
        for(Point2D point : keys() ) {
            point.draw();
        }
    }
    
    private Iterable<Point2D> keys(){
        Queue<Point2D> q = new Queue<Point2D>();
        inorder(root, q);
        return q;
        
    }
    private void inorder(Node x, Queue<Point2D> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(new Point2D(x.xKey, x.yKey));
        inorder(x.right, q);
    }
    
    
    
    // all points that are inside the rectangle (or on the boundary) 
    public Iterable<Point2D> range(RectHV rect) {
       return null; 
    }
    
    // a nearest neighbor in the set to point p; null if the set is empty 
    public Point2D nearest(Point2D p) {
        return null;
    }
    
    private class Node {
        private double xKey;
        private double yKey;
        private boolean even;
        private double value;
        private  Node left, right;
        private int count;
        public Node(double xKey, double yKey, double value, int count, boolean even) {
            this.xKey = xKey;
            this.yKey = yKey;
            this.value = value;
            this.count = count;
            this.even = even;
            
        }
    }
    
    private double get(double xKey, double yKey) {
        Node x = root;
        
        while(x != null) {
            if (x.count%2 == 1) {
                if ( xKey < x.xKey ) x = x.left;
                else if (  xKey > x.xKey ) x = x.right;
                else return x.value;
            }
            else {
                if (yKey < x.yKey) x = x.left;
                else if (yKey > x.yKey) x = x.right;
                else return x.value;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        KdTree pointset = new KdTree();
        pointset.insert(new Point2D(0.3, 0.2));
        pointset.insert(new Point2D(0.2, 0.2));
        pointset.insert(new Point2D(0.3, 0.4));
        pointset.insert(new Point2D(0.4, 0.4));
        pointset.draw();
        System.out.println(pointset.size());
        
        
    }
    

}
