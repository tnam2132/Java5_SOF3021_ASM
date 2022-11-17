package java5_sof3021_assignment.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUsernameLike(String username);
	Page<Account> findByUsernameLike(String username, Pageable pageable);
}
