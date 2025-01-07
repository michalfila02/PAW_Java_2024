package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the wypozyczalnie database table.
 * 
 */
@Entity
@NamedQuery(name="Wypozyczalnie.findAll", query="SELECT w FROM Wypozyczalnie w")
public class Wypozyczalnie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nazwa;

	private String miasto;

	private int nr_ulicy;

	private String telefon_kontaktowy;

	private String ulica;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="wypozyczalnie")
	private List<Role> roles;

	//bi-directional many-to-one association to Samochody
	@OneToMany(mappedBy="wypozyczalnie")
	private List<Samochody> samochodies;

	public Wypozyczalnie() {
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public int getNr_ulicy() {
		return this.nr_ulicy;
	}

	public void setNr_ulicy(int nr_ulicy) {
		this.nr_ulicy = nr_ulicy;
	}

	public String getTelefon_kontaktowy() {
		return this.telefon_kontaktowy;
	}

	public void setTelefon_kontaktowy(String telefon_kontaktowy) {
		this.telefon_kontaktowy = telefon_kontaktowy;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setWypozyczalnie(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setWypozyczalnie(null);

		return role;
	}

	public List<Samochody> getSamochodies() {
		return this.samochodies;
	}

	public void setSamochodies(List<Samochody> samochodies) {
		this.samochodies = samochodies;
	}

	public Samochody addSamochody(Samochody samochody) {
		getSamochodies().add(samochody);
		samochody.setWypozyczalnie(this);

		return samochody;
	}

	public Samochody removeSamochody(Samochody samochody) {
		getSamochodies().remove(samochody);
		samochody.setWypozyczalnie(null);

		return samochody;
	}

}