package edu.mum.libaray.web.entity;

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
import javax.validation.constraints.NotNull;

@Entity
public class Book {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	@NotNull(message="Required")
	 private String isbn;
	@NotNull(message="Required")
	 private String name;
	 
	 @ManyToOne
	 @JoinColumn(name="publisherid")
	 private Publisher publisher;
	 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="book_author",
	joinColumns={ @JoinColumn(name="book_id", referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="author_id", referencedColumnName="id")})
	 private List<Author> author;
	
	
	@ManyToMany
	@JoinTable(name="book_category",
	joinColumns={ @JoinColumn(name="book_id", referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="category_id", referencedColumnName="id")})
	List<Category> bookcategory;
	
	
	@OneToMany(mappedBy="book",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<BookCopy> bookCopy=new ArrayList<BookCopy>();
	
	
	 @Transient
	List<Long> categoriesId;
	
	 @Transient
	List<Long> authoriesId;
	 
	 
	

	
	public List<Long> getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(List<Long> categoriesId) {
		this.categoriesId = categoriesId;
	}
	public List<Long> getAuthoriesId() {
		return authoriesId;
	}
	public void setAuthoriesId(List<Long> authoriesId) {
		this.authoriesId = authoriesId;
	}
	public List<Category> getBookcategory() {
		return bookcategory;
	}
	public void setBookcategory(List<Category> bookcategory) {
		this.bookcategory = bookcategory;
	}
	
	public List<BookCopy> getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(List<BookCopy> bookCopy) {
		this.bookCopy = bookCopy;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
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
