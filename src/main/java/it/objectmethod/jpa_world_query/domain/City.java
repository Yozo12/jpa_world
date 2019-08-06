package it.objectmethod.jpa_world_query.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class City {
	@GeneratedValue
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "CountryCode")
	private String codeCountry;
	@Column(name = "Name")
	private String name;
	@Column(name = "Population")
	private int population;

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

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}
	

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}


	@JsonIgnore
	@JoinColumn(name = "idcity")
	@OneToMany
	private List<Review> review;
	
	@JsonIgnore
	@JoinColumn(name = "idauthor")
	@OneToMany
	private List<Author> author;
	
	

}
