package com.ifomis.vdot.NLPtools;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


import com.ifomis.vdot.httprespnonsetool.OatTerm;
import com.ifomis.vdot.httprespnonsetool.Term;
import com.ifomis.vdot.httprespnonsetool.User;

public final class Preprocessor {
    private static Stemming stemmer = new Stemming();
    private static final List<String> stopwords = Arrays.asList("a", "able", "about",
             "across", "after", "all", "almost", "also", "am", "among", "an",
             "and", "any", "are", "as", "at", "be", "because", "been", "but",
             "by", "can", "cannot", "could", "dear", "did", "do", "does",
             "either", "else", "ever", "every", "for", "from", "get", "got",
             "had", "has", "have", "he", "her", "hers", "him", "his", "how",
             "however", "i", "if", "in", "into", "is", "it", "its", "just",
             "least", "let", "like", "likely", "may", "me", "might", "most",
             "must", "my", "neither", "no", "nor", "not", "of", "off", "often",
             "on", "only", "or", "other", "our", "own", "rather", "said", "say",
             "says", "she", "should", "since", "so", "some", "than", "that",
             "the", "their", "them", "then", "there", "these", "they", "this",
             "tis", "to", "too", "twas", "us", "wants", "was", "we", "were",
             "what", "when", "where", "which", "while", "who", "whom", "why",
             "will", "with", "would", "yet", "you", "your");   
        
    public LinkedList<OatTerm> preprocess(LinkedList<OatTerm> allTerms){
        LinkedList<OatTerm> filteredList = new LinkedList<OatTerm>();
        for(OatTerm item : allTerms) {
            Term termObj = item.getTerm();
            User user = item.getUser();
            // preprocess the the content of term object
            termObj.setTerm(preprocess(termObj.getTerm()));
            termObj.setAlias(preprocess(termObj.getAlias()));
            filteredList.add(new OatTerm(user, termObj));
        }
        return filteredList; 
    }
    
    private static String [] preprocess(String[] termArray) {
        int N = termArray.length;
        String [] filteredArray = new String [N]; 
        for( int i = 0; i < N; i++) {
            filteredArray[i] = preprocess(termArray[i]);
            
        }
        return filteredArray;
        
    }
    
     
    private static String preprocess(String term) {
         term = term.replaceAll("[^a-zA-Z ]", "");
         List<String> stemedString = stemmer.lemmatize(term);
         stemedString.removeAll(stopwords);
         String result = stemedString.stream().collect(Collectors.joining(" "));
         return result;
    }
     
    
}
 
