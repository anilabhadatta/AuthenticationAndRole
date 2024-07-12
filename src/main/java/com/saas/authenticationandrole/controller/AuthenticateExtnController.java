package com.saas.authenticationandrole.controller;

import com.saas.authenticationandrole.dto.UserDetailsDto;
import com.saas.authenticationandrole.dto.request.LoginRequestDto;
import com.saas.authenticationandrole.dto.response.JwtResponseDto;
import com.saas.authenticationandrole.dto.response.ResponseDto;
import com.saas.authenticationandrole.filter.JwtUtils;
import com.saas.authenticationandrole.service.AuthenticateExtnService;
import com.saas.authenticationandrole.service.DashboardService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/api/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticateExtnController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateExtnController.class);

    @Autowired
    AuthenticateExtnService authenticateExtnService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/getApis")
    public ResponseEntity<?> getAuthenticateAPIs() {
        ResponseDto<Object> output = authenticateExtnService.getAuthenticateExtnAPIs();
        logger.info(output.toString());
        return ResponseEntity.ok(output);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        logger.info("Inside /login");
        UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(userPassAuthToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsDto userDetails = (UserDetailsDto) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        JwtResponseDto jwtResponseDto = new JwtResponseDto(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
        ResponseDto<Object> responseDto = dashboardService.getDashboardAPIs();
        responseDto.setBody(jwtResponseDto);
        return ResponseEntity.ok(responseDto);
    }
}
