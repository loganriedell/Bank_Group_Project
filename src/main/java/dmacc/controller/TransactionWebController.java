package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/newTransaction")
	public String addTransaction(Model model) {
		Account accnt = new Account(300);
		model.addAttribute("account", accnt);
		Transaction t = new Transaction();
		String action = "";
		model.addAttribute("action", action);
		model.addAttribute("newTransaction", t);
		return "withdrawal_deposit";	
		
	}
	@PostMapping("/newTransaction")
	public String addTransaction(/*@PathVariable("id") long id,*/ @ModelAttribute Transaction t, @ModelAttribute Account accnt, 
			@RequestParam String action, Model model) {
		accnt.setBalance(300);
		double balance = accnt.getBalance();
		if(action.equals("deposit"))
		{
			accnt.setBalance(balance += t.getAmount());
		}
		else {
			accnt.setBalance(balance -= t.getAmount());
		}
		model.addAttribute("account", accnt);
		model.addAttribute("transaction", t);
		model.addAttribute("action", action);
		return "transresult";
	}
}
