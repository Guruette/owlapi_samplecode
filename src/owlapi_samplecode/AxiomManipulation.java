package owlapi_samplecode;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
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
	public Set<String> annotationExtraction(OWLOntology localOntology) {
		
		/*** 
		 * input: OWLOntology
		 * output: annotation string
		 * this method extracts the ontology's annotation
		 ***/

		Set<OWLAnnotation> annotations = localOntology.getAnnotations();
		
		Set<String> ontologyAnnotations = new HashSet<String>();

		for (OWLAnnotation annotation : annotations) {
			String temp = annotation.getProperty().getIRI().getFragment()
					+ ": " + annotation.getValue();
			ontologyAnnotations.add(temp);
		}

		return ontologyAnnotations;
	}

	// get class annotation
	public Set<String> classAnnotation(OWLOntology localOntology) {
		
		/*** 
		 * input: OWLOntology
		 * output: class annotation string
		 * this method extracts annotations from classes
		 * replacing getClassesInSignature with getIndividualsInSingnature or properties,
		 * will result in annotation extraction from other modelling elements
		 ***/

		Set<String> classAnnotations = new HashSet<String>();

		for (OWLClass owl_class : localOntology.getClassesInSignature()) {

			for (OWLAnnotationAssertionAxiom annotations : owl_class
					.getAnnotationAssertionAxioms(localOntology)) {
				String temp = "Class: " + owl_class + " "
						+ annotations.getProperty().getIRI().getFragment()
						+ ": " + annotations.getValue();
				classAnnotations.add(temp);
			}

		}

		return classAnnotations;
	}
}
