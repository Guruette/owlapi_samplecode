package test;

import static org.junit.Assert.*;

import owlapi_samplecode.*;

import java.io.File;

import org.junit.Test;

//testing the class with similar name

public class ReadOntologyTest {

	@Test
	public void ReadingOntology() {

		// calling the class with an ontology file
		File file = new File("Ontology" + File.separator + "pizza.owl");
		ReadOntology reading = new ReadOntology();

		boolean res = false;

		// testing if we can read file
		res = reading.ReadOntologyFromFile(file);
		assertEquals(res, true);


	}

}
