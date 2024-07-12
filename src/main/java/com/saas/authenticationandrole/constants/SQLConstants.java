package com.saas.authenticationandrole.constants;

public class SQLConstants {

    public static final String GET_AUTHENTICATE_EXTN_APIS = "select module, hyperlink, apimethod from our_object where module like 'RS.AUTHENTICATE.EXTN%'";
    public static final String GET_USERDETAILS_DATA =  "SELECT id, username, email, password FROM users WHERE username = ?";
    public static final String GET_USERROLE_DATA = "SELECT r.id, r.role_name FROM roles r " +
            "JOIN user_roles ur ON r.id = ur.role_id " +
            "JOIN users u ON ur.user_id = u.id " +
            "WHERE u.id = ?";
    public static final String GET_DASHBOARD_APIS = "select module, hyperlink, apimethod from our_object where module like 'RS.DASHBOARD.LINKGENUTIL%' OR module LIKE 'RS.DASHBOARD.ADMIN.LINKGENUTIL%'";
    public static final String GET_ADMIN_DASHBOARD_APIS = "select module, hyperlink, apimethod from our_object where module like 'RS.DASHBOARD.ADMIN%'";
    public static final String GET_ALL_USERDATA = "SELECT u.id, u.username, u.email, u.password, r.id AS role_id, r.role_name " +
            "FROM users u " +
            "JOIN user_roles ur ON u.id = ur.user_id " +
            "JOIN roles r ON ur.role_id = r.id";
}
