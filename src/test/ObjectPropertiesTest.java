package test;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;

import owlapi_samplecode.ObjectProperties;
import owlapi_samplecode.ReadOntology;

public class ObjectPropertiesTest {

	// OWL variables
	private OWLOntology localOntology = null;
	private OWLDataFactory factory = null;

	@Before
	public void initialise() {
		// calling the class with an ontology file
		File file = new File("Ontology" + File.separator + "family.owl");
		ReadOntology reading = new ReadOntology();
		setLocalOntology(reading.ReadOntologyFromFile(file));

		// introducing the data factory
		factory = reading.getDataFactory(file);

	}
	
	@Test
	public void individualOPTest(){
		ObjectProperties op= new ObjectProperties();
		boolean res= false;
		
		// all annotations
		res= op.individualOP(localOntology);
		assertTrue(res);
		
		// specific annotation
		res= op.individualOP(localOntology, factory);
		assertTrue(res);
		
	}

	// getter and setter methods
	public OWLOntology getLocalOntology() {
		return localOntology;
	}

	public void setLocalOntology(OWLOntology localOntology) {
		this.localOntology = localOntology;
	}

}
