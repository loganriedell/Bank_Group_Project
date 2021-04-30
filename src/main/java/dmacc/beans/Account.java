package dmacc.beans;
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

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "accounts")
public class Account {
	//private variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	private double balance;
	private double interestRate;
	private Date dateCreated;
	//I added a type variable for things like checking or savings account.
	private String type;
	
	@OneToMany(orphanRemoval = true, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "at_id", referencedColumnName = "ID")
	List<Transaction> transactions = new ArrayList<Transaction>();
	//I am pretty sure this is correct 
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	public Account(float balance, float interestRate, Date dateCreated, String type, User user) {
		super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.dateCreated = dateCreated;
		this.type = type;
		this.user = user;
	}

	//constructors
	public Account(double balance)
	{
		super();
		this.balance = balance;
	}
	public Account(double balance, Date dateCreated) {
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
	public Account(long iD, float balance, float interestRate, Date dateCreated, User user) {
		super();
		this.ID = iD;
		this.balance = balance;
		this.interestRate = interestRate;
		this.dateCreated = dateCreated;
		this.user = user;
	}
	//I made both of these methods void just so they add or subtract from the balance.
	//I can make them return the amount if it helps
	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdrawal(double amount) {
		this.balance -= amount;
	}
	
	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param d the balance to set
	 */
	public void setBalance(double d) {
		this.balance = d;
	}
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
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

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
	
}
