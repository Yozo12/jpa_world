package it.objectmethod.jpa_world_query.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue
	@Column(name = "idauthor")
	private int idauthor;
    @Column (name="password1")
    private  String pass1;
    @Column (name="password2")
    private  String pass2;
	@Column(name = "name")
	private String name;

	public int getIdauthor() {
		return idauthor;
	}

	public void setIdauthor(int idauthor) {
		this.idauthor = idauthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	
	
	
}
