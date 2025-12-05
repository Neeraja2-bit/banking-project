package com.banking.repository;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transferRepository extends JpaRepository<Transaction, Long> {
//Optional<Account> getAccount(Long fromAccountId);
    Account findByAccountId(Long account);

    //void saveAccount(Account toAccount);
}
