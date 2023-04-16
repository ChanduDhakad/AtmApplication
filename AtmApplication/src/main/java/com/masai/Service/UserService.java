package com.masai.Service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.Exception.AccountException;
import com.masai.Exception.BankException;
import com.masai.Exception.UserException;
import com.masai.model.Bank;
import com.masai.model.LoginDto;
import com.masai.model.User;

public interface UserService {

	public User createUser(User user) throws UserException;
	public String LoginUser(LoginDto dto) throws LoginException;
	
	public List<User> SortByNameOrAddress(String type,String direction) throws UserException; 
	
	public List<User> getAllUserByPageWise(Integer pagenumber, Integer NumberOfRecords);
	/*
	public Bank addBook(Integer userId,Bank bank)throws AccountException, BankException, LoginException, UserException;
	public String purchaseBook(Integer userId)throws BankException,UserException;
	 

	
	
	*/
}
