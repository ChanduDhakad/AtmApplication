package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Bank;
@Repository
public interface BankDao extends JpaRepository<Bank, Integer> {

}
