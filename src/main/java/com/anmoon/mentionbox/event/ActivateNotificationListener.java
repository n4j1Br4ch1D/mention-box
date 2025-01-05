package com.anmoon.mentionbox.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActivateNotificationListener {

    @EventListener
    public void handleUserRegisteredEvent(ActivateNotificationEvent event) {
        String username = event.getUsername();
        // Implement email sending logic here
        log.info("Sending email to user: " + username);
    }
}
