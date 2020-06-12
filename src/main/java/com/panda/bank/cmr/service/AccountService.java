package com.panda.bank.cmr.service;
import java.security.Principal;

import com.panda.bank.cmr.model.PrimaryAccount;
import com.panda.bank.cmr.model.SavingsAccount;



public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
    
    
}
