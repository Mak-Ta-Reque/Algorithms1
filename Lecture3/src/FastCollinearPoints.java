public class FastCollinearPoints {
    
   private final Point [] points;
   private LineSegment [] lineSegment;
   private int numberOfSegments;
   public FastCollinearPoints(Point[] points) {
       // finds all line segments containing 4 or more points
       if (duplicate(points)) throw new IllegalArgumentException();
       if (checkNull(points)) throw new IllegalArgumentException();
       if (points == null) throw new IllegalArgumentException();
       this.points = points;
       numberOfSegments = 0;
       lineSegment = new LineSegment[1];
       populateLineSegments();
   }
   
   public int numberOfSegments()  {
       // the number of line segments
       return numberOfSegments;
   }
   public LineSegment[] segments()   {
       // the line segments
       return lineSegment;
   }
   
   private boolean duplicate(Point[] points) {
       for (int i = 0; i <= points.length -1; i++) {
           for (int j = i+1; j <= points.length -1; j++) {
               if (points[i].compareTo(points[j]) == 0) return true;
           }
       }
       return false;
   }
   //This method check if any point is null 
   private boolean checkNull(Point[] points) {
       for (int j = 0; j <= points.length -1; j++) {
           if (points[j] == null) return true;
       }
       return false;
   }
   
   
   
   private void resize(int size) {
      LineSegment [] newLineSegment =  new LineSegment[size];
      for (int i = 0; i < lineSegment.length; i++ ) {
          newLineSegment[i] = lineSegment[i];
          
      }
      lineSegment = newLineSegment;
   }
   
   private void  populateLineSegments() {
       
   }
   
}