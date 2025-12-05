/*
package com.banking;

import com.banking.entity.Transaction;
import com.banking.repository.TransactionRepository;
import com.banking.service.TransactionService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void  testGetAllPaginationAndSorting(){
        Transaction transaction = new Transaction(100.0, "DEPOSIT");
        Transaction transaction1 = new Transaction(200.0, "DEPOSIT");
        List<Transaction> transactionList = Arrays.asList(transaction, transaction1);
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "timestamp");
        when(transactionRepository.findAll()).thenReturn(transactionList);
        List<Transaction> result = transactionService.getAll(0,1,"ASC",Sort.Direction.ASC);
        assertEquals(2,result.size());
        verify(transactionRepository,times(1)).findAll(pageable);
    }

    @Test
    void testFilterByDate(){
        LocalDateTime startDate = LocalDateTime.of(2020,01,01,01,01);
        LocalDateTime endDate = LocalDateTime.of(2020,01,01,01,01);
        Transaction t= new Transaction(1L,LocalDateTime.of(2020,01,01,01,01),120.0,"DePOSIT");
        Transaction t1 = new Transaction(1L,LocalDateTime.of(2020,01,01,01,01),120.0,"DePOSIT"));

        List<Transaction> expectedTransactions = Arrays.asList(t, t1);

        when(transactionRepository.findByTimestampBetween(startDate, endDate)).thenReturn(expectedTransactions);

        // Act
        List<Transaction> result = transactionService.filterByDate(startDate, endDate);

    }
    @Test
    void testFilterByAmount(){
        TransactionService transactionService = new TransactionService();
        double amount = 120.0;
        List<Transaction> mockTransactions = new ArrayList<>();
        mockTransactions.add(new Transaction(1L,"DEPOSIT"));
        mockTransactions.add(new Transaction(2L,"DEPOSIT"));
        when(transactionRepository.findByMinAmount(amount)).thenReturn(mockTransactions);
        Optional<Transaction> result = transactionService.filterByAmount(amount);
        assertEquals(2,result.size());

    }

}
*/
