package com.example.demo.service.impl;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.service.MyMailService;
import lombok.extern.slf4j.Slf4j;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class MyMailServiceImpl implements MyMailService {

    Map<String, String> env = System.getenv();

    String smtpPassword = env.get("SMTP_PASSWORD");

    public void sendEmail(String to, String subject, String body) {

        Email email = EmailBuilder.startingBlank()
                .to(to)
                .from("mailtrap@demomailtrap.com")
                .withSubject(subject)
                .withPlainText(body)
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("live.smtp.mailtrap.io", 587)
                .withSMTPServerUsername("api")
                .withSMTPServerPassword(smtpPassword)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        mailer.sendMail(email);

        log.info("Email sent successfully!");
    }

    @Override
    public String registrationNotification(RegistrationRequest registrationRequest) {
        return "Hello " + registrationRequest.getUserName() + ",\n\n" +
                "Thank you for your registration at our blog!";
    }
}