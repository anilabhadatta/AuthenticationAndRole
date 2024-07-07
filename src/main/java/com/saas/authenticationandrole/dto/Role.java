package com.saas.authenticationandrole.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Role {
    @NonNull
    private String id;
    @NonNull
    private String name;

}