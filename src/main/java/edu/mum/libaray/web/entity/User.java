package edu.mum.libaray.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;





@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	
	private String firstName;
	private String lastName;
	
	@Pattern(regexp="\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}",message="write valid phone number")
	private String phoneNumber;
	
	@NotNull(message="Required")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="write vaild email address")
	private String emailAddress;
	
	@Transient
	private String password;
	
	@Transient
	private String username;
	
	@Transient 
	private String authority;
	
	@Transient 
	private Boolean enabled;
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/*private String userName;
	private String password;
	*/
	@OneToOne 
	@JoinColumn(name="USERNAME")
	private Credentials credentials;
	
	
	@OneToOne
	private Address address;
	
	@Transient
	private List<Long> roleIds;
	
	@ManyToMany
	@JoinTable(name="user_role",
	joinColumns={ @JoinColumn(name="user_id", referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private List<Role> role=new ArrayList<Role>();
	
	
	
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public List<Borrow> getBorrow() {
		return borrow;
	}

	public void setBorrow(List<Borrow> borrow) {
		this.borrow = borrow;
	}

	@OneToMany(mappedBy="user",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Borrow> borrow=new ArrayList<Borrow>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
/*	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}*/
	
	
	

}
