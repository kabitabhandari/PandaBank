package com.panda.bank.cmr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.model.PrimaryTransaction;



public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
