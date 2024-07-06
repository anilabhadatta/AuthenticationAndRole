package com.saas.authenticationandrole.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@RequestScope
public class DatabaseService {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    @Autowired
    DataSource dataSource;

    public Connection getDbConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }
}
