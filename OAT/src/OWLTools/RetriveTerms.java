package OWLTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.semanticweb.elk.owlapi.ElkReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.parameters.Imports;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import uk.ac.manchester.cs.owl.owlapi.OWLAnnotationAssertionAxiomImpl;

public class RetriveTerms {
    public void retriveLabel(IRI iri) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        // Let's load an ontology from the web
        // IRI iri = IRI.create("http://www.ifomis.org/vdot/vdot_all.owl");
        OWLOntology pizzaOntology = manager.loadOntologyFromOntologyDocument(iri);
        Set<OWLOntology> allOntologies = manager.getImportsClosure(pizzaOntology);
        OWLReasonerFactory reasonerFactory = new ElkReasonerFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(pizzaOntology);
        Set<OWLClass> clazz = pizzaOntology.getClassesInSignature(Imports.INCLUDED);
        //Set<OWLAxiom> axiom = pizzaOntology.getAxioms(Imports.INCLUDED);
        for (OWLClass ow : clazz) {
            IRI cIRI = ow.getIRI();
            for (OWLOntology ontology : allOntologies) {
                List<OWLAnnotation> list = new ArrayList<OWLAnnotation>();
                if ( ontology.getAnnotationAssertionAxioms(cIRI).size() == 0) {
                    continue;
                }
                    for (OWLAnnotationAssertionAxiom a : ontology.getAnnotationAssertionAxioms(cIRI)) {
                        OWLAnnotation anot = a.getAnnotation();
                        list.add(anot);
                        
                        
                        
                       // if (anot.getProperty().toString().contains("hasSynonym") ) {
                         //   String synonym = anot.getValue().toString();
                           // System.out.println(ow + "  Synonym : " + synonym );
    
                      //  }
                        
                    }
                
                System.out.println(ow + " ---------Annotation-------- " + list);

          
                
        }
    
    
        }
    }
     
}
