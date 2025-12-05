package com.banking.controller;

import com.banking.Enum.AccountType;
import com.banking.dto.TransferRequest;
import com.banking.entity.Account;
import com.banking.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Tag(name = "Accounts", description = "Operations related to banking accounts")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Create")
    @ApiResponse(responseCode = "200", description = "Account created successfully" )
    @PostMapping("/create")
    @Transactional
    public Account createAccount(@RequestParam String accountType, @RequestParam double balance) {
        return accountService.createAccount(accountType, balance);
    }

    @Operation(summary = "Get account by ID")
    @ApiResponse(responseCode = "200", description = "Account found")
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) throws AccountNotFoundException {
        return accountService.getAccountById(id);
    }

    @Operation(summary = "Update account balance by ID")
    @ApiResponse(responseCode = "200", description = "Account updated successfully")
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestParam double balance) throws AccountNotFoundException {
        return accountService.updateAccountById(id, balance);
    }

    @Operation(summary = "Close account by ID")
    @ApiResponse(responseCode = "200", description = "Account closed or not found")
    @DeleteMapping("/{id}")
    public String close(@PathVariable Long id) {
        boolean closed = accountService.closeAccount(id);
        return closed ? "Account closed" : "Account not found";
    }

    @Operation(summary = "Get account balance by ID")
    @ApiResponse(responseCode = "200", description = "Balance retrieved")
    @GetMapping("/{id}/balance")
    public ResponseEntity<?> getAccountBalance(@PathVariable Long id) {
        Double balance = accountService.getBalance(id);
        if (balance == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Not found");
        }
        return ResponseEntity.ok(balance);
    }



    @Operation(summary = "Get all accounts sorted by balance")
    @ApiResponse(responseCode = "200", description = "Accounts retrieved")
    @GetMapping("/all")
    public List<Account> getAllAccountSorted(@RequestParam(defaultValue = "true") boolean ascending) {
        return accountService.getAllAccountsBySorted(ascending);
    }

    @Operation(summary = "Get filtered accounts by type and minimum balance")
    @ApiResponse(responseCode = "200", description = "Filtered accounts retrieved")
    @GetMapping("/filtered")
    public List<Account> getFilteredAccountsBySorted(@RequestParam AccountType type, @RequestParam double minBalance) {
        return accountService.getFilteredAccounts(type, minBalance);
    }

   @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestBody TransferRequest transferRequest) {
        String result = accountService.transferFunds(transferRequest.getFromAccountId(),transferRequest.getToAccountId(), Double.parseDouble(transferRequest.getAmount()));
return  new ResponseEntity<>(result, HttpStatus.OK);

}
}