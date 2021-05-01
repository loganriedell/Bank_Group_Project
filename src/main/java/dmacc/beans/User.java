package dmacc.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID; 
	
	private String firstName;
	private String lastName;
	private String address;
	private LocalDate dateCreated;
	private String socialSecurity;
	private String email;
	
	
	/*I thought I would try this it was on spring boot tutorial Set instead of ArrayList
	 * looks like it works about the same way but it doesn't work we can do what we know which is to just join the column
	 * 
	 * @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, orphanRemoval = true)
	 * @JoinTable
	  (
	      name="user_accounts",
	      joinColumns={ @JoinColumn(name="USERID", referencedColumnName="USERID") },
	      inverseJoinColumns={ @JoinColumn(name="ACCNTID", referencedColumnName="ACCNTID", unique=true) }
	  )
	  private ArrayList<Account> accounts;
	 */
	
	@OneToMany(orphanRemoval = true, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ua_id", referencedColumnName = "userId")
	List<Account> accounts = new ArrayList<Account>();
	
	
	
	//Constructors
	public User()
	{
		super();
	}
	public User(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public User(String firstName, String lastName, String address)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public User(String firstName, String lastName, String address, LocalDate dateCreated)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dateCreated = dateCreated;
	}
	public User(String firstName, String lastName, String address, LocalDate dateCreated, String socialSecurity, String email)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dateCreated = dateCreated;
		this.socialSecurity = socialSecurity;
		this.email = email;
	}
	
	//Methods

	public String getFirstName() {
		return firstName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
