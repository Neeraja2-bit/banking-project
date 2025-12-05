package com.banking.service;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.repository.AccountRepository;
import com.banking.repository.transferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class transferService {

    @Autowired
    private transferRepository transferRepository;
    @Autowired
    private AccountRepository accountRepository;

    public String transfer(Long fromAccountId, Long toAccountId, double amount, String transferType) {
        Account fromAccount= transferRepository.findByAccountId(fromAccountId);
        Account toAccount = transferRepository.findByAccountId(toAccountId);

        if(fromAccount==null || toAccount == null|| !fromAccount.isActive() || !toAccount.isActive()){
            return "Account not found";
        }
        if(fromAccount.getBalance()<amount){
            return "Insufficient funds";
        }
 /*       if(amount>getLimit(transferType)){
            return "Amount exceeded";
        }*/
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        fromAccount.setBalance(toAccount.getBalance()+amount);
        //transferRepository.saveAccount(fromAccount);
        //transferRepository.saveAccount(toAccount);

        Transaction  transaction = new Transaction();
        transaction.setFromAccountId(fromAccountId);
        transaction.setToAccountId(toAccountId);
        transaction.setAmount(amount);
        transaction.setTransferType(transferType);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("Success");
        transferRepository.save(transaction);

        return transferType;
    }

    public void saveAccount(Account toaccount) {
            accountRepository.save(toaccount);
        }

    }

