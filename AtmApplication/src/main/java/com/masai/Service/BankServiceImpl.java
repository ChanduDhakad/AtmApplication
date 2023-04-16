package com.masai.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AccountException;
import com.masai.Exception.BankException;
import com.masai.Exception.UserException;
import com.masai.Repository.AccountDao;
import com.masai.Repository.BankDao;

import com.masai.Repository.CurrentDao;
import com.masai.Repository.UserDao;
import com.masai.model.Account;
import com.masai.model.Bank;
import com.masai.model.CurrentSession;
import com.masai.model.LoginDto;
import com.masai.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class BankServiceImpl implements BankService{

	
/*
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired 
	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private CurrentDao cDao;
	

	@Override
	public User createUser(User user) throws UserException {
		// TODO Auto-generated method stub
		User userDataBase=userDao.findByMobileNumber(user.getMobileNumber());
       User user2=null;
		if(userDataBase==null) {
			user2=userDao.save(user);
		}
		else {		
			throw new UserException("User Is Already Registered");
		}
	
		return user2;
		
	}

	@Override
	public Bank addBook(Integer userId, Bank bank) throws AccountException,BankException,LoginException,UserException{

		
		
		
		
		
		Optional<User> opt=userDao.findById(userId);
		if(opt.isPresent()) {
			User existing=opt.get();
			Optional<CurrentSession> option=cDao.findById(userId);
			if(option.isPresent()) {
				
				List<Bank> list=existing.getCart().getBooks();
				if(list.size()!=0) {
					for(Bank b:list) {
						if(b==bank)
							throw new BankException("Book is already added");
					}
					
				}else {
					list.add(bank);
					int newtotal=existing.getCart().getTotal();
					existing.getCart().setTotal(newtotal+1);
					
				}
				return bank;
			}else {
				throw new LoginException("User is not logged in");
			}
		}else {
			throw new UserException("User is not found");
		}
		
		
	
	}

	@Override
	public String purchaseBook(Integer userId) throws BankException,UserException {
	 String result="Due TO low Balance You Cannot Purchase";
		Optional<User> optUser=userDao.findById(userId);
		
		
		if(optUser.isPresent()) {
			User user=optUser.get();
		
			List<Bank> banks=user.getCart().getBooks();
		if(banks!=null) {
			Integer total=0;
			for(Bank bank:banks) {
				total=total+bank.getPrice();
			}
			
			
	      if(user.getBudget()>=total) {
	    	
	    	  for(Bank bank:banks) {
	    		  bank.setNumberQuantitySale((bank.getNumberQuantitySale()+1));
					bankDao.save(bank);
				}
	    	  
	    	  List<Bank> booksList=new ArrayList<>();
	    	  user.getCart().setBooks(booksList);
	    	   
	    	  userDao.save(user);
	    	  result="Your Order Successfully Place";
	    	  
	       }
	      
		}
		else {
			
			throw new BankException("Cart Is Empty");
			
		}
			
		}
		else {
			
			throw new UserException("User Is Not Present By Given Id");
		}
		
		
		return result;
	}

	@Override
	public String LoginUser(LoginDto dto) throws LoginException {
		CurrentSession currentUserSession;

		User existinguser= userDao.findByMobileNumber(dto.getMobile_number());
		if(existinguser==null)
			throw new LoginException("Please Enter a valid CREDENTIALS");
		
	Optional<CurrentSession>	Opt =  cDao.findById(existinguser.getUserId());
	
		if(Opt.isPresent()) {
		
		throw new LoginException("User already Logged In with this MobileNumber"+dto.getPassword());
		
	}

	if(existinguser.getPassword().equals(dto.getPassword())) {;
		
	String key= RandomString.make(6);
		
		
		
		 currentUserSession = new CurrentSession(existinguser.getUserId(),key);
		
		cDao.save(currentUserSession);
		return key;
		
	}else {
		throw new LoginException("Password is not correct");
	}
	}


*/
}
