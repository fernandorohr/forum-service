package com.fernando.forumservice.email.facade;

import com.fernando.forumservice.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailFacade {

    private final EmailService emailService;

    public void sendEmail(String destination, String name) {
        emailService.sendEmail(destination, name);
    }
}
