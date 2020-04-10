package com.ifomis.vdot.httprespnonsetool;
import java.util.LinkedList;
import org.junit.Test;
import com.ifomis.vdot.httprespnonsetool.HTTPRequestParser;
import com.ifomis.vdot.httprespnonsetool.OATResponseTerm;
import com.ifomis.vdot.httprespnonsetool.OatTerm;

public class HTTPRequestParserTest {

    @Test
    public void parseTermTest() throws Exception {
        String firstPost = "{\"termlist\":[{ \"term\": \"sugar\",\"alias\": [],\"requestId\": \"112\"},\n" +
                "{ \"term\": \"salt\",\"alias\": [],\"requestId\": \"112\"},\n" +
     "{ \"term\": \"troponin\",\"alias\": [],\"requestId\": \"112\"},\n" +
     "{ \"term\": \"Melanoma\",\"alias\": [],\"requestId\": \"112\"},\n"  +
     "{ \"term\": \"Lipase\",\"alias\": [],\"requestId\": \"112\"}],\"user\" : {\"email\": \"ifomis2017@gmail.com\"}}";
        LinkedList<OatTerm> listodterms = new HTTPRequestParser().parseTerm(firstPost);
        for(OatTerm each : listodterms) {
            System.out.println(each.getUser().getEmail());
            System.out.println(each.getTerm().getTerm());
        }
    }
    
    @Test 
    public void parseResponseTest() throws Exception {
        String requesetMsg = "{\"termList\":\n" +
                "[\n" +
                "{\n" +
                "\"term\":\"Protein\",\n" +
                "\"requestId\":\"113\",\n" +
                "\"selectedURL\": \"http://purl.obolibrary.org/obo/GO_0008150\"}\n" +
                "],\n" +
                "\"email\":\"yxz@ibmt.com\"\n" +
                "}";
       LinkedList<OATResponseTerm> termList  = new HTTPRequestParser().parseExtentionsRequest(requesetMsg);
      
       
       for(OATResponseTerm each : termList ) {
           System.out.println(each.getUser().getEmail());
           System.out.println(each.getTerm().getTerm());
       }
    }
   

}
