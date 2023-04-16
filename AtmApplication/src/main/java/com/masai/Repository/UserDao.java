package com.masai.Repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

   public User findByMobileNumber(String mobileNumber);
	@Query("from user")
	public Page<User> getAllUsers(Pageable p);
}
