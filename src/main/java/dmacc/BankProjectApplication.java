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
public class BankProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankProjectApplication.class, args);
	}

	@Autowired
	private AccountRepo accntRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	//For Testing so far
	@Override
	public void run(String... args) throws Exception{
		
		//Creates new user and account and persists them both
		User user = new User("Logan", "Riedell");
		Account usersAccount = new Account(/*Amount*/);
		userRepo.save(user);
		
		List<User> users = userRepo.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
		for(User u:users)
		{
			System.out.println(u.getFirstName() + "billybong");
		}

	}
}
