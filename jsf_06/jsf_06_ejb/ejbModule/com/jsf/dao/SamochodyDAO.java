package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Role;
import com.jsf.entities.Samochody;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class SamochodyDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Samochody samochody) {
		em.persist(samochody);
	}

	public Samochody merge(Samochody samochody) {
		return em.merge(samochody);
	}

	public void remove(Samochody samochody) {
		em.remove(em.merge(samochody));
	}

	public Samochody find(Object id) {
		return em.find(Samochody.class, id);
	}

	public List<Samochody> getFullList() {
		List<Samochody> list = null;

		Query query = em.createQuery("select p from Samochody p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}

