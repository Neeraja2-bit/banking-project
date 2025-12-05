package com.banking.service;

import com.banking.Enum.AccountType;
import com.banking.entity.Account;
import com.banking.exceptions.InvalidAccountException;
import com.banking.repository.AccountRepository;

import com.banking.specification.AccountSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String type, double balance) {
        if (type == null) {
            throw new InvalidAccountException("Account type cannot be null");
        }
        if (balance < 0) {
            throw new InvalidAccountException("Initial balance cannot be negative");
        }

        Account acc = new Account();
        acc.setBalance(balance);
        acc.setAccountType(AccountType.valueOf(type));
        acc.setStatus("ACTIVE"); // Optional: set default status

        Account savedAccount = accountRepository.save(acc);

        // ✅ Add this line to confirm save
        System.out.println("Account saved: " + savedAccount);

        return savedAccount;
    }
    public Account getAccountById(@PathVariable Long id) throws AccountNotFoundException {
        List<Account> accounts = accountRepository.findAccountById(id);
        if (accounts.isEmpty()) {
            throw new AccountNotFoundException();
        }
        return accounts.get(0); // or handle multiple accounts if needed
    }
    public Account updateAccountById(Long id, double balance) throws AccountNotFoundException {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
        account.setBalance(balance);
        return accountRepository.save(account);

    }
    public boolean closeAccount(Long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent()) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Double getBalance(@PathVariable double balance){
        Account acc = (Account) accountRepository.findAccountByBalance(balance).orElse(null);
        return (acc != null && acc.isActive()) ? acc.getBalance() : null;
    }
    public List<Account> getAllAccountsBySorted(boolean ascending) {
        Sort sort = ascending ? Sort.by("balance").ascending() : Sort.by("balance").descending();
        return accountRepository.findAll();
    }
    public List<Account> getFilteredAccounts(@RequestParam AccountType type, double minBalance) {
        Specification<Account> spec = Specification
                .allOf(AccountSpecifications.hasAccountType(type))
                .and(AccountSpecifications.hasMinimumBalance(minBalance))
                .and(AccountSpecifications.isActive());
        return accountRepository.findAll(spec);
    }
   /* Validations:

    Both accounts must exist.
    Amount must be positive.
    Source account must have sufficient balance.
    Update balances and save both accounts.*/

    public String transferFunds(Long fromAccountId, Long toAccountId, double amount) {
        if(amount<= 0){
            throw new InvalidAccountException("Amount cannot be negative");
        }
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new InvalidAccountException("Account not found with id: " + fromAccountId));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(() ->new InvalidAccountException("Account not found with id: " + toAccountId));

        if(fromAccount.getBalance()<amount){
            throw  new InvalidAccountException("Insufficient funds in Source Account");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return  "Transfer Successful"+ amount + "transferred Account" +fromAccountId + "to" + toAccountId;
    }
}



