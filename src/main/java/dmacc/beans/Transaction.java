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
public class Transaction {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionID;

	private Date dateOfTransaction;
  private float amount;
	private Account accountFrom;
  private Account accountTo;

	//Constructors
	public Transaction()
	{

	}

	public Transaction(Date dateOfTransaction, float amount, Account accountFrom, Account accountTo)
	{
		this.dateOfTransaction = dateOfTransaction;
    this.amount = amount;
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
	}

	public Transaction(int transactionID, Date dateOfTransaction, float amount, Account accountFrom, Account accountTo)
	{
		this.transactionID = transactionID;
    this.dateOfTransaction = dateOfTransaction;
    this.amount = amount;
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
	}

	//Methods

  public int getTransactionID() {
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

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public Account getAccountFrom() {
    return accountFrom;
  }

  public void setAccountFrom(Account accountFrom) {
    this.accountFrom = accountFrom;
  }

  public Account getAccountTo() {
    return accountTo;
  }

  public void setAccountTo(Account accountTo) {
    this.accountTo = accountTo;
  }

}
