package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Account;
import dmacc.beans.Employee;
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
	
	
	@GetMapping({ "/", "viewAllUsers" })
	public String viewAllUsers(Model model) {
		if (userRepo.findAll().isEmpty()) {
			return addNewUser(model);
		}

		model.addAttribute("users", userRepo.findAll());

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
	
	
	@GetMapping({ "/", "viewAllAccounts" })
	public String viewAllAccounts(Model model) {
		if (acctRepo.findAll().isEmpty()) {
			return addNewAccount(model);
		}

		model.addAttribute("accounts", acctRepo.findAll());
		return "results";
	}

	@GetMapping("/inputAccount")
	public String addNewAccount(Model model) {
		Account a = new Account();
		model.addAttribute("newAccount", a);
		return "inputAccount";
	}

	@PostMapping("/inputAccount")
	public String addNewAccount(@ModelAttribute Account a, Model model) {
		acctRepo.save(a);
		return viewAllAccounts(model);
	}
	
	@GetMapping("/editAccount/{ID}")
	public String showUpdateAccount(@PathVariable("ID") long id, Model model) {
		Account a = acctRepo.findById(id).orElse(null);
		model.addAttribute("newAccount", a);
		return "inputAccount";
	}

	@PostMapping("/updateAccount/{ID}")
	public String reviseAccount(Account a, Model model) {
		acctRepo.save(a);
		return viewAllUsers(model);
	}
	
	
	@GetMapping({ "/", "viewAllEmployees" })
	public String viewAllEmployees(Model model) {
		if (empRepo.findAll().isEmpty()) {
			return addNewEmployee(model);
		}

		model.addAttribute("employees", empRepo.findAll());
		return "results";
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
		return viewAllAccounts(model);
	}
}

