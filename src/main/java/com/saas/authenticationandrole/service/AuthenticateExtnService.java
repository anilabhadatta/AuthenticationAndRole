package com.saas.authenticationandrole.service;

import com.saas.authenticationandrole.dao.AuthenticateExtnDao;
import com.saas.authenticationandrole.dto.LinkGenerationDto;
import com.saas.authenticationandrole.util.LinkGenerationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class AuthenticateExtnService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticateExtnService.class);

    @Autowired
    AuthenticateExtnDao authenticateExtnDao;

    @Autowired
    LinkGenerationUtil linkGenerationUtil;

    public LinkGenerationDto getAuthenticateExtnAPIs(){
        logger.info("Entering AuthenticateExtnService");
        return linkGenerationUtil.generateResultApiJson(authenticateExtnDao.getAuthenticationExtnAPIs());
    }
}
