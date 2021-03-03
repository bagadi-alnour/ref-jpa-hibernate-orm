package com.cda.jee.service;

import java.util.List;

import com.cda.jee.exception.PersonneIntrouvableException;
import com.cda.jee.model.Personne;

public interface IPersonneService {

	List<Personne> getAll();
	
	Personne getById(int id) throws PersonneIntrouvableException;

	void update(Personne vPersonne) throws PersonneIntrouvableException;

	void deleteById(int id) throws PersonneIntrouvableException;

	void add(Personne vPersonne);

}
