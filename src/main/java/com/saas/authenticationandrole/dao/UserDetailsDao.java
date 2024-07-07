package com.saas.authenticationandrole.dao;

import com.saas.authenticationandrole.constants.SQLConstants;
import com.saas.authenticationandrole.dto.Role;
import com.saas.authenticationandrole.dto.UserDetailsDto;
import com.saas.authenticationandrole.service.DatabaseService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
@RequestScope
public class UserDetailsDao {

    private Connection conn;
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsDao.class);

    @Autowired
    DatabaseService dbService;

    @PostConstruct
    private void initConnection() throws SQLException {
        this.conn = dbService.getDbConnection();
        logger.info("Created Connection: {}, Autocommit: {}", this.conn.hashCode(), this.conn.getAutoCommit());
    }

    public UserDetailsDto findByUsername(String username) {
        logger.info("Inside Custom FindByUsername UserDetailsDao for username {}", username);
        UserDetailsDto outData = new UserDetailsDto();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try (PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_USERDETAILS_DATA)) {
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString(1);
                    String usernameDb = rs.getString(2);
                    String email = rs.getString(3);
                    String password = rs.getString(4);
                    password = passwordEncoder.encode(password);

                    outData.setId(id);
                    outData.setUsername(usernameDb);
                    outData.setPassword(password);
                    outData.setEmail(email);
                    outData.setRoles(getRolesForUser(id));
                }
            }
            return outData;
        } catch (SQLException e) {
            logger.error("SQLException occurred", e);
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }

    public Set<Role> getRolesForUser(String userId) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_USERROLE_DATA)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                Set<Role> roles = new HashSet<>();
                while (rs.next()) {
                    String roleId = rs.getString("id");
                    String roleName = rs.getString("role_name");
                    roles.add(new Role(roleId, roleName));
                }
                return roles;
            }
        }
    }

    @PreDestroy
    public void destroyConnection() throws SQLException {
        this.conn.close();
        logger.info("Connection Destroyed");
    }
}
