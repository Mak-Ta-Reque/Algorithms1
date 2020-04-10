package com.ifomis.vdot.httprespnonsetool;

public final class OATResponseTerm {
    public OATExtentionTerms getTerm() {
        return term;
    }
    public void setTerm(OATExtentionTerms term) {
        this.term = term;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    private OATExtentionTerms term;
    private User user;
    public OATResponseTerm(OATExtentionTerms term, User user) {
        this.term = term;
        this.user = user;
    }
    

}
