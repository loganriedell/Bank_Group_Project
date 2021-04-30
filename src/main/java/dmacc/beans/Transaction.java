package dmacc.beans;


import java.util.Date;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionID;

	private Date dateOfTransaction;
	private double amount;
	private long accountFrom;
	private long accountTo;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Account account;

	//Constructors
	public Transaction()
	{
		super();
	}
	public Transaction(double amount) {
		super();
		this.amount = amount;
	}
	public Transaction(Date dateOfTransaction, double amount, long accountFrom, long accountTo)
	{
		super();
		this.dateOfTransaction = dateOfTransaction;
	    this.amount = amount;
	    this.accountFrom = accountFrom;
	    this.accountTo = accountTo;
	}

	public Transaction(int transactionID, Date dateOfTransaction, double amount, long accountFrom, long accountTo)
	{
		super();
		this.transactionID = transactionID;
	    this.dateOfTransaction = dateOfTransaction;
	    this.amount = amount;
	    this.accountFrom = accountFrom;
	    this.accountTo = accountTo;
	}

	//Methods

  public long getTransactionID() {
		return transactionID;
	}
  public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

  public Date getDateOfTransaction() {
    return dateOfTransaction;
  }

  public void setDateOfTransaction(Date dateOfTransaction) {
    this.dateOfTransaction = dateOfTransaction;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public long getAccountFrom() {
    return accountFrom;
  }

  public void setAccountFrom(long accountFrom) {
    this.accountFrom = accountFrom;
  }

  public long getAccountTo() {
    return accountTo;
  }

  public void setAccountTo(long accountTo) {
    this.accountTo = accountTo;
  }

}
