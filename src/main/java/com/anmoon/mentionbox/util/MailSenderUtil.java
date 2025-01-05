package com.anmoon.mentionbox.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSenderUtil {

    private MailSenderUtil() {
        // Private constructor to prevent instantiation
    }

    public static void sendNewMail(JavaMailSender mailSender, String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
