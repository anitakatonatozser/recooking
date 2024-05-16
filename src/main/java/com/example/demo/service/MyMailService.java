package com.example.demo.service;

import com.example.demo.dto.RegistrationRequest;

public interface MyMailService {
    void sendEmail(String to, String subject, String body);
    String registrationNotification(RegistrationRequest registrationRequest);
}