package com.banking.controller;

import com.banking.entity.Transaction;
import com.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/all")
 public Page<Transaction> getAll(@RequestParam (defaultValue = "0")int page,
                                 @RequestParam(defaultValue = "10")int size,
                                 @RequestParam(defaultValue = "timeStamp")String sortBy,
                                 @RequestParam(defaultValue = "asc")Sort.Direction direction){
        return transactionService.getAll(page, size, sortBy, direction);
    }
    @GetMapping("/filter/date")
    public Optional<Transaction> filterByDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
/*        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);*/
        return transactionService.filterByDate(startDate,endDate);
    }
    @GetMapping("/filter/amount")
    public Optional<Transaction> filterByAmount(@RequestParam double minAmount){
        return transactionService.filterByAmount(minAmount);
    }
    @GetMapping("/filter/type")
    public Optional<Transaction> filterByType(@RequestParam String type){
        return transactionService.filterByType(type);
    }
}
