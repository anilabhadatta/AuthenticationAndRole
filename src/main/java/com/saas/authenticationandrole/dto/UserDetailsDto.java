package com.saas.authenticationandrole.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDetailsDto implements UserDetails {
    private static final long serialVersionUID = 1L;
    @NonNull
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    @JsonIgnore
    private String password;
    @NonNull
    private Collection<? extends GrantedAuthority> authorities;
    private Set<Role> roles;
}
