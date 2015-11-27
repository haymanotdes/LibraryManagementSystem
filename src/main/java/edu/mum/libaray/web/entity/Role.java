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

@Entity
public class Role {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	private String name;
	
	 @ManyToMany
		@JoinTable(name="user_role",
		joinColumns={ @JoinColumn(name="role_id", referencedColumnName="id")}
		,inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
	 private List<User> user=new ArrayList<User>();
	
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

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	
	 
	

}
