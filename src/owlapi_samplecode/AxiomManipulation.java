package owlapi_samplecode;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.EntityType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLogicalAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

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
		 * input: OWLOntology output: annotation string this method extracts the
		 * ontology's annotation
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
		 * input: OWLOntology output: class annotation string this method
		 * extracts annotations from classes replacing getClassesInSignature
		 * with getIndividualsInSingnature or properties, will result in
		 * annotation extraction from other modelling elements
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

	public OWLOntologyManager addIndividual(OWLOntology localOntology,
			OWLOntologyManager manager, OWLDataFactory df, String ind_iri) {
		/***
		 * This method receives a string, will generate and individual and adds it to the ontology
		 * by replacing the entity type to another e.g. class to add another declaration axiom
		 ***/

		// convert String into OWLEntity
		OWLEntity entity = df.getOWLEntity(EntityType.NAMED_INDIVIDUAL,
				IRI.create(ind_iri));

		// executing addition
		OWLDeclarationAxiom tempAxiom = df.getOWLDeclarationAxiom(entity);
		AddAxiom addAx = new AddAxiom(localOntology, tempAxiom);
		manager.applyChange(addAx);
		
		return manager;
	}
	

}
