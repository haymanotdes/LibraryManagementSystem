package edu.mum.libaray.web.dto;

import java.util.ArrayList;
import java.util.List;


public class BookCopyDTO {
	
	
	 private long id;
	
	
	private String book;
	
	public String  getCondtion() {
		return condtion;
	}

	public void setCondtion(String condtion) {
		this.condtion = condtion;
	}

	
	private String condtion;
	
	

	private boolean available=true;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	

}

