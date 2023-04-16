
package com.masai.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

@AllArgsConstructor
@Data
public class CurrentSession {
	
	
	@javax.persistence.Id
	private Integer Id;
	
	private String uuid;
	
	

	

}
