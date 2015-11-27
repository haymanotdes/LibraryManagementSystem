package edu.mum.libaray.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;

 
@Entity(name = "USERS_CREDNTIAL")
public class Credentials {

	/*@NotEmpty(message="{User.UserName}")*/
	@Id
	@GeneratedValue
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "USERNAME",/* nullable = false,*/ unique = true)
 	private String username;
	@Column(name = "PASSWORD"/*, nullable = false*/)
	/*@NotEmpty(message="{User.Password}")*/
	
	private String password;
	@Transient
	private String verifyPassword;
	Boolean enabled;

   
	
	/*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="USERNAME", referencedColumnName= "USERNAME") 
	List<Authority> authority;*/
	
	@OneToOne
	@JoinColumn(name="authorityId")
	private Authority authority;
	
	
 	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	/*public List<Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}*/
	
}