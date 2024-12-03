package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the samochody database table.
 * 
 */
@Entity
@NamedQuery(name="Samochody.findAll", query="SELECT s FROM Samochody s")
public class Samochody implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nr_rejestracyjny;

	private double koszt_wynajecia_na_dzien;

	private String marka;

	private String model;

	private int przebieg_w_km;

	//bi-directional many-to-one association to Wypozyczalnie
	@ManyToOne
	private Wypozyczalnie wypozyczalnie;

	//bi-directional many-to-one association to Wypozyczalnia
	@OneToMany(mappedBy="samochody")
	private List<Wypozyczalnia> wypozyczalnias;

	public Samochody() {
	}

	public String getNr_rejestracyjny() {
		return this.nr_rejestracyjny;
	}

	public void setNr_rejestracyjny(String nr_rejestracyjny) {
		this.nr_rejestracyjny = nr_rejestracyjny;
	}

	public double getKoszt_wynajecia_na_dzien() {
		return this.koszt_wynajecia_na_dzien;
	}

	public void setKoszt_wynajecia_na_dzien(double koszt_wynajecia_na_dzien) {
		this.koszt_wynajecia_na_dzien = koszt_wynajecia_na_dzien;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrzebieg_w_km() {
		return this.przebieg_w_km;
	}

	public void setPrzebieg_w_km(int przebieg_w_km) {
		this.przebieg_w_km = przebieg_w_km;
	}

	public Wypozyczalnie getWypozyczalnie() {
		return this.wypozyczalnie;
	}

	public void setWypozyczalnie(Wypozyczalnie wypozyczalnie) {
		this.wypozyczalnie = wypozyczalnie;
	}

	public List<Wypozyczalnia> getWypozyczalnias() {
		return this.wypozyczalnias;
	}

	public void setWypozyczalnias(List<Wypozyczalnia> wypozyczalnias) {
		this.wypozyczalnias = wypozyczalnias;
	}

	public Wypozyczalnia addWypozyczalnia(Wypozyczalnia wypozyczalnia) {
		getWypozyczalnias().add(wypozyczalnia);
		wypozyczalnia.setSamochody(this);

		return wypozyczalnia;
	}

	public Wypozyczalnia removeWypozyczalnia(Wypozyczalnia wypozyczalnia) {
		getWypozyczalnias().remove(wypozyczalnia);
		wypozyczalnia.setSamochody(null);

		return wypozyczalnia;
	}

}