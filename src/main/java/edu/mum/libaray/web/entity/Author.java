package edu.mum.libaray.web.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class Author {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
/*	@NotNull(message="Required")*/
	private String fname;
/*	@NotNull(message="Required")*/
	private String lname;
	
	/*@NotNull(message="Required")*/
/*	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="write vaild email address")*/
	private String email;
/*	
	@Pattern(regexp="\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}",message="write valid phone number")*/
	private String phone;
	
	@ManyToMany()
	@JoinTable(name="book_author",
	joinColumns={ @JoinColumn(name="author_id", referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="book_id", referencedColumnName="id")})
	List<Book> book=new ArrayList<Book>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	

}
