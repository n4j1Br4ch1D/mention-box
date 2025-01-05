package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.seedable.Seedable;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder1 implements Seedable {

    @Override
    public void seed() {

    }

    @Override
    public void rollback() {
        // Implement rollback logic if needed
    }
}
