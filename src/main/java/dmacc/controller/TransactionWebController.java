package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Transaction;
import dmacc.beans.Account;
import dmacc.beans.User;
import dmacc.repository.AccountRepo;
import dmacc.repository.UserRepo;
@Controller
public class TransactionWebController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AccountRepo accntRepo;
	
	@GetMapping("/newTransaction/{id}")
	public String addTransaction(@PathVariable("id") long id, Model model) {
		Account accnt = accntRepo.findById(id);
		Transaction t = new Transaction();
		model.addAttribute("newTransaction", t);
		return "withdrawal/depostit";	
		
	}
	@PostMapping("/newTransaction/{id}")
	public String addTransaction(@PathVariable("id") long id, @ModelAttribute Transaction t, Model model) {
		Account accnt = accntRepo.findById(id).orElse(null);
		accnt.deposit(t.getAmount());
		return "";
	}
}
