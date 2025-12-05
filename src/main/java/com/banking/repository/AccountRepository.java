package com.banking.repository;

import com.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//public interface AccountRepository extends JpaRepository<Account, Long> {
//    Optional<Account> findById(Long id);
//}
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
List<Account> findAll();

@Query("select a from Account a where a.id =:id")
List<Account> findAccountById(Long id);

@Query("select a from Account a where a.balance= :balance")
Optional<Object> findAccountByBalance(Double balance);
}