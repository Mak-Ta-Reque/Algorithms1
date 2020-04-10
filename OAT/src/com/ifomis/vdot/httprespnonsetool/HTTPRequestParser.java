package com.ifomis.vdot.httprespnonsetool;
/*
 * MD. ABDUL KADIR
 */

import java.io.StringReader;
import java.util.LinkedList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class HTTPRequestParser {
    /*
     * parseTerm method parse the HTTP response String message received by
     * first post test
     * 
     */
    private static final String TERMLIST = "termlist";
    private static final String RESPONSETERMLIST = "termList";
    private static final String USER = "user";
    private static final String EMAIL = "email";

    
    public  LinkedList<OatTerm> parseTerm(String jsonString ) throws Exception {
        if (jsonString == null) throw new NullPointerException("The HTTP message is null in " + getClass().getName());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonReader reader = Json.createReader(new StringReader(jsonString));
        JsonObject nodeRoot  = reader.readObject();
        JsonArray termlist =  nodeRoot.getJsonArray(TERMLIST);
        JsonObject user = nodeRoot.getJsonObject(USER);
        User oatuser = objectMapper.readValue(user.toString(), User.class);
        LinkedList<OatTerm> termList = new LinkedList<OatTerm>();
        for(int i = 0; i < termlist.size(); i++) {
           Term term =  objectMapper.readValue(termlist.get(i).toString(), Term.class);
           OatTerm oatTerms = new OatTerm(oatuser,term);
           termList.push(oatTerms);         
        }
        return termList;
    }
    
    
    public  LinkedList<OATResponseTerm> parseExtentionsRequest(String response) throws Exception {
        if (response == null) throw new NullPointerException("The HTTP message is null in " + getClass().getName());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonReader reader = Json.createReader(new StringReader(response));
        JsonObject nodeRoot  = reader.readObject();
        System.out.println(nodeRoot);
        JsonArray termlist =  nodeRoot.getJsonArray(RESPONSETERMLIST);
        System.out.println(termlist);
        String email =  nodeRoot.getString(EMAIL);
        User user = new User();
        user.setEmail(email);
        System.out.println(email);
        LinkedList<OATResponseTerm> responseList = new LinkedList<OATResponseTerm >();
        for(int i = 0; i < termlist.size(); i++) {
            OATExtentionTerms term =  objectMapper.readValue(termlist.get(i).toString(), OATExtentionTerms.class);
            OATResponseTerm oatTerms = new OATResponseTerm(term, user);
            responseList.add(oatTerms);         
         }
        return responseList;
        
    }
    
}
