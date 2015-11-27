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

@Entity
public class Category {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	@NotNull(message="Required")
	 private String name;
	 
	@ManyToMany()
	@JoinTable(name="book_category",
	joinColumns={ @JoinColumn(name="category_id", referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="book_id", referencedColumnName="id")})
	List<Book> book=new ArrayList<Book>();

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

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	

}
