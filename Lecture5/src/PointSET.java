import java.util.ArrayList;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {
    // construct an empty set of points
    private SET<Point2D>  points;
    public PointSET() {
       points = new SET<Point2D>();
    }
    
    // is the set empty? 
    public boolean isEmpty() {
        return points.isEmpty();     
    }
    
    // number of points in the set 
    public int size() {
       return points.size();
    }
    
    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p)   {
        if (p == null) throw new IllegalArgumentException();
        
        points.add(p);    
    }
    
    // does the set contain point p? 
    public boolean contains(Point2D p)  {
       if (p == null) throw new IllegalArgumentException();
       
       return points.contains(p); 
    }
    
    // draw all points to standard draw 
    public void draw() {
        for(Point2D point : points) {
            point.draw();
        }
    }
    
    // all points that are inside the rectangle (or on the boundary)   
    public Iterable<Point2D> range(RectHV rect){
        if (rect == null) throw new IllegalArgumentException();
        
        ArrayList<Point2D> pointInside = new ArrayList<Point2D>();
        for(Point2D point : points) {
            if(rect.contains(point)) pointInside.add(point);
        }
        return pointInside;
    }
    
    // a nearest neighbor in the set to point p; null if the set is empty 

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        
        Point2D minDistpoint = null;
        double minDistance = Double.POSITIVE_INFINITY;
        
        for(Point2D point : points) {
            double distance = p.distanceSquaredTo(point);
            if(distance < minDistance) {
                minDistance = distance;
                minDistpoint = point;
            }             
        }
        return minDistpoint;     
    }
    
    public static void main(String[] args) {
        PointSET pointset = new PointSET();
        pointset.insert(new Point2D(0.1, 0.2));
        pointset.insert(new Point2D(0.2, 0.2));
        pointset.draw();
        System.out.println(pointset.nearest(new Point2D(0, 0)));
    }

}
