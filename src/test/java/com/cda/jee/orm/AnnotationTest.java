package com.cda.jee.orm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cda.jee.dao.IDao;
import com.cda.jee.dao.impl.PersonneDaoImpl;
import com.cda.jee.model.Adresse;
import com.cda.jee.model.Personne;
import com.cda.jee.model.Sport;

@TestMethodOrder(OrderAnnotation.class)
public class AnnotationTest {

	static IDao<Personne> personneDao;
	
	@BeforeAll
	static void init() {
		personneDao = new PersonneDaoImpl();
	}
	
	@Test
	@Order(1)
	void test_many_to_many() {
		Personne p1 = new Personne();
		p1.setNom("Voight");
		p1.setPrenom("Bill");

		Personne p2 = new Personne();
		p2.setNom("Bob");
		p2.setPrenom("Joe");

		Adresse a1 = new Adresse();
		a1.setRue("Estaque");
		a1.setCodePostal("13016");
		a1.setVille("Marseille");
		a1.setPersonne(p1);
		
//		Adresse a2 = new Adresse();
//		a2.setRue("une autre adresse");
//		a2.setCodePostal("13016");
//		a2.setVille("Paris");
//		a2.setPersonne(p2);
		
		Sport s1 = new Sport();
		Sport s2 = new Sport();
		Sport s3 = new Sport();
		s1.setNom("football");
		s2.setNom("tennis");
		s3.setNom("box");
		s1.setType("collectif");
		s2.setType("individuel");
		s3.setType("collectif ou individuel");
		
		p1.getSports().add(s1);
		p1.getSports().add(s3);
		p1.getAdresses().add(a1);
		
		p2.getSports().add(s1);
		p2.getSports().add(s2);
		p2.getSports().add(s3);
//		p2.getAdresses().add(a2);
		
		personneDao.add(p1);
		personneDao.add(p2);
	}
}
