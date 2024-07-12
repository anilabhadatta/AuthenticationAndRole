package com.saas.authenticationandrole.util;

import com.saas.authenticationandrole.dto.response.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinkGenerationUtil {

    private static final Logger logger = LoggerFactory.getLogger(LinkGenerationUtil.class);

    public ResponseDto<Object> generateResultApiJson(List<List<String>> links){
        ResponseDto<Object> linkGenerationDto = new ResponseDto<>();
        linkGenerationDto.setLinks(links);
        return linkGenerationDto;
    }
}
