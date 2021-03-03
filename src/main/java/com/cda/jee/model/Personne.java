package com.cda.jee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(
		name = "sportsTypesParPersonnePrenom", 
		query = "select s.type from Personne p join p.sports s where p.prenom = :prenom"
		)
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "personne", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Adresse> adresses = new ArrayList<Adresse>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Sport> sports = new ArrayList<Sport>();
}
