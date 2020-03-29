import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
public class BruteCollinearPoints {
    
   private final Point [] points;
   private int numberOfSegments;
   private LineSegment[] segments;
   
   public BruteCollinearPoints(Point[] points) {
       if (points == null) throw new IllegalArgumentException();
       this.points = points.clone();
       checkNull(this.points);
     
       
       
       numberOfSegments = 0;
       segments = new LineSegment[1];
       populateLineSegments();
       
   }
   public LineSegment[] segments() {
       // the line segments
       LineSegment[] shrunk = new LineSegment[numberOfSegments];
       for (int i = 0; i < numberOfSegments; i++) shrunk[i] = segments[i];
       return shrunk;
   }
   
   public int numberOfSegments() {
     return numberOfSegments;  
   }
   private void populateLineSegments() {
       Arrays.sort(this.points);
       
       for (int i = 0; i < this.points.length - 3; i++) {            
           for (int j = i + 1; j < this.points.length - 2; j++) {
               for (int k = j + 1; k < this.points.length - 1; k++) {
                   for (int l = k + 1; l < this.points.length; l++) {
                       if(this.points[i].slopeTo(this.points[j]) == this.points[j].slopeTo(this.points[k]) &&
                           this.points[j].slopeTo(this.points[k]) == this.points[k].slopeTo(this.points[l])) {
                       
                           // add item to array
                           enqueue(new LineSegment(this.points[i], this.points[l]));

                           this.points[i].drawTo(this.points[l]);
                           StdDraw.show();                           
                       }
                   }
               }
           }
       }
       
   }
   
   //This method check duplicate
   
   //This method check if any point is null 
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
   private void enqueue(LineSegment l)
   {
       if (l == null) throw new java.lang.NullPointerException();
       if (numberOfSegments == segments.length)
           resize(2 * segments.length, segments);
       segments[numberOfSegments++] = l;
   }
   
   private void resize(int size, LineSegment[] l) {
      LineSegment [] newLineSegment =  new LineSegment[size];
      for (int i = 0; i < numberOfSegments; i++ ) {
          newLineSegment[i] = l[i];
          
      }
      segments = newLineSegment;
   }
   
   public static void main(String[] args) {

       // read the n points from a file
       In in = new In("collinear/input48.txt");
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
       BruteCollinearPoints collinear = new BruteCollinearPoints(points);
       for (LineSegment segment : collinear.segments()) {
           StdOut.println(segment);
           segment.draw();
       }
       StdDraw.show();
   }

}