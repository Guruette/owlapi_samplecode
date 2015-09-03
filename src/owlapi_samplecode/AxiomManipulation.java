package owlapi_samplecode;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLLogicalAxiom;
import org.semanticweb.owlapi.model.OWLOntology;

public class AxiomManipulation {

	// reading axioms
	public Set<OWLAxiom> ReadingAxioms(OWLOntology localOntology) {

		Set<OWLAxiom> axioms = localOntology.getAxioms();
		for (OWLAxiom axiom : axioms)
			System.out.println(axiom);

		return axioms;
	}

	// reading logical axioms
	public Set<OWLLogicalAxiom> ReadingLogicalAxioms(OWLOntology localOntology) {

		Set<OWLLogicalAxiom> axioms = localOntology.getLogicalAxioms();
		for (OWLAxiom axiom : axioms)
			System.out.println(axiom);

		return axioms;
	}

	// get ontology annotation 
	public Set<OWLAnnotation> annotationExtraction(OWLOntology localOntology) {

		Set<OWLAnnotation> annotations = localOntology.getAnnotations();

		for (OWLAnnotation annotation : annotations) {
			String temp = annotation.getProperty().getIRI().getFragment()
					+ ": " + annotation.getValue();
			System.out.println(temp);

		}

		return annotations;
	}
}
