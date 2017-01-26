import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class Partie2 {
	
	public static void main(String[] args) {

		Model m = ModelFactory.createDefaultModel();
		//setNsPrefix définit un préfix personnalisé (rdfs,qqpf...)
		
		m.setNsPrefix( "rdf", RDF.getURI() );
		m.setNsPrefix( "rdfs", RDFS.getURI());
		m.setNsPrefix( "qqpf", "http://quelquepart.fake/qqpf-schema#" );
		

		String qqpf = "http://quelquepart.fake/qqpf-schema";
		
		Property nom_oeuvre = m.createProperty(qqpf,"#nom_oeuvre");
		Property genre_oeuvre = m.createProperty(qqpf,"#genre_oeuvre");
		Property deuxieme_nom_oeuvre = m.createProperty(qqpf,"#deuxieme_nom_oeuvre");
		Property tonalite_oeuvre = m.createProperty(qqpf,"#tonalite_oeuvre");
		Property enregistre_en = m.createProperty(qqpf,"#enregistre_en");
		Property est_compose_par = m.createProperty(qqpf,"#est_compose_par");
		Property enregistre_par = m.createProperty(qqpf,"#enregistre_par");
		Property enregistre_sous_la_direction_de = m.createProperty(qqpf+"#enregister_sous_la_direction_de");
		Property contient = m.createProperty(qqpf,"#contient");
		Property elem1 = m.createProperty(RDF.getURI(),"_1");
		Property elem2 = m.createProperty(RDF.getURI(),"_2");
		Property elem3 = m.createProperty(RDF.getURI(),"_3");
		Property elem4 = m.createProperty(RDF.getURI(),"_4");
		
		//Resource classRdfs = m.createResource(RDFS.Class);
		Resource seq = m.createSeq();
		Resource blank_node= m.createResource();
		Resource orchestre = m.createResource(qqpf+"#Orchestre",RDFS.Class);
		Resource oeuvre = m.createResource(qqpf+"#Oeuvre",RDFS.Class);
		Resource personne = m.createResource(qqpf+"#Personne",RDFS.Class);
		Resource jupiter = m.createResource(qqpf+"#jupiter");
		Resource mozart = m.createResource(qqpf+"#mozart");
		Resource orchestre_londres = m.createResource(qqpf+"#orchestre_symphonique_de_londres");
		Resource claudio_abbado = m.createResource(qqpf+"#claudio_abbado");
		Resource andante_cantabile = m.createResource(qqpf+"#andante_cantabile");
		Resource menuetto = m.createResource(qqpf+"#menuetto");
		Resource molto_allegro = m.createResource(qqpf+"#molto_allegro");
		Resource allegro_vivace= m.createResource(qqpf+"#allegro_vivace");
		
		
		m//.add(orchestre, RDF.type, classRdfs)
		.add(orchestre_londres, RDF.type, orchestre)
		//.add(personne, RDF.type, classRdfs)
		.add(mozart, RDF.type, personne)
		.add(claudio_abbado, RDF.type, personne)
		//.add(oeuvre, RDF.type, classRdfs)
		.add(jupiter, RDF.type, oeuvre)
		.add(jupiter, nom_oeuvre, "Jupiter")
		.add(jupiter, genre_oeuvre, "Symphony")
		.add(jupiter, deuxieme_nom_oeuvre, "41 Symphony")
		.add(jupiter, tonalite_oeuvre, "Ut majeur")
		.add(jupiter, enregistre_en, "1980")
		.add(jupiter, contient, blank_node)
		.add(jupiter, enregistre_sous_la_direction_de, claudio_abbado)
		.add(jupiter, est_compose_par, mozart)
		.add(jupiter, enregistre_par, orchestre_londres)
		.add(blank_node,RDF.type, seq)
		.add(blank_node,elem1, allegro_vivace)
		.add(blank_node,elem1, andante_cantabile)
		.add(blank_node,elem1, menuetto)
		.add(blank_node,elem1, molto_allegro)
		.add(allegro_vivace, RDF.type, oeuvre)
		.add(andante_cantabile, RDF.type, oeuvre)
		.add(menuetto, RDF.type, oeuvre)
		.add(molto_allegro, RDF.type, oeuvre);
		
			m.write(System.out, "RDF/XML-ABBREV");
			
			
	}

}
