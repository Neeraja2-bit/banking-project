package com.banking.service;

import com.banking.entity.Transaction;
import com.banking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> getAll(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return transactionRepository.findAll(pageable);
    }

    public Optional<Transaction> filterByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByTimestampBetween(startDate,endDate);
    }
    public  Optional<Transaction> filterByAmount(double minAmount){
        return transactionRepository.findByMinAmount(minAmount);
    }
    public Optional<Transaction> filterByType(String type){
        return transactionRepository.findByType(type);
    }

}
