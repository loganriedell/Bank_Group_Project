package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Employee;

/**
 * @author Ethan Dorenkamp - edorenkamp
 * CIS175 - Spring 2021
 * Apr 14, 2021
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
