package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Klienci;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class KlienciDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Klienci klienci) {
		em.persist(klienci);
	}

	public Klienci merge(Klienci klienci) {
		return em.merge(klienci);
	}

	public void remove(Klienci klienci) {
		em.remove(em.merge(klienci));
	}

	public Klienci find(Object id) {
		return em.find(Klienci.class, id);
	}
	
	public List<Klienci> getFullList() {
		List<Klienci> list = null;

		Query query = em.createQuery("select p from Klienci p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


}
