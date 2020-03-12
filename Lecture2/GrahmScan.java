import java.util.Arrays;

import edu.princeton.cs.algs4.GrahamScan;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GrahmScan {
    private  Stack<Point2D> hull = new Stack<Point2D>();
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            points[i] = new Point2D(x, y);
        }
        GrahamScan graham = new GrahamScan(points);
        for (Point2D p : graham.hull())
            StdOut.println(p);
    }
    private boolean isConvex() {
        int n = hull.size();
        if (n <= 2) return true;

        Point2D[] points = new Point2D[n];
        int k = 0;
        for (Point2D p : hull()) {
            points[k++] = p;
        }

        for (int i = 0; i < n; i++) {
            if (Point2D.ccw(points[i], points[(i+1) % n], points[(i+2) % n]) <= 0) {
                return false;
            }
        }
        return true;
    }
    public Iterable<Point2D> hull() {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull) s.push(p);
        return s;
    }

    public GrahmScan(Point2D [] a) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(a, 1, n, a[0].polarOrder());
        hull.push(a[0]);
        hull.push(a[1]);
        
        for (int i = 2; i< n; i++) {
            Point2D top = hull.pop();
            while(Point2D.ccw(hull.peek(), top, a[i]) <= 0) {
                top = hull.pop();
                
            }
            hull.push(top);
            hull.push(a[i]);
        }
        
        assert isConvex();
        
        
    }
    

    

}
