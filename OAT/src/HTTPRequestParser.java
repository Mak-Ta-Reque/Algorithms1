import java.io.IOException;

/*
 * 
 * Md. Abdul Kadir
 */

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
    
    public void parseTerm(String jsonString ) {
        if (jsonString == null) throw new NullPointerException("The HTTP message is null in " + getClass().getName());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace(); 
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
    
    private final class OatTeram{
        public String getTermlist() {
            return termlist;
        }
        public void setTermlist(String termlist) {
            this.termlist = termlist;
        }
        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = user;
        }
        private String termlist;
        private String user;
        
    }
}
