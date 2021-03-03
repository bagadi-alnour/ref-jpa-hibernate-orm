package com.cda.jee.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cda.jee.dao.IDao;
import com.cda.jee.dao.tools.HibernateUtil;
import com.cda.jee.exception.ErreurTechnique;

public abstract class GenericDao<T> implements IDao<T>{
	protected Session session;
	private Class<T> entityClass;

	public GenericDao(Class<T> entity) {
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.entityClass = entity;
	}

	@Override
	public void add(T obj) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ErreurTechnique(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T obj) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			obj = (T)this.session.merge(obj);
			this.session.update(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public void deleteById(int id) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.delete(this.session.get(this.entityClass, id));
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ErreurTechnique(e);
		}
	}
	
	@Override
	public Optional<T> getById(int id) {
		return Optional.ofNullable(this.session.get(this.entityClass, id));
	}

	@Override
	public List<T> getAll() {
		session.clear();
		return session.createQuery("from "+this.entityClass.getName(), this.entityClass).list();
	}
}
