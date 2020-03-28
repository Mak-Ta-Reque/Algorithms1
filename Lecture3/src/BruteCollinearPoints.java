
public class BruteCollinearPoints {
    
   private final Point [] points;
   private int numberOfSegments;
   private LineSegment[] lineSegment;
   
   public BruteCollinearPoints(Point[] points) {
       if (duplicate(points)) throw new IllegalArgumentException();
       if (checkNull(points)) throw new IllegalArgumentException();
       if (points == null) throw new IllegalArgumentException();
       this.points = points;
       
   }
   public LineSegment[] segments() {
       // the line segments
       return lineSegment;
   }
   
   public int numberOfSegments() {
     return numberOfSegments;  
   }
   
   //This method check duplicate
   private boolean duplicate(Point[] points) {
       for (int i = 0; i < points.length -1; i++) {
           for (int j = i+1; j < points.length -1; j++) {
               if (points[i].compareTo(points[j]) == 0) return true;
           }
       }
       return false;
   }
   //This method check if any point is null 
   private boolean checkNull(Point[] points) {
       for (int j = 0; j < points.length -1; j++) {
           if (points[j] == null) return true;
       }
       return false;
   }
}