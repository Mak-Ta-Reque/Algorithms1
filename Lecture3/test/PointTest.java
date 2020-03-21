import junit.framework.TestCase;

public class PointTest extends TestCase {
    
    public void testComapreTo() {
        Point point = new Point(0,0);
        assertEquals(point.compareTo(new Point(0,0)), 0);
        assertEquals(point.compareTo(new Point(1,1)), -1);
        assertEquals(point.compareTo(new Point(-1,-2)), 1);
        assertEquals(point.compareTo(new Point(1,0)), -1);
        assertEquals(point.compareTo(new Point(-1,0)), 1);  
    }
    
    public void testCompare() {
        Point point0 = new Point(0,0);
        Point point1 = new Point(2,1);
        Point point2 = new Point(2,2);
        assertEquals(point0.slopeOrder().compare(point1,point2),-1);
        point1 = new Point(1,1);
        point2 = new Point(2,2);
        assertEquals(point0.slopeOrder().compare(point1,point2),0);
        point1 = new Point(2,2);
        point2 = new Point(2,1);
        assertEquals(point0.slopeOrder().compare(point1,point2),1);
        point1 = new Point(0,2);
        point2 = new Point(0,-1);
        assertEquals(point0.slopeOrder().compare(point1,point2),0);
        point1 = new Point(2,0);
        point2 = new Point(0,0);
        assertEquals(point0.slopeOrder().compare(point1,point2),0);
        
    }
}
