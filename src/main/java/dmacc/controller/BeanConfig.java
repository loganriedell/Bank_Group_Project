package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Account;
import dmacc.beans.Employee;
import dmacc.beans.Transaction;
import dmacc.beans.User;

@Configuration
public class BeanConfig {
	@Bean
	public User user() {
		User bean = new User("John", "Henry");
		return bean;
	}
	@Bean
	public Account account() {
		Account bean = new Account(30000.00);
		return bean;
	}
	@Bean Transaction transaction() {
		Transaction bean = new Transaction();
		return bean;
	}
	@Bean Employee employee() {
		Employee bean = new Employee();
		return bean;
	}
}