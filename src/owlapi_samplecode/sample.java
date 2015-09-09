package owlapi_samplecode;

import java.io.File;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.EntityType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class sample {

	public sample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		File file = new File("Ontology" + File.separator + "pizza1.owl");
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory df= manager.getOWLDataFactory();

		// load the ontology
		OWLOntology localOntology = null;
		try {
			localOntology = manager.loadOntologyFromOntologyDocument(file);
			System.out.println("read");
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}
		

		

	}
}
