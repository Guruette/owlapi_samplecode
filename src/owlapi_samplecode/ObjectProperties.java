package owlapi_samplecode;

import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

public class ObjectProperties {

	public boolean individualOP(OWLOntology localOntology) {
		/***
		 * extracting all object properties among individuals
		 */

		boolean res = false;
		Set<OWLNamedIndividual> inds = localOntology
				.getIndividualsInSignature();
		for (OWLNamedIndividual ind : inds) {
			if (!ind.getObjectPropertyValues(localOntology).isEmpty())
				res = true;
		}

		return res;
	}

	public boolean individualOP(OWLOntology localOntology,
			OWLDataFactory factory) {
		/***
		 * extracting object properties among specified property
		 */
		boolean res = false;
		Set<OWLNamedIndividual> inds = localOntology
				.getIndividualsInSignature();
		for (OWLNamedIndividual ind : inds) {

			if (!ind.getObjectPropertyValues(factory
					.getOWLObjectProperty(IRI.create("http://www.co-ode.org/roberts/family-tree.owl#hasMother")),
					localOntology).isEmpty())
				res = true;
		}

		return res;
	}

}
