package com.cda.jee.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cda.jee.dao.IDao;
import com.cda.jee.dao.impl.PersonneDaoImpl;
import com.cda.jee.dao.tools.HibernateUtil;
import com.cda.jee.model.Adresse;
import com.cda.jee.model.Personne;
import com.cda.jee.model.Sport;

@TestMethodOrder(OrderAnnotation.class)
public class HqlTest {

	@BeforeAll
	static void init() {
		IDao<Personne> personneDao = new PersonneDaoImpl();
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

		personneDao.add(p1);
		personneDao.add(p2);
	}

	@Test
	@Order(1)
	void test_sql_query() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		String sqlRequete = "from Personne";
		Query<Personne> query = session.createQuery(sqlRequete, Personne.class);
		List<Personne> personnes = query.list();

		for (Personne personne : personnes) {
			System.err.println(" - "+personne.getId()+" "+personne.getNom()+" "+personne.getPrenom());
		}

		String typeSportPratiqueParBillRequeteStr = "select s.type from Personne p join p.sports s where p.prenom = 'Bill'";
		Query<String> typeSportPratiqueParBillRequete =  session.createQuery(typeSportPratiqueParBillRequeteStr, String.class);
		List<String> typesSportsArr = typeSportPratiqueParBillRequete.list();

		for (String unTypeSport : typesSportsArr) {
			System.err.println(" - un type de sport "+unTypeSport);
		}
		
		transaction.commit();

		session.close();
		sessionFactory.close();
	}
}
