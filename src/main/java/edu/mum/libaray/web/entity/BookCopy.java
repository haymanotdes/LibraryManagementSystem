package edu.mum.libaray.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookCopy {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bookid")
	private Book book;
	
	public BookCopyCondtion getCondtion() {
		return condtion;
	}

	public void setCondtion(BookCopyCondtion condtion) {
		this.condtion = condtion;
	}

	@Enumerated(EnumType.STRING)
	private BookCopyCondtion condtion;
	
	public List<Borrow> getBorrow() {
		return borrow;
	}

	public void setBorrow(List<Borrow> borrow) {
		this.borrow = borrow;
	}

	@OneToMany(mappedBy="bookCopy",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Borrow> borrow=new ArrayList<Borrow>();
	
	private boolean available=true;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	

}

