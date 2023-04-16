package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Event {
   
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eventId;
	
	//@Enumerated
  private String type;
  private LocalDateTime startingDate;
  private LocalDateTime endingDate;
	 
  
  @ManyToOne
  User user;
	  
	  
}
