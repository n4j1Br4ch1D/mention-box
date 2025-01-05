package com.anmoon.mentionbox;

import com.anmoon.mentionbox.entity.UserEntity;
import com.anmoon.mentionbox.enumeration.UserRoleEnum;
import com.anmoon.mentionbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class MyCustomCommand {

    public static void main(String[] args) {
        // Your custom command logic goes here
        // Initialize the Spring ApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(MentionboxApplication.class);

        // Retrieve the repository bean
        UserRepository userRepository = context.getBean(UserRepository.class);

        System.out.println("Executing my custom command...");
        UserEntity user = new UserEntity();
        user.setRole(UserRoleEnum.USER);
        user.setUsername("Admin");
        user.setFirstName("Jhon");
        user.setFirstName("Doe");
        user.setEmail("JhonDoe@example.com");
        user.setPoints(224);
        user.setPassword("password#123");
        userRepository.save(user);
    }
}

