package owlapi_samplecode;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class ReadOntology {

	public ReadOntology() {

	}

	public OWLOntology ReadOntologyFromFile(File file) {

		// creating a simple ontology manager
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		// load the ontology
		OWLOntology localOntology = null;
		try {
			localOntology = manager.loadOntologyFromOntologyDocument(file);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}

		return localOntology;

	}
	
	public OWLDataFactory getDataFactory(File file) {

		// creating a simple ontology manager
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		// load the data factory
		OWLDataFactory factory = manager.getOWLDataFactory();


		return factory;

	}

	public OWLOntologyFormat convertOntology(OWLOntology localOntology,
			OWLOntologyManager manager) {

		/***
		 * input: OWLOntology, OWLOntologyManager output: OWLOntology converts
		 * output: OWLOntologyFormat the ontology format into RDF or any other
		 * format
		 ***/

		// Get the ontology format ; in our case it's normally OWL/XML
		OWLOntologyFormat newFormat = null;

		try {

			OWLOntologyFormat format = manager.getOntologyFormat(localOntology);

			System.out.println("current format: " + format);

			// save the file into RDF/XML format

			RDFXMLOntologyFormat rdfxmlFormat = new RDFXMLOntologyFormat();

			manager.saveOntology(localOntology, rdfxmlFormat);

			newFormat = manager.getOntologyFormat(localOntology);

			System.out.println("converted the ontology into: " + newFormat);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return newFormat;

	}
	
	public IRI getOntologyIRI(OWLOntology localOntology){
		/***
		 * extract the ontology IRI
		 ***/
		return localOntology.getOntologyID().getOntologyIRI();
	}
	

}
