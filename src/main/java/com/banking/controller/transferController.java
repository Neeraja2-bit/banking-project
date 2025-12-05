package com.banking.controller;

import com.banking.entity.Account;
import com.banking.service.transferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class transferController {

    @Autowired
    private transferService transferService;

    @PostMapping
    public String Transfer(@RequestParam Long fromAccountId,
                           @RequestParam Long toAccountId,
                           @RequestParam Double amount,
                           @RequestParam String transferType) {
        return transferService.transfer(fromAccountId, toAccountId, amount, transferType);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveAccount(@RequestBody Account account) {
        transferService.saveAccount(account);
        return ResponseEntity.ok("Account saved successfully");
    }

}
