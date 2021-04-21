package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Employee;
import dmacc.beans.User;

/**
 * @author Ethan Dorenkamp - edorenkamp
 * CIS175 - Spring 2021
 * Apr 14, 2021
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	List<Employee>findByEmail(String email);
}
