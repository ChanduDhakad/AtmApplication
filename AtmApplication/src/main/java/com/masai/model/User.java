package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Data
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer userId;
	@NotNull(message = "first Name  cannot set as null")
	@NotEmpty(message = "first Name  cannot set as empty")
	@NotBlank(message = "first Name  cannot set as blank")
	@Pattern(regexp = "[A-Za-z]")
	private String firstName;
	
	
	@NotNull(message = "last Name  cannot set as null")
	@NotEmpty(message = "last Name cannot set as empty")
	@NotBlank(message = "last Name cannot set as blank")
	@Pattern(regexp = "[A-Za-z]")
	private String lastName;
	
	
	@NotNull(message = "contact cannot set as null")
	@Column(unique = true)
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNumber;
	
	
	@NotNull(message = "address cannot set as null")
	@NotEmpty(message = "address cannot set as empty")
	@NotBlank(message = "address cannot set as blank")
	private String address;
	
	@NotNull(message = "age cannot set as null")
	@NotEmpty(message = "age cannot set as empty")
	@NotBlank(message = "age cannot set as blank")
	@Min(value = 12,message = "Age Must Greater Than 12 Year")
	private String age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotNull(message = "password cannot set as null")
	@NotEmpty(message = "password cannot set as empty")
	@NotBlank(message = "password cannot set as blank")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{6, 12}$")
	private String password;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
  	private Bank bank;
	
	
	@OneToMany(cascade = CascadeType.ALL)
  	private List<Account> accounts=new ArrayList<>();
	
	
	
	
//	private Integer budget;
//	
//
//	@OneToOne(cascade = CascadeType.ALL)
//	private Cart cart;
//	
}

