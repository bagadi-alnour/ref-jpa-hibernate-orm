package com.cda.jee.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

	List<T> getAll();

	Optional<T> getById(int id);

	void update(T o);

	void deleteById(int id);

	void add(T o);

}
