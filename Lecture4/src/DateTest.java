import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void testEqual() {
        Date date1 = new Date(2, 4,2020);
        Date date2 = new Date(3, 4,2020);
        assertEquals(date1.equals(date2),false);
        date2 = new Date(2, 4,2020);
        assertEquals(date1.equals(date2),true);
        date1 = new Date(3, 4,2020);
        assertEquals(date1.equals(date2),false);
        
    }
    @Test
    void testEqualTo() {
        Date date1 = new Date(2, 4,2020);
        Date date2 = new Date(3, 4,2020);
        assertEquals(date1.compareTo(date2),-1);
        date2 = new Date(1, 4,2020);
        assertEquals(date1.compareTo(date2),+1);
        date1 = new Date(1, 4,2020);
        assertEquals(date1.compareTo(date2),0);
        date1 = new Date(1, 5,2020);
        assertEquals(date1.compareTo(date2),+1);
        date1 = new Date(1, 4,2021);
        assertEquals(date1.compareTo(date2),+1);
       
        
    }

}
