package com.anmoon;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Seeder {
    public Boolean excuteFile(DataSource dataSource, Path filePath) throws IOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            String sql = new String(bytes, StandardCharsets.UTF_8);
            jdbcTemplate.execute(sql);
        } catch (IOException e) {
            throw new RuntimeException("Error reading SQL file: " + filePath.toString(), e);
        }
        return false;
    }

    public Boolean excuteFile(String fileName) throws IOException {
       return false;
    }

    public Boolean ExcuteQuery(String query) throws IOException {
        return false;
    }

    public Boolean ExcuteQuery(String query, boolean isNative) throws IOException {
        return false;
    }
}
