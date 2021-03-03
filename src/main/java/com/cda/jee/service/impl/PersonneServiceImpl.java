package com.cda.jee.service.impl;

import java.util.List;

import com.cda.jee.dao.IDao;
import com.cda.jee.dao.impl.PersonneDaoImpl;
import com.cda.jee.exception.PersonneIntrouvableException;
import com.cda.jee.model.Personne;
import com.cda.jee.service.IPersonneService;

public class PersonneServiceImpl implements IPersonneService {

	private IDao<Personne> personneDao;
	
	public PersonneServiceImpl() {
		this.personneDao = new PersonneDaoImpl();
	}
	
	@Override
	public List<Personne> getAll() {
		return this.personneDao.getAll();
	}
	
	@Override
	public Personne getById(int id) throws PersonneIntrouvableException {
		return this.personneDao.getById(id)
				.orElseThrow(PersonneIntrouvableException::new);
	}

	@Override
	public void update(Personne vPersonne) throws PersonneIntrouvableException {
		this.personneDao.getById(vPersonne.getId())
		.orElseThrow(PersonneIntrouvableException::new);
		this.personneDao.update(vPersonne);
	}

	@Override
	public void deleteById(int id) throws PersonneIntrouvableException {
		this.personneDao.getById(id)
		.orElseThrow(PersonneIntrouvableException::new);
		this.personneDao.deleteById(id);
	}

	@Override
	public void add(Personne vPersonne) {
		this.personneDao.add(vPersonne);
		
	}


}
