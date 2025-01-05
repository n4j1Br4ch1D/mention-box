package com.anmoon.mentionbox.event;

import org.springframework.context.ApplicationEvent;

public class ActivateNotificationEvent extends ApplicationEvent {

    private final String username;

    public ActivateNotificationEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
