package com.panda.bank.cmr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.model.SavingsTransaction;

public interface SavingsTransactionDao extends
  CrudRepository<SavingsTransaction, Long> {
 
  List<SavingsTransaction> findAll(); 
  }
 