package com.saas.authenticationandrole.dao;

import com.saas.authenticationandrole.constants.SQLConstants;
import com.saas.authenticationandrole.service.DatabaseService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestScope
public class AuthenticateExtnDao {

    private Connection conn;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticateExtnDao.class);

    @Autowired
    DatabaseService dbService;

    @PostConstruct
    private void initConnection() throws SQLException {
        this.conn = dbService.getDbConnection();
        logger.info("Created Connection: {}, Autocommit: {}", this.conn.hashCode(), this.conn.getAutoCommit());
    }

    public List<List<String>> getAuthenticationExtnAPIs() {
        List<List<String>> outData = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_AUTHENTICATE_EXTN_APIS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String module = rs.getString(1);
                String hyperlink = rs.getString(2);
                String apiMethod = rs.getString(3);
                List<String> resultList = new ArrayList<>();
                resultList.add(module);
                resultList.add(hyperlink);
                resultList.add(apiMethod);
                outData.add(resultList);
            }
            return outData;
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void destroyConnection() throws SQLException {
        this.conn.close();
        logger.info("Connection Destroyed");
    }
}
