package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.entity.UserEntity;
import com.anmoon.mentionbox.enumeration.UserRoleEnum;
import com.anmoon.mentionbox.repository.UserRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder {
//    private UserRepository userRepository;

//    @Autowired
//    public AdminSeeder() {
//        this.userRepository = userRepository;
//    }

    private void seedAdmins() {
        Faker faker = new Faker();

        UserEntity admin = new UserEntity();
        admin.setRole(UserRoleEnum.ADMIN);
        admin.setUsername(faker.internet().username());
        admin.setFirstName(faker.name().firstName());
        admin.setFirstName(faker.name().lastName());
        admin.setEmail(faker.internet().emailAddress());
        admin.setPoints(21);
        admin.setPassword(faker.internet().password());
//        userRepository.save(admin);
    }
}
