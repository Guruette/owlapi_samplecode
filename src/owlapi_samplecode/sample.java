package owlapi_samplecode;

import java.io.File;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class sample {

	public sample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		File file = new File("Ontology" + File.separator + "family.owl");
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		// load the ontology
		OWLOntology localOntology = null;
		try {
			localOntology = manager.loadOntologyFromOntologyDocument(file);
			System.out.println("read");
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}
		
		Set<OWLNamedIndividual> inds=localOntology.getIndividualsInSignature();
		for (OWLNamedIndividual ind: inds){
			System.out.println(ind.getObjectPropertyValues(localOntology));
		}

	}

}
