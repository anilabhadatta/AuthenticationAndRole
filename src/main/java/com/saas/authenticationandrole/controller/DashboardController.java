package com.saas.authenticationandrole.controller;

import com.saas.authenticationandrole.dto.response.ResponseDto;
import com.saas.authenticationandrole.service.DashboardService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/api/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardController {
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    DashboardService dashboardService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getDashBoardApis")
    public ResponseEntity<?> getDashboardApis() {
        ResponseDto<Object> output = dashboardService.getDashboardAPIs();
        logger.info(output.toString());
        return ResponseEntity.ok(output);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/getAdminDashBoardApis")
    public ResponseEntity<?> getAdminDashboardApis() {
        ResponseDto<Object> output = dashboardService.getAdminDashboardAPIs();
        logger.info(output.toString());
        return ResponseEntity.ok(output);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/getUserData")
    public ResponseEntity<?> getUserData() {
        ResponseDto<Object> output = dashboardService.getAdminUserData();
        logger.info(output.toString());
        return ResponseEntity.ok(output);
    }

}
