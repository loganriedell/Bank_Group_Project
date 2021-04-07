package dmacc.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	private String firstName;
	private String lastName;
	private String address;
	private Date dateCreated;
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
	
	@OneToMany(mappedBy="user", orphanRemoval = true)
	private Set<Account> accounts;
	
	
	
	//Constructors
	public User(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public User(String firstName, String lastName, String address)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public User(String firstName, String lastName, String address, Date dateCreated)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dateCreated = dateCreated;
	}
	public User(String firstName, String lastName, String address, Date dateCreated, String socialSecurity, String email)
	{
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

	public Set<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
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
