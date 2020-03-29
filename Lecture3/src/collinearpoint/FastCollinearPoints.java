import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    
   private final Point [] points;
   private LineSegment [] lineSegment;
   private int numberOfSegments;
   public FastCollinearPoints(Point[] points) {
       if (points == null) throw new IllegalArgumentException();
       this.points = points.clone();
       // finds all line segments containing 4 or more points
      checkNull(points);
       
       
       numberOfSegments = 0;
       lineSegment = new LineSegment[1];
       populateLineSegments();
   }
   
   public int numberOfSegments()  {
       // the number of line segments
       return numberOfSegments;
   }
   public LineSegment[] segments() {
       // the line segments
       LineSegment[] shrunk = new LineSegment[numberOfSegments];
       for (int i = 0; i < numberOfSegments; i++) shrunk[i] = lineSegment[i];
       return shrunk;
   }
   private void checkNull(Point[] points) {
       if(points == null) {
           throw new IllegalArgumentException();
       }
       
       for (int i = 0; i < points.length; i ++) {
           for(int j = 0; j < points.length; j++) {
               
               if(points[i] == null || points[j] == null) {
                   throw new IllegalArgumentException();
               }
               
               if(i != j && points[i].compareTo(points[j]) == 0) {
                   throw new IllegalArgumentException();
               }
           }
       }

   }
   private void enqueue(LineSegment item) {
       if (item == null) {
           throw new IllegalArgumentException();
       }
       
       if(this.numberOfSegments == this.lineSegment.length) {
           resize(2 * this.lineSegment.length);
       }
       
       this.lineSegment[this.numberOfSegments++] = item;
   }    
   
   
   private void resize(int size) {
      LineSegment [] newLineSegment =  new LineSegment[size];
      for (int i = 0; i < numberOfSegments - 1 ; i++ ) {
          newLineSegment[i] = lineSegment[i];
          
      }
      lineSegment = newLineSegment;
   }
   
   private void  populateLineSegments() {
       LinkedList<Point> collinearPoints = new LinkedList<Point>();   
       
       //Arrays.sort(this.points);
       // check to see if argument matches constraints
       for (Point point : this.points) {
           Arrays.sort(this.points, point.slopeOrder());          
           double prevSlope = 0.0;
           
           for (int j = 0; j < this.points.length; j++) {
               double currentSlope = point.slopeTo(this.points[j]);
               if(j == 0 || currentSlope != prevSlope) {
                   
                   if(collinearPoints.size() >= 3) {
                       //Collections.sort(collinearPoints);
                       this.enqueue(new LineSegment(collinearPoints.getFirst(), collinearPoints.getLast()));                
                       collinearPoints.getFirst().drawTo(collinearPoints.getLast());    
                       StdDraw.show();   
                   }
                   
                   collinearPoints.clear();
               } 
               
               collinearPoints.add(this.points[j]);
               prevSlope = currentSlope; 
           }
       }
          
       
   }
   
   public static void main(String[] args) {

       // read the n points from a file
       In in = new In(args[0]);
       int n = in.readInt();
       Point[] points = new Point[n];
       for (int i = 0; i < n; i++) {
           int x = in.readInt();
           int y = in.readInt();
           points[i] = new Point(x, y);
       }

       // draw the points
       StdDraw.enableDoubleBuffering();
       StdDraw.setXscale(0, 32768);
       StdDraw.setYscale(0, 32768);
       for (Point p : points) {
           p.draw();
       }
       StdDraw.show();

       // print and draw the line segments
       FastCollinearPoints collinear = new FastCollinearPoints(points);
       for (LineSegment segment : collinear.segments()) {
           StdOut.println(segment);
           segment.draw();
       }
       StdDraw.show();
   }
   
}