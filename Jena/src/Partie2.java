import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class Partie2 {
	
	public static void main(String[] args) throws IOException {

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
		
			/*
				Ecriture du code RDF dans la console.
				Ecriture dans un fichier à faire !
			*/

			m.write(System.out, "RDF/XML-ABBREV");
			
			
		



			//Génération du RDF sur la base de LOV (Réutilisation des classes et propriétés) 
			
		


			
			
		 Model mLOV = ModelFactory.createDefaultModel();
		
		mLOV.setNsPrefix( "rdf", RDF.getURI() );
		mLOV.setNsPrefix( "rdfs", RDFS.getURI());
		mLOV.setNsPrefix( "mo", "http://pearl.org/ontology/mo#" );
		mLOV.setNsPrefix( "qqpf", "http://quelquepart.fake/qqpf-schema#" );
		mLOV.setNsPrefix( "dbp", "http://dbpedia.org/page/#" );
		mLOV.setNsPrefix( "foaf", "http://xmlns.com/foaf/0.1/#" );
		mLOV.setNsPrefix( "keys", "http://purl.org/NET/c4dm/keys.owl#" );
		mLOV.setNsPrefix( "event", "http://purl.org/NET/c4dm/event.owl#" );
		
		String mo = "http://pearl.org/ontology/mo";
		String dbp = "http://dbpedia.org/page/";
		String foaf = "http://xmlns.com/foaf/0.1/";
		String event = "http://purl.org/NET/c4dm/event.owl";
		String keys = "http://purl.org/NET/c4dm/keys.owl";
		
		//*************************************RESSOURCES-RESOURCES******************************************
		
		//Création ressources de classes connues-Creating known classes resources.
		 
		Resource MusicArtist_CLASS = m.createResource(dbp+"#MusicArtist");
		Resource Agent_CLASS = m.createResource(foaf+"#Agent",RDFS.Class);
		Resource MusicalWork_CLASS = m.createResource(dbp+"#MusicalWork");
		Resource Movement_CLASS = m.createResource(dbp+"#Movement");
		Resource Event_CLASS = m.createResource(event+"#Event");
		Resource Performance_CLASS = m.createResource(dbp+"#Performance");
		Resource Composition_CLASS = m.createResource(dbp+"#Composition");
		Resource Key_CLASS = m.createResource(mo+"#Key");
		Resource Genre_CLASS = m.createResource(mo+"#Genre");
		
		//Création ressources d'instances-Creating instance resources.
		 
		
		Resource LOV_claudio_abbado = m.createResource(dbp+"#Claudio_Abbado");
		Resource LOV_andante_cantabile = m.createResource(dbp+"#Andante_Cantabile");
		Resource LOV_menuetto = m.createResource(dbp+"#Menuetto");
		Resource LOV_molto_allegro = m.createResource(dbp+"#Molto_Allegro");
		Resource LOV_allegro_vivace= m.createResource(dbp+"#Allegro_Vivace");
		Resource LOV_C_major = m.createResource(dbp+"#C_major");
		Resource LOV_jupiter = m.createResource(dbp+"#Symphony_No._41_(Mozart)");
		Resource LOV_mozart = m.createResource(dbp+"#Wolfgang_Amadeus_Mozart");
		Resource LOV_symphony = m.createResource(dbp+"#Symphony"); 
		Resource LOV_composition_Jupiter = m.createResource(qqpf+"#Composition_Jupiter");
		Resource LOV_orchestre_londres = m.createResource(dbp+"#London_Symphony_Orchestra");
		Resource LOV_enregistrement_Jupiter = m.createResource(qqpf+"#Enregistrement_Jupiter");
		
		//*************************************Propriétés-Properties******************************************
		
		Property mo_title = m.createProperty(mo,"#title");
		Property mo_genre = m.createProperty(mo,"#genre");
		Property mo_composed_in = m.createProperty(mo,"#composed_in");
		Property mo_key= m.createProperty(mo,"#key");
		Property mo_composer = m.createProperty(mo,"#composer");
		Property mo_produced_work = m.createProperty(mo,"#produced_work");
		Property mo_performance_of = m.createProperty(mo,"#performance_of");
		Property mo_performer = m.createProperty(mo,"#performer");
		Property mo_movement = m.createProperty(mo,"#movement");
		Property mo_movement_number = m.createProperty(mo,"#movement_number");
		Property mo_conductor = m.createProperty(mo,"#conductor");
		Property keys_key_name= m.createProperty(mo,"#key_name");
		
		
		
		//*************************************Liaison resources et propriétés-Binding resources with properties******************************************
		
		//Hiérarchie des classes
		
		mLOV.add(MusicArtist_CLASS,RDFS.subClassOf,Agent_CLASS)
		.add(Movement_CLASS,RDFS.subClassOf,MusicalWork_CLASS)
		.add(Composition_CLASS,RDFS.subClassOf,Event_CLASS);
		
		
		
		mLOV.add(LOV_orchestre_londres, RDF.type, MusicArtist_CLASS)
		.add(LOV_mozart, RDF.type, MusicArtist_CLASS)
		.add(LOV_claudio_abbado, RDF.type, MusicArtist_CLASS)
		.add(LOV_allegro_vivace, mo_movement_number, "4")
		.add(LOV_allegro_vivace, RDF.type, Movement_CLASS)
		.add(LOV_andante_cantabile, mo_movement_number, "3")
		.add(LOV_andante_cantabile, RDF.type, Movement_CLASS)
		.add(LOV_menuetto, mo_movement_number, "2")
		.add(LOV_menuetto, RDF.type, Movement_CLASS)
		.add(LOV_molto_allegro, mo_movement_number, "1")
		.add(LOV_molto_allegro, RDF.type, Movement_CLASS)
		.add(LOV_C_major, keys_key_name, "C-Ut majeur")
		.add(LOV_C_major, RDF.type, Key_CLASS)
		.add(LOV_jupiter, RDF.type, MusicalWork_CLASS)
		.add(LOV_jupiter, mo_composed_in , "1980")
		.add(LOV_jupiter, mo_title, "Jupiter")
		.add(LOV_jupiter, RDFS.label, "Symphonie 41")
		.add(LOV_jupiter, mo_key , LOV_C_major)
		.add(LOV_jupiter, mo_movement , LOV_molto_allegro)
		.add(LOV_jupiter, mo_movement , LOV_menuetto)
		.add(LOV_jupiter, mo_movement , LOV_andante_cantabile)
		.add(LOV_jupiter, mo_movement , LOV_allegro_vivace)
		.add(LOV_symphony, RDF.type, Genre_CLASS)
		.add(LOV_composition_Jupiter, mo_genre, LOV_symphony)
		.add(LOV_composition_Jupiter, mo_composer, LOV_mozart)
		.add(LOV_composition_Jupiter, mo_produced_work, LOV_jupiter)
		.add(LOV_composition_Jupiter, RDF.type, Composition_CLASS)
		.add(LOV_enregistrement_Jupiter, mo_performer, LOV_orchestre_londres)
		.add(LOV_enregistrement_Jupiter, mo_performance_of, LOV_jupiter)
		.add(LOV_enregistrement_Jupiter, mo_conductor, LOV_claudio_abbado)
		.add(LOV_enregistrement_Jupiter, RDF.type, Performance_CLASS)
		.add(LOV_jupiter, est_compose_par, mozart)
		.add(LOV_jupiter, enregistre_par, orchestre_londres);
	
		
			/*
				Ecriture du code RDF dans la console.
				Ecriture dans un fichier à faire !
			*/

		System.out.println("---------------------------------------SCHEMA LOV-----------------------------------");
			
		
		FileWriter out = new FileWriter("RDF-XML.rdf");
		mLOV.write(out, "RDF/XML-ABBREV");
		out = new FileWriter("Turtle.ttl");
		mLOV.write(out, "Turtle");
		out = new FileWriter("RDF-JSON.json");
		mLOV.write(out, "RDF/JSON");
		out = new FileWriter("N3.n3");
		mLOV.write(out, "N3");
		out = new FileWriter("N-Triples.nt");
		mLOV.write(out, "N-TRIPLES");
			 
	
	}

}
