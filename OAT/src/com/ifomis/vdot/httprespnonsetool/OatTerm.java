package com.ifomis.vdot.httprespnonsetool;
public class OatTerm{
   public OatTerm(User user, Term term) {
        this.user = user;
        this.term = term;
    }
    
    public Term getTerm() {
        return term;
    }
    public void setTerm(Term term) {
        this.term = term;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    private Term term;
    private User user;
    
}

