package com.anmoon.mentionbox.service;

import com.anmoon.mentionbox.client.OmdbFeignClient;
import com.anmoon.mentionbox.dto.response.ItemResponse;
import com.anmoon.mentionbox.entity.UserEntity;
import com.anmoon.mentionbox.enumeration.UserRoleEnum;
import com.anmoon.mentionbox.event.ActivateNotificationEvent;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OmdbService {

    private final OmdbFeignClient omdbFeignClient;
    private final ApplicationEventPublisher eventPublisher;

    @Value("${omdb.api.key}")
    private String apiKey;

    public OmdbService(OmdbFeignClient omdbFeignClient, ApplicationEventPublisher eventPublisher) {
        this.omdbFeignClient = omdbFeignClient;
        this.eventPublisher = eventPublisher;
    }

    public ItemResponse getMovieDetails(String title) {
        Faker faker = new Faker();
        UserEntity user = new UserEntity();
        user.setRole(UserRoleEnum.USER);
        user.setUsername(faker.internet().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPoints(faker.number().randomDigit());
        user.setPassword(faker.internet().password());
        log.info("heloo! {}", user);
        eventPublisher.publishEvent(new ActivateNotificationEvent(this, user.getUsername()));
        return omdbFeignClient.getMovieDetails(apiKey, title);

    }
}
