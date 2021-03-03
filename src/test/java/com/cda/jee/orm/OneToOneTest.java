//package com.cda.jee.orm;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//import com.cda.jee.dao.IDao;
//import com.cda.jee.dao.impl.PersonneDaoImpl;
//import com.cda.jee.model.Adresse;
//import com.cda.jee.model.Personne;
//
//@TestMethodOrder(OrderAnnotation.class)
//public class OneToOneTest {
//
//	static IDao<Personne> personneDao;
//	
//	@BeforeAll
//	static void init() {
//		personneDao = new PersonneDaoImpl();
//	}
//	
//	@Test
//	@Order(1)
//	void test_convert() {
//		Adresse adresse = new Adresse();
//		adresse.setRue("Lyon");
//		adresse.setCodePostal("13015");
//		adresse.setVille("Marseille");
//		
//		Personne personne = new Personne();
//		personne.setAdresse(adresse);
//		personne.setNom("toto");
//		personne.setPrenom("titi");
//		personneDao.add(personne);
//	}
//}
