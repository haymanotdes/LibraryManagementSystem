package edu.mum.libaray.web.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Publisher {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull(message="Required")
	private String name;
	@Pattern(regexp="\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}",message="write valid phone number")
	private String phone;
	private String fax;
	private String url;
	
	@OneToMany(mappedBy="publisher",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Book> book=new ArrayList<Book>();
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	

}
