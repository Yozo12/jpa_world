package it.objectmethod.jpa_world_query.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class City {
	@GeneratedValue
	@Id
	@Column(name="ID")
	private int id;
	@Column (name="CountryCode")
	private String codeCountry;
	@Column(name = "Name")
	private String name;
	@Column(name = "Population")
	private int population;

	@JsonIgnore
	@ManyToOne
	private Country country;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCodeCountry() {
		return codeCountry;
	}

	public void setCodeCountry(String codeCountry) {
		this.codeCountry = codeCountry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
