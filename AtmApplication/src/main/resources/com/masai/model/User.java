package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
   
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	  private String email;
	  private String firstName;
	  private String lastName;
	  private String mobileNumber;
	  private LocalDate dateOfBirth;
	  private String password;
	  
	  
	  @OneToMany
	    @JsonIgnore
	    private List<Event> event;
}
