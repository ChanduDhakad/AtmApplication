package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentSession;



public interface CurrentDao extends JpaRepository<CurrentSession, Integer>{

}
