

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public final class HTTPRequestParser {
    /*
     * parseTerm method parse the HTTP response String message received by
     * first post test
     * 
     */
    private static final String TERMLIST = "termlist";
    private static final String TERM = "term";
    private static final String USER = "user";
    private static final String USEREMAIL = "email";
    
    public void parseTerm(String jsonString ) throws Exception {
        if (jsonString == null) throw new ExceptionForwarder("The HTTP message is null in " + getClass().getName());
        Object obj = new JSONParser().parse(jsonString);
        JSONObject jsonObject = (JSONObject) obj; 
       
        
        JSONArray ja = (JSONArray) jsonObject.get(TERMLIST); 
        
        // iterating phoneNumbers 
        Iterator itr2 = ja.iterator(); 
        Iterator<Map.Entry> itr1 ;
        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
        
        
    }
    
    public void parseExtentions() {
        
    }
    
    public static void main() throws Exception {
        
        String firstPost = "{\"termlist\":[{ \"term\": \"sugar\",\"alias\": [],\"requestId\": \"112\"},\n" +
                "{ \"term\": \"salt\",\"alias\": [],\"requestId\": \"112\"},\n" +
     "{ \"term\": \"troponin\",\"alias\": [],\"requestId\": \"112\"},\n" +
     "{ \"term\": \"Melanoma\",\"alias\": [],\"requestId\": \"112\"},\n"  +
     "{ \"term\": \"Lipase\",\"alias\": [],\"requestId\": \"112\"}],\"user\" : {\"email\": \"ifomis2017@gmail.com\"}}";
        new HTTPRequestParser().parseTerm(firstPost);
    }
}
