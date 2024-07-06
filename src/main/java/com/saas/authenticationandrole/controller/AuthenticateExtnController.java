package com.saas.authenticationandrole.controller;

import com.saas.authenticationandrole.dto.LinkGenerationDto;
import com.saas.authenticationandrole.service.AuthenticateExtnService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/api/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticateExtnController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateExtnController.class);

    @Autowired
    AuthenticateExtnService authenticateExtnService;

    @GetMapping("/getApis")
    public LinkGenerationDto getAuthenticateAPIs(){
        LinkGenerationDto output = authenticateExtnService.getAuthenticateExtnAPIs();
        logger.info(String.valueOf(output));
        return output;
    }
}
