package com.banking.controller;

import com.banking.Security.JwtUtil;
import com.banking.dto.UserRequest;
import com.banking.dto.UserResponse;
import com.banking.entity.User;
//import com.banking.kafka.UserKafkaProducer;
import com.banking.service.KycService;
import com.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

//    @Autowired
//    private KycService kycService;
/*    @Autowired
    private UserKafkaProducer userKafkaProducer;*/

    //Register a new USer

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> req){
        String username = req.get("username");
        String password = req.get("password");
        String role = req.get("role");
        UserResponse user = userService.register(username,password,role);
        return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", user.getUsername()));
    }

    @PostMapping
   public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.register(userRequest.getUsername(),userRequest.getPassword(),userRequest.getRole());
        //userKafkaProducer.sendMessage(userResponse.toString());
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    //Login and get AWT Token
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String,String> req) throws Throwable {
        String username = req.get("username");
        String password = req.get("password");
        User user = userService.authenticate(username,password);
        UserDetails userDetails = userService.loadUserByUserName(user.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok((User) Map.of("token", token, "role", user.getRole()));
    }
    @PostMapping("/logout")
    public ResponseEntity<User> logout(){
        return ResponseEntity.ok((User) Map.of("message","Logged out successfully"));
    }

}
