package com.masai.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Exception.AccountException;
import com.masai.Exception.BankException;
import com.masai.Exception.UserException;
import com.masai.model.Account;
import com.masai.model.User;

public interface AccountService {
	
	public String createAccount(Account account, Integer user_id) throws BankException, UserException;

	
	public String depositMoney(String accountNo, Integer amount) throws AccountException;
	 public String transferMoney(String userAccount, String transferAccount, Integer amount) throws AccountException;
		  
//	public List<Account>  getpopularAuthors() throws AuthorException;
//	
//	public Account deleteAuthor(Integer authorId) throws AuthorException;
//	
//	
	
	
	
}
