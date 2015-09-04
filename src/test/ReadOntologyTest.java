package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import owlapi_samplecode.ReadOntology;

//testing the class with similar name

public class ReadOntologyTest {

	@Test
	public void ReadingOntologyTest() {

		// calling the class with an ontology file
		File file = new File("Ontology" + File.separator + "pizza.owl");
		ReadOntology reading = new ReadOntology();

		OWLOntology res = null;

		// testing if we can read file
		res = reading.ReadOntologyFromFile(file);
		assertTrue(!res.isEmpty());

	}

	@Test
	public void convertOntologyTest() {

		File file = new File("Ontology" + File.separator + "pizza1.owl");

		ReadOntology reading = new ReadOntology();
		OWLOntology localOntology = reading.ReadOntologyFromFile(file);
		OWLOntologyManager manager = localOntology.getOWLOntologyManager();
		OWLOntologyFormat format = reading.convertOntology(localOntology,
				manager);

		assertEquals(format.toString(), "RDF/XML");

	}

}
