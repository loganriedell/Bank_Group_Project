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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Account {
	//private variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private float balance;
	private float interestRate;
	private Date dateCreated;
	//I added a type variable for things like checking or savings account.
	private String type;
	public Account(float balance, float interestRate, Date dateCreated, String type, User user) {
		super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.dateCreated = dateCreated;
		this.type = type;
		this.user = user;
	}

	//I am pretty sure this is correct
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	
	
	//constructors
	public Account(float balance, Date dateCreated) {
		super();
		this.balance = balance;
		this.dateCreated = dateCreated;
	}
	public Account() {
		super();
	}
	public Account(float balance, float interestRate, Date dateCreated, User user) {
		super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.dateCreated = dateCreated;
		this.user = user;
	}
	public Account(int iD, float balance, float interestRate, Date dateCreated, User user) {
		super();
		ID = iD;
		this.balance = balance;
		this.interestRate = interestRate;
		this.dateCreated = dateCreated;
		this.user = user;
	}
	//I made both of these methods void just so they add or subtract from the balance.
	//I can make them return the amount if it helps
	public void deposit(float amount) {
		this.balance += amount;
	}
	public void withdrawal(float amount) {
		this.balance -= amount;
	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}
	/**
	 * @return the interestRate
	 */
	public float getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Account [ID=" + ID + ", balance=" + balance + ", interestRate=" + interestRate + ", dateCreated="
				+ dateCreated + ", type=" + type + ", user=" + user + "]";
	}
	
	
	
	
}
