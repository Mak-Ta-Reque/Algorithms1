import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree{
    
    private class Node {
        private final double    xKey;
        private final double    yKey;
        private final boolean   vertical;
        private  Node           left, right;
        
        public Node(final double xKey, final double yKey, Node left, Node right, final boolean vertical ) {
            this.xKey =     xKey;
            this.yKey =     yKey;
            this.left =     left;
            this.right =    right;
            this.vertical = vertical;
            
        }
    }
    // construct an empty KdTree
    private static final RectHV CONTAINER = new RectHV(0, 0, 1, 1);
    private Node root;
    private int size;
    
    public KdTree() {
        size = 0;
        root = null;
        
    }
    
    // does the KdTree contain point p? 
    public boolean contains(Node node, double xKey, double yKye)  {
       if(node == null) return false;
       if (node.xKey == xKey && node.yKey == yKye) return true;
       if (node.vertical && xKey < node.xKey || !node.vertical && yKye < node.yKey) {
           return contains(node.left, xKey, yKye);
           
       }
       else {
           return contains(node.right, xKey, yKye);
       
       }
       
    }
    
 // add the point to the KdTree (if it is not already in the KdTree)
    public void insert(final Point2D p) {
        root = insert(root, p, true);
        
    }
    
    private Node insert(final Node node,final Point2D p, final boolean vertical) {
        if(node == null) {
            size ++;
            return new Node(p.x(), p.y(), null, null, vertical);
            
        }
        
        if (node.xKey == p.x() && node.yKey == p.y()) return node;

        if( vertical && p.x() < node.xKey || !vertical && p.y() < node.yKey) {
            node.left = insert(node.left, p, !node.vertical);
        
        }
        else {
            node.right = insert(node.right, p, !node.vertical);
            
        }
        
        return node;

    }
    
    // draw all points to standard draw 
    public void draw() {
        StdDraw.setScale(0,1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        CONTAINER.draw();
        draw(root, CONTAINER);
        
    }
    
    private void draw(final Node node, final RectHV rect) {
        if (node == null) return;
        
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        new Point2D(node.xKey, node.yKey).draw();
        
        Point2D min, max ;
        if(node.vertical) {
            StdDraw.setPenColor(StdDraw.RED);
            min = new Point2D(node.xKey, rect.ymin());
            max = new Point2D(node.xKey, rect.ymax());
        }
        
        else {
            StdDraw.setPenColor(StdDraw.BLUE);
            min = new Point2D(rect.xmin(), node.yKey);
            max = new Point2D(rect.xmax(), node.yKey);
        }
        
        StdDraw.setPenRadius();
        min.drawTo(max);
        
        draw(node.left, leftRect(rect, node));
        draw(node.right, rightRect(rect, node));
    }
    
    private RectHV leftRect(final RectHV rect, final Node node) {
        if(node.vertical)
            return new RectHV(rect.xmin(), rect.ymin(), node.xKey, rect.ymax());
        else
            return new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), node.yKey);
    }
    
    // is the set empty? 
    
    public boolean isEmpty() {
        return (root == null) ;                  
        
    }
    
    // number of points in the KdTree
    public int size() {
        return size;
        
    }
    
    private Point2D nearest(final Node node, final RectHV rect,
            final double x, final double y, final Point2D candidate) {
        if (node == null) return candidate;

        double dqn = 0.0;
        double drq = 0.0;
        RectHV left = null;
        RectHV rigt = null;
        final Point2D query = new Point2D(x, y);
        Point2D nearest = candidate;

        if (nearest != null) {
            dqn = query.distanceSquaredTo(nearest);
            drq = rect.distanceSquaredTo(query);
        }

        if (nearest == null || dqn > drq) {
            final Point2D point = new Point2D(node.xKey, node.yKey);
            if (nearest == null || dqn > query.distanceSquaredTo(point))
                nearest = point;

            if (node.vertical) {
                left = new RectHV(rect.xmin(), rect.ymin(), node.xKey, rect.ymax());
                rigt = new RectHV(node.xKey, rect.ymin(), rect.xmax(), rect.ymax());

                if (x < node.xKey) {
                    nearest = nearest(node.left, left, x, y, nearest);
                    nearest = nearest(node.right, rigt, x, y, nearest);
                } else {
                    nearest = nearest(node.right, rigt, x, y, nearest);
                    nearest = nearest(node.left, left, x, y, nearest);
                }
            } else {
                left = new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), node.yKey);
                rigt = new RectHV(rect.xmin(), node.yKey, rect.xmax(), rect.ymax());

                if (y < node.yKey) {
                    nearest = nearest(node.left, left, x, y, nearest);
                    nearest = nearest(node.right, rigt, x, y, nearest);
                } else {
                    nearest = nearest(node.right, rigt, x, y, nearest);
                    nearest = nearest(node.left, left, x, y, nearest);
                }
            }
        }

        return nearest;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(final Point2D p)
    {
        return nearest(root, CONTAINER, p.x(), p.y(), null);
    }

    // helper: points in subtree rooted at node inside rect
    private void range(final Node node, final RectHV nrect,
            final RectHV rect, final Queue<Point2D> queue)
    {
        if (node == null) return;

        if (rect.intersects(nrect)) {
            final Point2D p = new Point2D(node.xKey, node.yKey);
            if (rect.contains(p)) queue.enqueue(p);
            range(node.left, leftRect(nrect, node), rect, queue);
            range(node.right, rightRect(nrect, node), rect, queue);
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(final RectHV rect){
        final Queue<Point2D> queue = new Queue<Point2D>();
        range(root, CONTAINER, rect, queue);

        return queue;
    }

    // helper: get the right rectangle of node inside parent's rect
    private RectHV rightRect(final RectHV rect, final Node node) {
        if (node.vertical)
            return new RectHV(node.xKey, rect.ymin(), rect.xmax(), rect.ymax());
        else
            return new RectHV(rect.xmin(), node.yKey, rect.xmax(), rect.ymax());
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
