package dmacc;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import dmacc.beans.Account;
import dmacc.beans.Transaction;
import dmacc.beans.User;
import dmacc.repository.AccountRepo;
import dmacc.repository.UserRepo;

@SpringBootApplication
public class BankProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(BankProjectApplication.class, args);
	}

	//@Autowired
	//private AccountRepo accntRepo;
	
	//@Autowired
	//private UserRepo userRepo;
	
	//For Testing so far
	//@Override
	//public void run(String... args) throws Exception{
		/*
		//This creates a new user and a new account for that user and persists them both using the userRepo
		//Just fill out the info for parameters
		User user = new User(yourFirstName, yourLastName);
		Account userAccount = new Account(chooseBalance);
		userRepo.save(user);
		
		//I created this to queries by first name and last name the only way it works is with a list for jparepo
		//but should be easy enough to just access first index for the right person
		List<User> users = userRepo.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
		
		//Grabbing only the first user because their probably is only one with that name 
		User user1 = users.get(0);
		
		//Accessing the first account in user1 accounts
		Account user1FirstAccount = user1.getAccounts().get(0);
		
		//This creates a new Transaction with just the amount adds it to the account and persists both with the account repo 
		Transaction transact = new Transaction(1000.0);
		user1FirstAccount.getTransactions().add(transact);
		//accntRepo.save(user1FirstAccount);
		
		//Iterating through the users that match the first name and last name used in query method
		for(User u:users)
		{
			System.out.println("The users first name and last is " + u.getFirstName() + " " +  u.getLastName());
			//Gets first account balance
			Account firstAccnt = u.getAccounts().get(0);
			System.out.println("The amount in first account was" + firstAccnt.getBalance());
			
			//Getting the first transaction amount in the first account 
			Transaction trans = firstAccnt.getTransactions().get(0);
			System.out.println("First transaction is " + trans.getAmount());
		}
		*/
}

