package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;
import jakarta.inject.Inject;

import com.jsf.dao.KlienciDAO;
import com.jsf.entities.Klienci;

@Named
@RequestScoped

public class KlienciK implements Serializable {
    
	private static final String PAGE_PERSON_EDIT = null;
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nazwisko;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	KlienciDAO klienciDAO;
		
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public List<Klienci> getFullList(){
		return klienciDAO.getFullList();
	}

	public List<Klienci> getList(){
		List<Klienci> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwisko != null && nazwisko.length() > 0){
			searchParams.put("nazwisko", nazwisko);
		}
		
		//2. Get list
		list = klienciDAO.getList(searchParams);
		
		return list;
	}

	public String newKlienci(){
		Klienci klienci = new Klienci();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash	
		flash.put("klienci", klienci);
		
		return PAGE_PERSON_EDIT;
	}

	public String editPerson(Klienci klienci){
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash 
		flash.put("klienci", klienci);
		
		return PAGE_PERSON_EDIT;
	}

	public String deletePerson(Klienci klienci){
		klienciDAO.remove(klienci);
		return PAGE_STAY_AT_THE_SAME;
	}
    
    
    
}