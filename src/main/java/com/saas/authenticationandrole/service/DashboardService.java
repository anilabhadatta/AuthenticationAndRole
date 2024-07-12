package com.saas.authenticationandrole.service;

import com.saas.authenticationandrole.constants.SQLConstants;
import com.saas.authenticationandrole.dao.LinkGenerationDao;
import com.saas.authenticationandrole.dao.UserDetailsDao;
import com.saas.authenticationandrole.dto.UserDetailsDto;
import com.saas.authenticationandrole.dto.response.ResponseDto;
import com.saas.authenticationandrole.util.LinkGenerationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Service
@RequestScope
public class DashboardService {
    private static final Logger logger = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    LinkGenerationDao linkGenerationDao;

    @Autowired
    LinkGenerationUtil linkGenerationUtil;

    @Autowired
    UserDetailsDao userDetailsDao;

    public ResponseDto<Object> getDashboardAPIs(){
        logger.info("Entering getDashboardAPIs");
        return linkGenerationUtil.generateResultApiJson(linkGenerationDao.getAPIs(SQLConstants.GET_DASHBOARD_APIS));
    }

    public ResponseDto<Object> getAdminDashboardAPIs(){
        logger.info("Entering getAdminDashboardAPIs");
        return linkGenerationUtil.generateResultApiJson(linkGenerationDao.getAPIs(SQLConstants.GET_ADMIN_DASHBOARD_APIS));
    }

    public ResponseDto<Object> getAdminUserData() {
        logger.info("Entering getAdminUserData");
        ResponseDto<Object> userDetailsResponseList = new ResponseDto<>();
        List<UserDetailsDto> userDetailsDtoList = userDetailsDao.getAllUserData();
        userDetailsResponseList.setBody(userDetailsDtoList);
        return  userDetailsResponseList;
    }
}
