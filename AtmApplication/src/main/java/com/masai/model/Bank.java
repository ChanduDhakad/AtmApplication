package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bank {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	private String name;
    private String headOfficeAt;
	
     @OneToOne(cascade = CascadeType.ALL)
     private User user;

     @OneToMany(cascade = CascadeType.ALL)
     private List<Account>accounts=new ArrayList<>();
	
	
	
	
	
}
