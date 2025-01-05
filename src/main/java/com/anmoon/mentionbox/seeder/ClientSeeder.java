package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.seedable.Seedable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientSeeder implements Seedable {

    private final JdbcTemplate jdbcTemplate;

    public ClientSeeder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void seed() {
        // Your seeding logic using a query
        String sql = "INSERT INTO nullsettingentity (key, value) VALUES (?, ?)";
        jdbcTemplate.update(sql, "key1", "value1");
        jdbcTemplate.update(sql, "key2", "value2");
    }

    @Override
    public void rollback() {

    }
}
