package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLLogicalAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import owlapi_samplecode.AxiomManipulation;
import owlapi_samplecode.ReadOntology;

public class AxiomManipulationTest {

	// OWL variables
	private OWLOntology localOntology = null;
	private OWLOntologyManager manager =null;

	@Before
	public void initialise() {
		// calling the class with an ontology file
		File file = new File("Ontology" + File.separator + "lemon.rdf");
		ReadOntology reading = new ReadOntology();
		setLocalOntology(reading.ReadOntologyFromFile(file));
		setManager(OWLManager.createOWLOntologyManager());

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
		Set<String> annotations=axMan.annotationExtraction(localOntology);
		
		assertFalse(annotations.isEmpty());
		
	}
	
	@Test
	public void classAnnotationTest(){
		AxiomManipulation axMan= new AxiomManipulation();
		Set<String> annotations=axMan.classAnnotation(localOntology);
		
		assertFalse(annotations.isEmpty());
		
	}
	
	@Test
	public void addIndividualTest(){
		AxiomManipulation axMan= new AxiomManipulation();
		// generate IRI
		ReadOntology reading = new ReadOntology();
		IRI base= reading.getOntologyIRI(getLocalOntology());
		IRI ind_iri = IRI.create(base+"#mexican_pizza");
		OWLDataFactory df= getManager().getOWLDataFactory();
		OWLOntologyManager tempManager= axMan.addIndividual(getLocalOntology(), getManager(), df, 
				base+"#mexican_pizza");
		
		assertTrue(tempManager.getOWLDataFactory().getOWLNamedIndividual(ind_iri).isNamed());
		
	}

	// getter and setter methods
	public OWLOntology getLocalOntology() {
		return localOntology;
	}

	public void setLocalOntology(OWLOntology localOntology) {
		this.localOntology = localOntology;
	}

	public OWLOntologyManager getManager() {
		return manager;
	}

	public void setManager(OWLOntologyManager manager) {
		this.manager = manager;
	}

}
