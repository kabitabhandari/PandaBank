package com.panda.bank.cmr.dao;

import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.model.SavingsAccount;

/**
 * Created by z00382545 on 10/21/16.
 */
public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);
}
