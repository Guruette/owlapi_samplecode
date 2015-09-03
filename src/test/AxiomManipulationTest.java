package test;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLLogicalAxiom;
import org.semanticweb.owlapi.model.OWLOntology;

import owlapi_samplecode.AxiomManipulation;
import owlapi_samplecode.ReadOntology;

public class AxiomManipulationTest {

	// OWL variables
	private OWLOntology localOntology = null;

	@Before
	public void initialise() {
		// calling the class with an ontology file
		File file = new File("Ontology" + File.separator + "lemon.rdf");
		ReadOntology reading = new ReadOntology();
		setLocalOntology(reading.ReadOntologyFromFile(file));

	}

	@Test
	public void ReadingAxiomsTest() {
		AxiomManipulation axMan= new AxiomManipulation();
		Set<OWLAxiom> axioms=axMan.ReadingAxioms(getLocalOntology());
		
		assertFalse(axioms.isEmpty());

	}
	
	@Test
	public void ReadingLogicalAxiomsTest() {
		AxiomManipulation axMan= new AxiomManipulation();
		Set<OWLLogicalAxiom> axioms=axMan.ReadingLogicalAxioms(getLocalOntology());
		
		assertFalse(axioms.isEmpty());

	}
	
	@Test
	public void annotationExtractionTest(){
		AxiomManipulation axMan= new AxiomManipulation();
		Set<OWLAnnotation> annotations=axMan.annotationExtraction(localOntology);
		
		assertFalse(annotations.isEmpty());
		
	}

	// getter and setter methods
	public OWLOntology getLocalOntology() {
		return localOntology;
	}

	public void setLocalOntology(OWLOntology localOntology) {
		this.localOntology = localOntology;
	}

}
