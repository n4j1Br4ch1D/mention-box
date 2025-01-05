package com.anmoon.mentionbox.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrefixPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static String TABLE_NAME_PREFIX;

    @Value("${spring.jpa.hibernate.naming.prefix:default_}")
    public void setTableNamePrefix(String prefix) {
        TABLE_NAME_PREFIX = prefix;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        Identifier newIdentifier = new Identifier(TABLE_NAME_PREFIX + name.getText(), name.isQuoted());
        return super.toPhysicalTableName(newIdentifier, context);
    }
}
