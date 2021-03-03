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

@TestMethodOrder(OrderAnnotation.class)
public class OneToManyTest {

	static IDao<Personne> personneDao;
	
	@BeforeAll
	static void init() {
		personneDao = new PersonneDaoImpl();
	}
	
	@Test
	@Order(1)
	void test_convert() {
		Personne p1 = new Personne();

		Adresse a1 = new Adresse();
		a1.setRue("Estaque");
		a1.setCodePostal("13016");
		a1.setVille("Marseille");
		a1.setPersonne(p1);
		
		Adresse a2 = new Adresse();
		a2.setRue("Merlan");
		a2.setCodePostal("13013");
		a2.setVille("Marseille");
		a2.setPersonne(p1);
		
		p1.setNom("Wick");
		p1.setPrenom("John");
		p1.getAdresses().add(a1);
		p1.getAdresses().add(a2);
		
		personneDao.add(p1);
	}
}
