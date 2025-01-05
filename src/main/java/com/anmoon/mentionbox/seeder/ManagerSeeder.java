package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.entity.SettingEntity;
import com.anmoon.mentionbox.seedable.Seedable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class ManagerSeeder implements Seedable {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
//    @Transactional
    public void seed() {
        // Your seeding logic using JPQL query
        // Your seeding logic using JPQL to create and persist entities
        SettingEntity entity1 = new SettingEntity("key3", "value3");
        SettingEntity entity2 = new SettingEntity("key4", "value4");

        entityManager.persist(entity1);
        entityManager.persist(entity2);
        entityManager.flush(); // Explicitly flush the persistence context

    }

    @Override
    public void rollback() {

    }
}
