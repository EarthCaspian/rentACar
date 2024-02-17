package com.tobeto.rentACar.core.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Value("${mailgun.domain}")
    private String domain;

    @Value("${mailgun.api.key}")
    private String apiKey;

    @Bean
    public JavaMailSender javaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mailgun.org");
        mailSender.setPort(587);
        mailSender.setUsername(domain);
        mailSender.setPassword(apiKey);

        return mailSender;
    }
}
