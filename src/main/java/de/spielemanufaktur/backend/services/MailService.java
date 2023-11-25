package de.spielemanufaktur.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    private JavaMailSender mail;

    @Value("${business.email}")
    private String emailTo;

    public void sendMail(String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailTo);
        message.setSubject(subject);
        message.setText(body);
        mail.send(message);
    }
}
