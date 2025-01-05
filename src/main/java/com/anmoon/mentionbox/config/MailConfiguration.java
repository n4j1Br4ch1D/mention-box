package com.anmoon.mentionbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost"); // Use the host where your SMTP server is running (e.g., MailHog)
        mailSender.setPort(1025); // Specify the port used by your SMTP server (e.g., MailHog's default port)

//        mailSender.setUsername("your-username"); // If authentication is required
//        mailSender.setPassword("your-password"); // If authentication is required

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
