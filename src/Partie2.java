import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class Partie2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model m = ModelFactory.createDefaultModel();
		String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
		String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
		String qqpf = "http://quelquepart.fake/qqpf-schema#";
		
		Property nom_oeuvre = m.createProperty(qqpf+"nom_oeuvre");
		Property genre_oeuvre = m.createProperty(qqpf+"genre_oeuvre");
		Property deuxieme_nom_oeuvre = m.createProperty(qqpf+"deuxieme_nom_oeuvre");
		Property tonalite_oeuvre = m.createProperty(qqpf+"tonalite_oeuvre");
		Property enregistre_en = m.createProperty(qqpf+"enregistre_en");
		Property est_compose_par = m.createProperty(qqpf+"est_compose_par");
		Property enregistre_par = m.createProperty(qqpf+"enregistre_par");
		Property enregistre_sous_la_direction_de = m.createProperty(qqpf+"enregister_sous_la_direction_de");
		Property contient = m.createProperty(qqpf+"contient");
		Property type = m.createProperty(rdf+"type");
		Property elem1 = m.createProperty(rdf+"elem1");
		Property elem2 = m.createProperty(rdf+"elem2");
		Property elem3 = m.createProperty(rdf+"elem3");
		Property elem4 = m.createProperty(rdf+"elem4");
		
		Resource classRdf = m.createResource(rdfs+"Class");
		Resource seq = m.createResource(rdf+"Seq");
		Resource orchestre = m.createResource(qqpf+"#Orchestre");
		Resource oeuvre = m.createResource(qqpf+"#Oeuvre");
		Resource orchestre_londres = m.createResource(qqpf+"orchestre_symphonique_de_londres");
		Resource mozart = m.createResource(qqpf+"mozart");
		Resource claudio_abbado = m.createResource(qqpf+"claudio_abbado");
		Resource personne = m.createResource(qqpf+"#Personne");
		Resource jupiter = m.createResource(qqpf+"jupiter");
		Resource andante_cantabile = m.createResource(qqpf+"andante_cantabile");
		Resource menuetto = m.createResource(qqpf+"menuetto");
		Resource molto_allegro = m.createResource(qqpf+"molto_allegro");
		Resource allegro_vivace= m.createResource(qqpf+"allegro_vivace");
		
		m.add(orchestre, type, classRdf).add(oeuvre, type, classRdf).add(orchestre_londres, type, orchestre)
		.add(jupiter, type, oeuvre).add(jupiter, enregistre_par, orchestre_londres)
		.add(jupiter, nom_oeuvre, "Jupiter").add(jupiter, genre_oeuvre, "Symphony");
	}

}
