package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.entity.UserEntity;
import com.anmoon.mentionbox.enumeration.UserRoleEnum;
import com.anmoon.mentionbox.repository.UserRepository;
import com.anmoon.mentionbox.seedable.Seedable;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserSeeder implements Seedable {
    private final UserRepository userRepository;
    @Autowired
    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void seed() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setRole(UserRoleEnum.USER);
            user.setUsername(faker.internet().username());
            user.setFirstName(faker.name().firstName());
            user.setFirstName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setPoints(faker.number().randomDigit());
            user.setPassword(faker.internet().password());
            userRepository.save(user);
            log.info(user.getEmail());
        }
    }

    @Override
    public void rollback() {
    }
}
