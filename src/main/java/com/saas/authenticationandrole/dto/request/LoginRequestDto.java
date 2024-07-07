package com.saas.authenticationandrole.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

//    public void setPassword(String password) {
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        this.password = passwordEncoder.encode(password);
//        System.out.println(this.password);
//    }
}
