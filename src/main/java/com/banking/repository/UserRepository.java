package com.banking.repository;

import com.banking.entity.User;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findByloadUserByUserName(String username);

    Optional<User> findByUsername(String username);


    // <T> ScopedValue<T> findByUsername(String username);
}
