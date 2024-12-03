package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wypozyczalnia database table.
 * 
 */
@Entity
@NamedQuery(name="Wypozyczalnia.findAll", query="SELECT w FROM Wypozyczalnia w")
public class Wypozyczalnia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nr_wypozyczenia;

	@Temporal(TemporalType.DATE)
	private Date data_oddania;

	@Temporal(TemporalType.DATE)
	private Date data_wypożyczenia;

	//bi-directional many-to-one association to Klienci
	@ManyToOne
	@JoinColumn(name="Id_klienta")
	private Klienci klienci;

	//bi-directional many-to-one association to Samochody
	@ManyToOne
	private Samochody samochody;

	public Wypozyczalnia() {
	}

	public int getNr_wypozyczenia() {
		return this.nr_wypozyczenia;
	}

	public void setNr_wypozyczenia(int nr_wypozyczenia) {
		this.nr_wypozyczenia = nr_wypozyczenia;
	}

	public Date getData_oddania() {
		return this.data_oddania;
	}

	public void setData_oddania(Date data_oddania) {
		this.data_oddania = data_oddania;
	}

	public Date getData_wypożyczenia() {
		return this.data_wypożyczenia;
	}

	public void setData_wypożyczenia(Date data_wypożyczenia) {
		this.data_wypożyczenia = data_wypożyczenia;
	}

	public Klienci getKlienci() {
		return this.klienci;
	}

	public void setKlienci(Klienci klienci) {
		this.klienci = klienci;
	}

	public Samochody getSamochody() {
		return this.samochody;
	}

	public void setSamochody(Samochody samochody) {
		this.samochody = samochody;
	}

}