package com.saas.authenticationandrole.dto;

import lombok.Data;

import java.util.List;

@Data
public class LinkGenerationDto {
    Object body;
    List<List<String>> links;
}
