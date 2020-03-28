
public class BruteCollinearPoints {
    
   private final Point [] points;
   private int numberOfSegments;
   private LineSegment[] lineSegment;
   
   public BruteCollinearPoints(Point[] points) {
       if (duplicate(points)) throw new IllegalArgumentException();
       if (checkNull(points)) throw new IllegalArgumentException();
       if (points == null) throw new IllegalArgumentException();
       this.points = points;
       numberOfSegments = 0;
       lineSegment = new LineSegment[1];
       populateLineSegments();
       
   }
   public LineSegment[] segments() {
       // the line segments
       return lineSegment;
   }
   
   public int numberOfSegments() {
     return numberOfSegments;  
   }
   private void populateLineSegments() {
       int N = points.length - 1;
       for (int p = 0; p <= N - 3; p++ ) {
           for (int q = p + 1; q <= N - 2; q++ ) {
               for (int r = q + 1; r <= N - 1; r++ ) {
                   for (int s = r +1; s <=N; s++ ) {
                       if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r]) && (points[p].slopeTo(points[q]) == (points[p].slopeTo(points[s])))) {
                           lineSegment[numberOfSegments ++] = new LineSegment(points[p], points[s]);
                           if (lineSegment.length <= numberOfSegments ) resize(numberOfSegments *2);
                           
                       }
                       
                      
                               
                   }
                   
               }
           }
       }
   }
   
   //This method check duplicate
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
}