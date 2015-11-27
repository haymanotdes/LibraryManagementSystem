package edu.mum.libaray.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


public class BookDTO {

	
	 private long id;
	 private String isbn;
	 private String name;
	 private String publisher;
	 	
	 private List<String> author=new ArrayList<String>();;
	
	
	List<String> bookcategory=new ArrayList<String>();
	
		
	private int bookCopy;
	
	 
	 public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	public List<String> getBookcategory() {
		return bookcategory;
	}
	public void setBookcategory(List<String> bookcategory) {
		this.bookcategory = bookcategory;
	}
	public int getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(int bookCopy) {
		this.bookCopy = bookCopy;
	}
		
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

	
}
