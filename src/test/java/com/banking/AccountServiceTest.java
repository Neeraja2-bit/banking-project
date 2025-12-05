/*
package com.banking;

import com.banking.Enum.AccountType;
import com.banking.entity.Account;
import com.banking.exceptions.InvalidAccountException;
import com.banking.repository.AccountRepository;
import com.banking.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void testCreateAccount_Success() {
        Account account = new Account();
        account.setAccountType(AccountType.CURRENT);
        account.setBalance(10000.0);
        when(accountRepository.save(account)).thenReturn(account);
        Account result = accountService.createAccount(AccountType.CURRENT, 10000.0);
        assertNotNull(result);
        assertEquals(account.getAccountType(), account.getBalance());
        assertEquals(10000.0, result.getBalance());
    }
    @Test
    void testCreateAccount_InvalidAccountType() {
        InvalidAccountException exception = assertThrows(InvalidAccountException.class, () -> {
            accountService.createAccount(null, 10000.0);
        });
        assertEquals("Invalid account type", exception.getMessage());
    }

    @Test
    void testGetAccountById_Success() throws AccountNotFoundException {
        Account account =  new Account();
        account.setId(1L);
        account.setBalance(10000.0);
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        Optional<Account> result = accountService.getAccountById(1L);
        assertTrue(result.isPresent());
        assertEquals(account.getAccountType(), account.getBalance());
        assertEquals(10000.0, result.get().getBalance());

    }
    @Test
    void testCreateAccount_NotFound(){
        Long id = 22L;
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () ->{
            accountService.getAccountById(id);
        });

    }
    @Test
    void testUpdateAccount_Valid(){
        Account account = new Account();
        account.setId(1L);
        account.setBalance(10000.0);
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        when(accountRepository.save(account)).thenReturn(account);
        Account updated =  accountService.updateAccountById(1L,10000.0);
        assertNotNull(updated);
        assertEquals(account.getBalance(), updated.getBalance());
        assertEquals(10000.0, updated.getBalance());
    }
    @Test
    void testUpdateAccount_Invalid(){
        Long id = 22L;
        Double amount = 10000.0;
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        Account updated =  accountService.updateAccountById(id,amount);
        assertNull(updated);
    }
}
*/
