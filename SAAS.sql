CREATE TABLE our_object (
    Id NUMBER(10) GENERATED ALWAYS AS IDENTITY,
    module varchar(255),
    service varchar(255),
    hyperlink varchar(255),
    description varchar(255),
    apimethod varchar(255),
    CONSTRAINT PK_PAGE_DETAILS PRIMARY KEY (Id)
);

select * from our_object;

INSERT INTO our_object  
(module, service, hyperlink, description, apimethod)  
VALUES  
('RS.AUTHENTICATE.LOGIN', 'REST_SERVICE', '/api/authenticate/login', 'This api is used for logging in portal', 'POST');  

INSERT INTO our_object  
(module, service, hyperlink, description, apimethod)  
VALUES  
('RS.AUTHENTICATE.SIGNUP', 'REST_SERVICE', '/api/authenticate/signup', 'This api is used for signup in portal', 'POST');  


INSERT INTO our_object  
(module, service, hyperlink, description, apimethod)  
VALUES  
('RS.AUTHENTICATE.LINKGENUTIL.URLS', 'REST_SERVICE', '/api/authenticate/getUrls', 'This api is used to get Authenticate APIs', 'GET'); 

INSERT INTO our_object  
(module, service, hyperlink, description, apimethod)  
VALUES  
('RS.DASHBOARD.LINKGENUTIL.URLS', 'REST_SERVICE', '/api/dashboard/getDashBoardApis', 'This api is used to get Dashboard APIs', 'GET'); 

INSERT INTO our_object  
(module, service, hyperlink, description, apimethod)  
VALUES  
('RS.DASHBOARD.ADMIN.LINKGENUTIL.URLS', 'REST_SERVICE', '/api/dashboard/admin/getAdminDashBoardApis', 'This api is used to get Admin Dashboard APIs', 'GET'); 

INSERT INTO our_object  
(module, service, hyperlink, description, apimethod)  
VALUES  
('RS.DASHBOARD.ADMIN.USERDATA', 'REST_SERVICE', '/api/dashboard/admin/getUserData', 'This api is used to get Admin Dashboard User Data', 'GET'); 



CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE roles (
    id VARCHAR(36) PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);
CREATE TABLE user_roles (
    user_id VARCHAR(36),
    role_id VARCHAR(36),
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users (id, username, email, password) VALUES 
('1', 'user1', 'user1@example.com', 'password1');

INSERT INTO users (id, username, email, password) VALUES 
('2', 'user2', 'user2@example.com', 'password2');

INSERT INTO roles (id, role_name) VALUES 
('1', 'ROLE_USER');

INSERT INTO roles (id, role_name) VALUES 
('2', 'ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES 
('1', '1'); -- user1 has ROLE_USER

INSERT INTO user_roles (user_id, role_id) VALUES 
('1', '2'); -- user1 also has ROLE_ADMIN

INSERT INTO user_roles (user_id, role_id) VALUES 
('2', '1'); -- user2 has ROLE_USER

SELECT id, username, email, password FROM users WHERE username = 'user1';
