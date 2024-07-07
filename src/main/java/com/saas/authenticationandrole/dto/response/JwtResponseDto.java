package com.saas.authenticationandrole.dto.response;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class JwtResponseDto {
    @NonNull
    private String token;
    private String type = "Bearer";
    @NonNull
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private List<String> roles;

}
