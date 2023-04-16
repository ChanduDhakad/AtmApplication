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
	public class UserController {
		@Autowired
		UserService userServicevice;
		
		@PostMapping("/User")
		public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) throws UserException{
			
			       User res=userServicevice.createUser(user);
			
			return new ResponseEntity<User>(res,HttpStatus.CREATED);
			
		}
		
		
		@PostMapping("/User/login")
		public ResponseEntity<String> CreateUser(@Valid @RequestBody LoginDto dto) throws LoginException{
			
			return new ResponseEntity<String>(userServicevice.LoginUser(dto),HttpStatus.OK);
			
		}
		
		@GetMapping("/getSortedUsers/{field}")
		public ResponseEntity<List<User>> GetUSerListBySorting(@Valid @PathVariable("field") String field,@RequestParam("direction") String direction) throws UserException{
			
			List<User> list=userServicevice.SortByNameOrAddress(field, direction);
			
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
			
			
		}
		
		@GetMapping("/users/{pageNo}/{noOfRec}")
		public ResponseEntity<List<User>> getUserPageWise(@Valid @PathVariable("pageNo") Integer pageNo, @RequestParam("noOfRec") Integer noOfRec){
			
			return new ResponseEntity<List<User>>(userServicevice.getAllUserByPageWise(pageNo, noOfRec),HttpStatus.OK);
		}

	}



	
	
