package com.saas.authenticationandrole.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ResponseDto<T> {
    T body;
    List<List<String>> links;
}
