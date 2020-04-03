import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElementraySTTest {

    @Test
    void testisEmpty() {
        ElementrayST<Integer, String> ST = new ElementrayST<Integer, String>();
        assertEquals(ST.isEmpty(), true);
        ST.put(0,"Zero");
        assertEquals(ST.isEmpty(), false);
        assertEquals(ST.size(),1);
        ST.put(1,"One");
        assertEquals(ST.size(),2);
        ST.delete(0);
        assertEquals(ST.isEmpty(), false);
        assertEquals(ST.size(),1);
        
    }
    @Test
    void testGet() {
        ElementrayST<Integer, String> ST = new ElementrayST<Integer, String>();
        ST.put(0,"Zero");
        ST.put(1,"One");
        assertEquals(ST.get(1), "One");           
    }
    @Test 
    void testPut() {
        ElementrayST<Integer, String> ST = new ElementrayST<Integer, String>();
        ST.put(0,"Zero");
        ST.put(1,"One");
        ST.put(1,"One_");
        assertEquals(ST.get(1), "One_");
    }
    @Test
    void testContains() {
        ElementrayST<Integer, String> ST = new ElementrayST<Integer, String>();
        ST.put(0,"Zero");
        ST.put(1,"One");
        assertEquals(ST.contains(1), true);
        assertEquals(ST.contains(2), false);
    }
    
   @Test
   void testDelete() {
       ElementrayST<Integer, String> ST = new ElementrayST<Integer, String>();
       ST.put(0,"Zero");
       ST.put(1,"One");
       ST.put(2,"Two");
       ST.put(3,"Three");
       ST.delete(3);
       ST.delete(2);
       ST.delete(1);
       ST.delete(0);
       assertEquals(ST.size(),0);
       assertEquals(ST.isEmpty(),true);
       
   }
   @Test
   
   void testKeys() {
       ElementrayST<Integer, String> ST = new ElementrayST<Integer, String>();
       ST.put(0,"Zero");
       ST.put(1,"One");
       ST.put(2,"Two");
       ST.put(3,"Three");
       Iterable<Integer> it = ST.keys();
       for (Integer i : it) {
          System.out.println( i + "  " + ST.get(i)); 
        
       }
       assertEquals(ST.get(0),"Zero");
       
       
   }
    
    

}
