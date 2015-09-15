package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import owlapi_samplecode.ReadOntology;

//testing the class with similar name

public class ReadOntologyTest {

	public ReadOntology reading = null;

	@Before
	public void initialize() {
		reading = new ReadOntology();
	}

	@Test
	public void ReadingOntologyTest() {

		// calling the class with an ontology file
		File file = new File("Ontology" + File.separator + "pizza.owl");

		// testing if we can read file
		OWLOntology res = reading.ReadOntologyFromFile(file);
		assertTrue(!res.isEmpty());

	}

	@Test
	public void getDataFactoryTest() {
		File file = new File("Ontology" + File.separator + "pizza.owl");

		OWLDataFactory factory = reading.getDataFactory(file);

		assertTrue(!factory.getOWLVersionInfo().getIRI().getFragment()
				.isEmpty());
	}

	@Test
	public void convertOntologyTest() {

		File file = new File("Ontology" + File.separator + "pizza1.owl");

		OWLOntology localOntology = reading.ReadOntologyFromFile(file);
		OWLOntologyManager manager = localOntology.getOWLOntologyManager();
		OWLOntologyFormat format = reading.convertOntology(localOntology,
				manager);

		assertEquals(format.toString(), "RDF/XML");

	}

}
