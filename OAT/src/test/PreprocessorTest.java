package test;

import java.util.LinkedList;

import org.junit.Test;

import com.ifomis.vdot.httprespnonsetool.HTTPRequestParser;
import com.ifomis.vdot.httprespnonsetool.OatTerm;

public class PreprocessorTest {
    @Test
    public void preprocessTest() throws Exception {
        Preprocessor  prep = new Preprocessor();
        String firstPost = "{\"termlist\":[{ \"term\": \"sugars\",\"alias\": [\"sweety\"],\"requestId\": \"112\"},\n" +
                "{ \"term\": \"salty\",\"alias\": [],\"requestId\": \"112\"},\n" +
     "{ \"term\": \"troponin\",\"alias\": [\" cardio.vascular and chemical  \"],\"requestId\": \"112\"},\n" +
     "{ \"term\": \"Melanomas\",\"alias\": [],\"requestId\": \"112\"},\n"  +
     "{ \"term\": \"Lipase.\",\"alias\": [],\"requestId\": \"112\"}],\"user\" : {\"email\": \"ifomis2017@gmail.com\"}}";
        LinkedList<OatTerm> listodterms = new HTTPRequestParser().parseTerm(firstPost);
        listodterms = prep.preprocess(listodterms);
        for(OatTerm each : listodterms) {
            System.out.print(each.getTerm().getTerm());
            String synonym [] = each.getTerm().getAlias();
            for( int i = 0 ; i < synonym.length; i++ ) {
                System.out.print(" " + synonym[i]);
            }
            System.out.println();

        }
    }

}
