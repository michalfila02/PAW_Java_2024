package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Wypozyczalnia;
import com.jsf.entities.Wypozyczalnie;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class WypozyczalnieDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Wypozyczalnie wypozyczalnie) {
		em.persist(wypozyczalnie);
	}

	public Wypozyczalnie merge(Wypozyczalnie wypozyczalnie) {
		return em.merge(wypozyczalnie);
	}

	public void remove(Wypozyczalnie wypozyczalnie) {
		em.remove(em.merge(wypozyczalnie));
	}

	public Wypozyczalnie find(Object id) {
		return em.find(Wypozyczalnie.class, id);
	}

	public List<Wypozyczalnie> getFullList() {
		List<Wypozyczalnie> list = null;

		Query query = em.createQuery("select p from Wypozyczalnie p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
