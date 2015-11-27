package edu.mum.libaray.web.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fine {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectedDate;
	
	@OneToOne
	@JoinColumn(name="borrow_id")
	private Borrow borrow;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEffectedDate() {
		return effectedDate;
	}

	public void setEffectedDate(Date effectedDate) {
		this.effectedDate = effectedDate;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	
	
}
