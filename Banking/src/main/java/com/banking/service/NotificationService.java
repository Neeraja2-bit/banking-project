package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTransactionAlert(String toEmail, String message) {
        System.out.println("sendTransactionAlert called with: " + toEmail);
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("neeraja20899@gmail.com");
            mailMessage.setTo("neerajakumarid@gmail.com");
            mailMessage.setSubject("Transaction Alert Sent");
            mailMessage.setText(message);
            javaMailSender.send(mailMessage);
            System.out.println(" Email sent successfully to: " + toEmail);
        } catch (Exception e) {
            System.out.println(" Email not sent to: " + toEmail);
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}