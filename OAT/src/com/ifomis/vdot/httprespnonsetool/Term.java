package com.ifomis.vdot.httprespnonsetool;
public class Term {
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public String[] getAlias() {
        return alias;
    }
    public void setAlias(String[] alias) {
        this.alias = alias;
    }
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    String term;
    String [] alias;
    String requestId;
}
