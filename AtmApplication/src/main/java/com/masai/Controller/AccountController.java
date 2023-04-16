package com.masai.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Exception.AccountException;
import com.masai.Exception.BankException;
import com.masai.Exception.UserException;
import com.masai.Service.AccountService;
import com.masai.Service.UserService;
import com.masai.model.Account;
import com.masai.model.Bank;
import com.masai.model.LoginDto;
import com.masai.model.User;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;
import java.util.List;



	@RestController("/masaiAtm/user")
	public class AccountController {
			
		@Autowired
		AccountService ac;
		
		
		@PostMapping("/account/{user_id}")
		public ResponseEntity<String> OpenAccount(@Valid @RequestBody Account account,@PathVariable("user_id") Integer user_id) throws BankException, UserException{
			
			return new ResponseEntity<String>(ac.createAccount(account, user_id),HttpStatus.OK);
		}
		
		@PutMapping("/account/deposit/{userAccount_id}/{TransferAccount_id}")
		public ResponseEntity<String> DepositAmount(@Valid @PathVariable ("userAccount_id") String userAccount_id ,@PathVariable("TransferAccount_id") String TransferAccount_id ,@RequestParam Integer balance ) throws AccountException{
			
			return new ResponseEntity<String>(ac.transferMoney(userAccount_id, TransferAccount_id, balance),HttpStatus.OK);
		}
		
		@PutMapping("/account/deposit/{userAccount_id}")
		public ResponseEntity<String> DepositAmount(@Valid @PathVariable ("userAccount_id") String userAccount_id ,@RequestParam Integer balance ) throws AccountException{
			
			return new ResponseEntity<String>(ac.depositMoney(userAccount_id, balance),HttpStatus.OK);
		}

	}



	
	
