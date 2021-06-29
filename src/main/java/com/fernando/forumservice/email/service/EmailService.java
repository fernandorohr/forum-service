package com.fernando.forumservice.email.service;

import com.fernando.forumservice.email.configuration.EmailConfiguration;
import com.fernando.forumservice.exception.UnprocessableEntityException;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;

@Service
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailConfiguration emailConfiguration;

    public void sendEmail(String destination) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailConfiguration.getFromAddress());
            helper.setTo(destination);
            helper.setSubject(emailConfiguration.getSubject());
            helper.setText(emailConfiguration.getText());
//            helper.addAttachment("Invoice", getImage());

            javaMailSender.send(message);
        } catch (MessagingException exception) {
            throw new UnprocessableEntityException("Falha ao enviar o email");
        }
    }

    private FileSystemResource getImage() {
        return new FileSystemResource(new File("hello.txt"));
    }
}
