package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}
