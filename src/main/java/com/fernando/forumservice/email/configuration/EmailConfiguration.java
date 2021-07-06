package com.fernando.forumservice.email.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@Getter
@Configuration
public class EmailConfiguration {
    @Value("${email.from}")
    private String fromAddress;
    @Value("${email.subject}")
    private String subject;
    @Value("${email.image-path}")
    private String imagePath;

    public String getText(String name) {
        return "Olá, " + name + ". Seja bem vindo ao grupo de pesquisa INCRIA";
    }
}
