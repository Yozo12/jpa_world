package it.objectmethod.jpa_world_query.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
  @Id 
  private String Code;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Continent")
	private String continent;
	@Column(name = "Population")
	private int population;

	@JoinColumn(name = "CountryCode")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<City> city;

	public String getName() {
		return Name;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	
}
