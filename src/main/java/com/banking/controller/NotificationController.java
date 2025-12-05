package com.banking.controller;

import com.banking.service.NotificationService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendEmail(@RequestParam String toEmail,@RequestParam String message) {
        notificationService.sendTransactionAlert(toEmail,message);
        return "Email sent successfully!";
    }
    @GetMapping("/send")
    public String sendTestmail(@RequestParam String toEmail,@RequestParam String message) {
        notificationService.sendTransactionAlert(toEmail,message);
        return "Email sent successfully!";
    }






}
