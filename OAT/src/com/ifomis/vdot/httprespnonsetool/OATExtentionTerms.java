package com.ifomis.vdot.httprespnonsetool;

public class OATExtentionTerms {
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public String getSelectedURL() {
        return selectedURL;
    }
    public void setSelectedURL(String selectedURL) {
        this.selectedURL = selectedURL;
    }
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    private String term;
    private String selectedURL;
    private String requestId;

}
