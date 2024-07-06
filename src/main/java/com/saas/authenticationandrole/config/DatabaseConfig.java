package com.saas.authenticationandrole.config;

import lombok.Getter;
import lombok.Setter;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Value("${spring.datasource.url:}")
    private String url;
    @Value("${spring.datasource.username:}")
    private String username;
    @Value("${spring.datasource.password:}")
    private String password;
    @Value("${spring.datasource.sql-for-validate-connection}")
    private String sqlValidationConnection;
    @Value("${spring.datasource.connection-factory-class-name:}")
    private String connectionFactoryClassName;
    @Value("${spring.datasource.connection-pool-name}")
    private String connectionPoolName;
    @Value("${spring.datasource.initial-pool-size}")
    private int initialPoolSize;
    @Value("${spring.datasource.min-pool-size}")
    private int minPoolSize;
    @Value("${spring.datasource.max-pool-size}")
    private int maxPoolSize;
    @Value("${spring.datasource.inactivity-timeout}")
    private int inactivityTimeout;
    @Value("${spring.datasource.abandoned-connection-timeout}")
    private int abandonedConnectionTimeout;
    @Value("${spring.datasource.time-to-live-connection-timeout}")
    private int timeToLiveConnectionTimeout;
    @Value("${spring.datasource.max-connection-reuse-time}")
    private int maxConnectionReuseTime;

    @Bean
    public DataSource dataSource() throws SQLException {
        PoolDataSource poolDataSource = PoolDataSourceFactory.getPoolDataSource();
        poolDataSource.setConnectionFactoryClassName(connectionFactoryClassName);
        poolDataSource.setURL(url);
        poolDataSource.setUser(username);
        poolDataSource.setPassword(password);
        poolDataSource.setConnectionPoolName(connectionPoolName);
        poolDataSource.setValidateConnectionOnBorrow(true);
        poolDataSource.setMaxStatements(10);
        poolDataSource.setInitialPoolSize(initialPoolSize);
        poolDataSource.setMinPoolSize(minPoolSize);
        poolDataSource.setMaxPoolSize(maxPoolSize);
        poolDataSource.setSQLForValidateConnection(sqlValidationConnection);
        poolDataSource.setInactiveConnectionTimeout(inactivityTimeout);
        poolDataSource.setAbandonedConnectionTimeout(abandonedConnectionTimeout);
        poolDataSource.setTimeToLiveConnectionTimeout(timeToLiveConnectionTimeout);
        poolDataSource.setMaxConnectionReuseTime(maxConnectionReuseTime);
        return poolDataSource;
    }

}