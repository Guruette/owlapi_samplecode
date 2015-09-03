package owlapi_samplecode;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
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

}
