package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAll(){
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}
//	+Page
	public Page<Account> getAll(Pageable pageable){
		Page<Account> accounts = accountRepository.findAll(pageable);
		return accounts;
	}
	
	public Account findByUsername(String username){
		Account account = accountRepository.findByUsernameLike(username);
		return account;
	}
//	+Page
	public Page<Account> findByUsername(String username, Pageable pageable){
		Page<Account> accounts = accountRepository.findByUsernameLike(username, pageable);
		return accounts;
	}
	
	public void create(Account account){
		accountRepository.save(account);
	}
	
	public void update(Account account){
		accountRepository.save(account);
	}
//	Tìm theo id
	public Account findById(Integer id){
		Account account = accountRepository.findById(id).get();
		return account;
	}
	
	public void delete(Integer id){
		accountRepository.deleteById(id);;
	}
}
