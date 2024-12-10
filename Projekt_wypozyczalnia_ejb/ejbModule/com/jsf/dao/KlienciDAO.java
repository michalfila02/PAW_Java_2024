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
	
	public List<Klienci> getList(Map<String, Object> searchParams) {
		List<Klienci> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from Klienci p ";
		String where = "";
		String orderby = "order by p.nazwisko asc, p.imię";

		// search for surname
		String nazwisko = (String) searchParams.get("nazwisko");
		if (nazwisko != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.nazwisko like :nazwisko ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (nazwisko != null) {
			query.setParameter("nazwisko", nazwisko+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


}
