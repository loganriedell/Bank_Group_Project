package dmacc.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Account;
import dmacc.beans.Employee;
import dmacc.beans.Transaction;
import dmacc.beans.User;
import dmacc.repository.AccountRepo;
import dmacc.repository.EmployeeRepo;
import dmacc.repository.UserRepo;


/**
 * @author Ethan Dorenkamp - edorenkamp
 * CIS175 - Spring 2021
 * Apr 14, 2021
 */
@Controller
public class WebController {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	AccountRepo acctRepo;
	@Autowired
	EmployeeRepo empRepo;
	
	
	@GetMapping({"/viewAllUsers" })
	public String viewAllUsers(Model model) {
		if (userRepo.findAll().isEmpty()) {
			return addNewUser(model);
		}
		model.addAttribute("users", userRepo.findAll());
		return "viewAllUsers";
	}
	@GetMapping("/viewUserAccounts/{id}")
	public String viewUserAccount(@PathVariable("id") long id, Model model)
	{
		User user = userRepo.findById(id).orElse(null);
		model.addAttribute("user", user);
		return "viewUserAccounts";
	}
	@GetMapping("/viewAccountTransactions/{id}")
	public String viewAccountTransactions(@PathVariable("id") long id, Model model)
	{
		Account account = acctRepo.findById(id).orElse(null);
		List<Transaction> transactions = account.getTransactions();
		model.addAttribute("transactions", transactions);
		return "viewAccountTransactions";
		
	}
	@GetMapping("/inputUser")
	public String addNewUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "inputUser";
	}

	@PostMapping("/inputUser")
	public String addNewUser(@ModelAttribute User u, Model model) {
		userRepo.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/editUser/{userID}")
	public String showUpdateUser(@PathVariable("userID") long id, Model model) {
		User u = userRepo.findById(id).orElse(null);
		model.addAttribute("newUser", u);
		return "inputUser";
	}

	@PostMapping("/updateUser/{UserID}")
	public String reviseUser(User u, Model model) {
		userRepo.save(u);
		return viewAllUsers(model);
	}
	
	
	/*@GetMapping({"viewAllAccounts" })
	public String viewAllAccounts(Model model) {
		if (acctRepo.findAll().isEmpty()) {
			return (model);
		}

		model.addAttribute("accounts", acctRepo.findAll());
		return "results";
	}*/

	@GetMapping("/inputAccount{id}")
	public String addNewAccount(@PathVariable("id") long id, Model model) {
		Account a = new Account();
		User user = userRepo.findById(id).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("newAccount", a);
		return "inputAccount";
	}

	@PostMapping("/inputAccount")
	public String addNewAccount(@ModelAttribute User user, @ModelAttribute Account a, Model model) {
		user.getAccounts().add(a);
		userRepo.save(user);
		return viewUserAccount(user.getUserID(), model);
	}
	
	@GetMapping("/editAccount/{AccountID}/{UserID}")
	public String showUpdateAccount(@PathVariable("AccountID") long id, 
			@PathVariable("UserID") long userID, Model model) {
		User user = userRepo.findById(userID).orElse(null);
		Account a = acctRepo.findById(id).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("newAccount", a);
		return "inputAccount";
		//return "transresult";
	}

	@PostMapping("/updateAccount/{UserID}/{AccountID}")
	public String reviseAccount(@PathVariable("AccountID") long id,
			@PathVariable("UserID") long userID, @ModelAttribute("newAccount") Account a, Model model) {
		User user = userRepo.findById(userID).orElse(null);
		Account account = acctRepo.findById(id).orElse(null);
		if(account == null) {
			user.getAccounts().add(a);
			userRepo.save(user);
		}
		else {
			a.setID(id);
			acctRepo.save(a);
		}
		model.addAttribute("user", user);
		model.addAttribute("newAccount", a);
		//return "transresult";
		return viewUserAccount(userID, model);
	}
	
	@GetMapping("/deleteAccount/{accountID}/{userID}")
	public String deleteAccount(@PathVariable("accountID") long accountID, @PathVariable("userID") long userID, Model model) {
		Account account = acctRepo.findById(accountID).orElse(null);
		model.addAttribute("userID", userID);
		acctRepo.delete(account);
		return viewUserAccount(userID, model);
	}

	@GetMapping({"/viewAllEmployees" })
	public String viewAllEmployees(Model model) {
		if (empRepo.findAll().isEmpty()) {
			return addNewEmployee(model);
		}
		model.addAttribute("employees", empRepo.findAll());
		return "viewAllEmployees";
	}

	@GetMapping("/inputEmployee")
	public String addNewEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("newEmployee", e);
		return "inputEmployee";
	}

	@PostMapping("/inputEmployee")
	public String addNewEmployee(@ModelAttribute Employee e, Model model) {
		empRepo.save(e);
		return viewAllEmployees(model);
	}
	
	@GetMapping("/editEmployees/{employeeId}")
	public String showUpdateEmployee(@PathVariable("employeeId") long id, Model model) {
		Employee e = empRepo.findById(id).orElse(null);
		model.addAttribute("newEmployee", e);
		return "inputEmployee";
	}

	@PostMapping("/updateEmployee/{employeeId}")
	public String reviseEmployee(Employee e, Model model) {
		empRepo.save(e);
		return viewAllEmployees(model);
	}

	@GetMapping("/deleteEmployee/{employeeID}")
	public String deleteEmployee(@PathVariable("employeeID") long id, Model model) {
		Employee e = empRepo.findById(id).orElse(null);
		empRepo.delete(e);
		return "/view";
	}
	
	@GetMapping("/deleteUser/{userID}")
	public String deleteUser(@PathVariable("userID") long id, Model model) {
		User user = userRepo.findById(id).orElse(null);
		userRepo.delete(user);
		return viewAllUsers(model);
	}
	@GetMapping("/newTransaction/{AccountID}/{UserID}")
	public String addTransaction(@PathVariable("AccountID") long accountID, @PathVariable("UserID") long userID, Model model) {
		Account accnt = acctRepo.findById(accountID).orElse(null);
		User user = userRepo.findById(userID).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("account", accnt);
		Transaction t = new Transaction();
		String action = "";
		model.addAttribute("action", action);
		model.addAttribute("newTransaction", t);
		return "withdrawal_deposit";	
		
	}
	@PostMapping("/newTransaction/{AccountID}/{UserID}")
	public String addTransaction(@PathVariable("AccountID") long accountID, @PathVariable("UserID") long userID, @ModelAttribute Transaction t, 
			@RequestParam String action, Model model) {
		Account account = acctRepo.findById(accountID).orElse(null);
		t.setDateOfTransaction(LocalDate.now());
		account.getTransactions().add(t);
		User user = userRepo.findById(userID).orElse(null);
		double balance = account.getBalance();
		model.addAttribute("account", account);
		if(action.equals("deposit"))
		{
			account.setBalance(balance += t.getAmount());
		}
		else {
			account.setBalance(balance -= t.getAmount());
		}
		model.addAttribute("user", user);
		acctRepo.save(account);
		return viewAccountTransactions(accountID, model);
	
	}
	@GetMapping({"/userLogin"})
		public String userLogin(@ModelAttribute User u, Model model) {
		
		String email = u.getEmail();
		String Social = u.getSocialSecurity();

		List<User> UserList = userRepo.findByEmail(email);
		
		User myUser = UserList.get(0);
		Long userID = myUser.getUserID();
		if(UserList.get(0) == null) {
			System.out.println("Email not found");
			return "/userLogin";
		}
	
		if(Social.equals( myUser.getSocialSecurity())) {
			return viewUserAccount(userID, model);
		}
		 
		return"/userLogin";
		}
	@GetMapping("/toUserLogin")
	public String toUserLoginFunct(Model model) {
		User u = new User();
		model.addAttribute("loginAttempt", u);
		return "/userLogin";
	}
	@GetMapping({"/employeeLogin"})
	public String employeeLogin(@ModelAttribute Employee e, Model model) {
	
	String email = e.getEmail();
	String firstName = e.getFirstName();

	List<Employee> EmployeeList = empRepo.findByEmail(email);
	Employee myEmployee = EmployeeList.get(0);
	if(EmployeeList.get(0) == null) {
		System.out.println("Email not found");
		return "/employeeLogin";
	}

	if(firstName.equals(myEmployee.getFirstName())) {
		String name = myEmployee.getFirstName() + " " + myEmployee.getLastName();
		model.addAttribute("empName", name);
		return "/employeeOptions";
	}
	 
	return"/employeeLogin";
	}
	@GetMapping("/toEmployeeLogin")
	public String toEmployeeLoginFunct(Model model) {
		Employee e = new Employee();
		model.addAttribute("loginAttempt", e);
		return "/employeeLogin";
	}
	
}

