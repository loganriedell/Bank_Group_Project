package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	List<User> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<User>findByEmail(String email);
	
}

