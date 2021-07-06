package com.fernando.forumservice.email.service;

import com.fernando.forumservice.email.configuration.EmailConfiguration;
import com.fernando.forumservice.exception.UnprocessableEntityException;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailConfiguration emailConfiguration;

    public void sendEmail(String destination, String name) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailConfiguration.getFromAddress());
            helper.setTo(destination);
            helper.setSubject(emailConfiguration.getSubject());
            helper.setText(emailConfiguration.getText(name));
            helper.addInline("INCRIA", getImage());

            javaMailSender.send(message);
        } catch (MessagingException exception) {
            throw new UnprocessableEntityException("Falha ao enviar o email | Erro " + exception.getMessage());
        }
    }

    private Resource getImage() {
        return new ClassPathResource(emailConfiguration.getImagePath());
    }
}
