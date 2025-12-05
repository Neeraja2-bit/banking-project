package com.banking.repository;

import com.banking.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("select t from Transaction t")
    Page<Transaction> findAll(Pageable pageable);

    @Query("SELECT t from Transaction t where t.timestamp BETWEEN :startDate and :endDate")
    Optional<Transaction> findByTimestampBetween(@Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);

    @Query("select t from Transaction t where t.amount>= :minAmount")
    Optional<Transaction> findByMinAmount(double minAmount);

    @Query("select t from Transaction t where t.timestamp = :type")
    Optional<Transaction> findByType(String type);
}
