package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the klienci database table.
 * 
 */
@Entity
@NamedQuery(name="Klienci.findAll", query="SELECT k FROM Klienci k")
public class Klienci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_klienta;

	private Timestamp data_utworzenia;

	private Timestamp data_zmiany;

	private String imię;

	private String nazwisko;

	private int pesel;

	private String utworzone_przez;

	private String zmienione_przez;

	//bi-directional many-to-one association to Wypozyczalnia
	@OneToMany(mappedBy="klienci")
	private List<Wypozyczalnia> wypozyczalnias;

	public Klienci() {
	}

	public int getId_klienta() {
		return this.id_klienta;
	}

	public void setId_klienta(int id_klienta) {
		this.id_klienta = id_klienta;
	}

	public Timestamp getData_utworzenia() {
		return this.data_utworzenia;
	}

	public void setData_utworzenia(Timestamp data_utworzenia) {
		this.data_utworzenia = data_utworzenia;
	}

	public Timestamp getData_zmiany() {
		return this.data_zmiany;
	}

	public void setData_zmiany(Timestamp data_zmiany) {
		this.data_zmiany = data_zmiany;
	}

	public String getImię() {
		return this.imię;
	}

	public void setImię(String imię) {
		this.imię = imię;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getPesel() {
		return this.pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public String getUtworzone_przez() {
		return this.utworzone_przez;
	}

	public void setUtworzone_przez(String utworzone_przez) {
		this.utworzone_przez = utworzone_przez;
	}

	public String getZmienione_przez() {
		return this.zmienione_przez;
	}

	public void setZmienione_przez(String zmienione_przez) {
		this.zmienione_przez = zmienione_przez;
	}

	public List<Wypozyczalnia> getWypozyczalnias() {
		return this.wypozyczalnias;
	}

	public void setWypozyczalnias(List<Wypozyczalnia> wypozyczalnias) {
		this.wypozyczalnias = wypozyczalnias;
	}

	public Wypozyczalnia addWypozyczalnia(Wypozyczalnia wypozyczalnia) {
		getWypozyczalnias().add(wypozyczalnia);
		wypozyczalnia.setKlienci(this);

		return wypozyczalnia;
	}

	public Wypozyczalnia removeWypozyczalnia(Wypozyczalnia wypozyczalnia) {
		getWypozyczalnias().remove(wypozyczalnia);
		wypozyczalnia.setKlienci(null);

		return wypozyczalnia;
	}

}