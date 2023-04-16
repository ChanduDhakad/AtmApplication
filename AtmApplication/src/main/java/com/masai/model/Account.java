package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private String accountNo;
	private String ifsc;
	private LocalDateTime accountOpen;
	private Integer balance;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	  private Bank bank;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	  private User user;
	
}
