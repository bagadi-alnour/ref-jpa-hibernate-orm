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
//import com.cda.jee.model.Personne;
//import com.cda.jee.model.Sport;
//
//@TestMethodOrder(OrderAnnotation.class)
//public class ManyToManyTest {
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
//	void test_many_to_many() {
//		Personne p1 = new Personne();
//		Personne p2 = new Personne();
//		p1.setNom("Voight");
//		p1.setPrenom("Bill");
//		p2.setNom("Bob");
//		p2.setPrenom("Joe");
//		Sport s1 = new Sport();
//		Sport s2 = new Sport();
//		Sport s3 = new Sport();
//		s1.setNom("football");
//		s2.setNom("tennis");
//		s3.setNom("box");
//		s1.setType("collectif");
//		s2.setType("individuel");
//		s3.setType("collectif ou individuel");
//		
//		p1.getSports().add(s1);
//		p1.getSports().add(s3);
//		
//		p2.getSports().add(s1);
//		p2.getSports().add(s2);
//		p2.getSports().add(s3);
//		
//		personneDao.add(p1);
//		personneDao.add(p2);
//	}
//}
