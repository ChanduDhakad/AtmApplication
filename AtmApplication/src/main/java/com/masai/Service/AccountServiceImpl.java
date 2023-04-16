package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AccountException;
import com.masai.Exception.BankException;
import com.masai.Exception.UserException;
import com.masai.Repository.AccountDao;
import com.masai.Repository.BankDao;
import com.masai.Repository.UserDao;
import com.masai.model.Account;
import com.masai.model.Bank;
import com.masai.model.User;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountDao accountDao;
	
//	@Autowired 
//	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BankDao bankDao;
	

	

	@Override
	public String createAccount(Account account, Integer user_id) throws BankException, UserException {
		
		
		//public String Createaccount(Account account, Integer user_id) throws BankException, UserException {
			Optional<User> opt =userDao.findById(user_id);
			if(opt.isPresent()) {
				User existing=opt.get();
				String bankname=account.getBank().getName();
				List<Account> accountList=existing.getAccounts();
				if(accountList.size()==0) {
					accountDao.save(account);
					return "Account is Sucessfully Open";
				}
				for(Account a:accountList) {
					if(a.getBank().getName().equals(bankname))
						throw new BankException("User is Alreeady having account in bank "+ bankname);
				}
				accountDao.save(account);
				return "Account is Sucessfully Open";
			}
			else {
				throw new UserException("User is Not Found");
			}
		}




	
	
	@Override
	public String depositMoney(String accountNo, Integer amount) throws AccountException {
		
		
		 Account userAccount = accountDao.findByAccountNo(accountNo);
	        if(userAccount == null) throw new AccountException("Enter valid account number");
	        else {
	            userAccount.setBalance(userAccount.getBalance() + amount);
	            accountDao.save(userAccount);
	            return "Money Deposit Successful and Your new balance" + userAccount.getBalance();
	        }

	}
	

	 @Override
	    public String transferMoney(String userAccount, String transferAccount, Integer amount)throws AccountException  {
		 
		           String res="Not successful";
	        Account uAccount = accountDao.findByAccountNo(userAccount);
	        if(uAccount != null) {
	        	
	           Account trAccount = accountDao.findByAccountNo(transferAccount);
	           
	           if(trAccount != null){
	        	   
	               if(uAccount.getBalance() < amount) {
	            	   throw new AccountException("Insufficient balance");
	               }
	               
	               else {
	                   trAccount.setBalance(trAccount.getBalance()+amount);
	                   uAccount.setBalance(uAccount.getBalance()-amount);
	                   accountDao.save(uAccount);
	                   accountDao.save(trAccount);
	                   res= "Successfully money transfer and your update balance "+ uAccount.getBalance();
	               }
	           }
	           else {
	        	   throw new AccountException("Enter valid Transfer Account");
	           }
	        }
	          
	        
	        else {
	        	   throw new AccountException("Enter valid your account ");
	           }
	        
	        
	        return res;
	 }
}
