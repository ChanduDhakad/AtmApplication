package com.masai.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


import net.bytebuddy.implementation.bytecode.Throw;
import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private AccountDao accountDao;
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private CurrentDao cDao;
	
	
	@Override
	public User createUser(User user) throws UserException {
		
		// crate new user
		
		User userDataBase=userDao.findByMobileNumber(user.getMobileNumber());
	       User user2=userDataBase;
			if(user2==null) {
				user2=userDao.save(user);
			}
			else {		
				throw new UserException("User Is Already Registered with Mobile Number "+user.getMobileNumber());
			}
		
			return user2;
		
	}

	@Override
	public String LoginUser(LoginDto dto) throws LoginException {
	
		
		   User existuser=  userDao.findByMobileNumber(dto.getMobile_number());
		
		
		     if( existuser==null) throw new  LoginException("Please Enter a valid CREDENTIALS");
		    	 
		     
		      Optional<CurrentSession> opt= cDao.findById(existuser.getUserId());
		     
		     
		      if(opt.isPresent())throw new LoginException("User already Logged In with this MobileNumber "+dto.getMobile_number());
				
		     if( existuser.getPassword().equals(dto.getPassword())) {
		    	 
		    		String key= RandomString.make(6);
		    		 CurrentSession cus = new CurrentSession(existuser.getUserId(),key);
		    		 cDao.save(cus);
						return key;
		     }else throw new LoginException("Password is not correct");
		     
		     
		     
	}
	
	
	@Override
	public List<User> SortByNameOrAddress(String type, String direction) throws UserException {
		
		if(type.toUpperCase().equals("NAME")||type.toUpperCase().equals("ADDRESS"))
		return userDao.findAll(direction.equals("asc")? Sort.by(type).ascending():Sort.by(type).descending());
		else
			throw new UserException("Type iS need to be mentioned either name or address");
	}

	
	
	@Override
	public List<User> getAllUserByPageWise(Integer pagenumber, Integer NumberOfRecords) {
		
		Pageable p=(Pageable) PageRequest.of(pagenumber-1, NumberOfRecords);
		Page<User> page=userDao.getAllUsers(p);
		List<User> users=page.getContent();
		
		return users;
	}

}

	
	
	
	
	
	
	
	
	
	
	
