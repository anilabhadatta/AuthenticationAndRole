CREATE TABLE our_object (
    Id NUMBER(10) GENERATED ALWAYS AS IDENTITY,
    module varchar(255),
    service varchar(255),
    hyperlink varchar(255),
    description varchar(255),
    apimethod varchar(255),
    CONSTRAINT PK_PAGE_DETAILS PRIMARY KEY (Id)
);


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