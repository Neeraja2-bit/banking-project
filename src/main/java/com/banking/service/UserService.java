package com.banking.service;

import com.banking.dto.UserRequest;
import com.banking.dto.UserResponse;
import com.banking.entity.User;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public User register(String Username, String password, String role) {
//        User user = new User();
//        user.setUsername(Username);
//        user.setPassword(password);
//        user.setRole(role);
//        return userRepository.save(user);
//    }
    public UserResponse register(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getUsername(), savedUser.getRole());
    }

    public User authenticate(String username, String password) throws Throwable {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("USer is not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new BadCreditianlException("Invalid Credentials");
        }
    }

    public UserDetails loadUserByUserName(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("USer is not found"));
        return  new org.springframework.security.core.userdetails.User(
          user.getUsername(),
          user.getPassword(),
          Collections.singleton(new SimpleGrantedAuthority("ROLE_"+ user.getRole()))
            );
}

    private Object newUsernameNotFoundException(String uSerIsNotFound) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}


