package com.saas.authenticationandrole.service;

import com.saas.authenticationandrole.constants.SQLConstants;
import com.saas.authenticationandrole.dao.LinkGenerationDao;
import com.saas.authenticationandrole.dto.response.ResponseDto;
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
    LinkGenerationDao linkGenerationDao;

    @Autowired
    LinkGenerationUtil linkGenerationUtil;

    public ResponseDto<Object> getAuthenticateExtnAPIs(){
        logger.info("Entering getAuthenticateExtnAPIs");
        return linkGenerationUtil.generateResultApiJson(linkGenerationDao.getAPIs(SQLConstants.GET_AUTHENTICATE_EXTN_APIS));
    }
}
