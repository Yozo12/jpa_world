package it.objectmethod.jpa_world_query.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue
	@Column(name = "idreview")
	private int idreview;
	@Column(name = "idcity")
	private int idcity;
	@Column(name = "review")
	private String review;
	@Column(name = "idauthor")
	private int idauthor;

	public int getIdcity() {
		return idcity;
	}

	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getIdauthor() {
		return idauthor;
	}

	public void setIdauthor(int idauthor) {
		this.idauthor = idauthor;
	}

	public int getIdreview() {
		return idreview;
	}

	public void setIdreview(int idreview) {
		this.idreview = idreview;
	}

}
