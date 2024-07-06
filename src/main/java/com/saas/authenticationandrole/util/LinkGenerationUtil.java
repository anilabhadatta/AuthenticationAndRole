package com.saas.authenticationandrole.util;

import com.saas.authenticationandrole.dto.LinkGenerationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinkGenerationUtil {

    private static final Logger logger = LoggerFactory.getLogger(LinkGenerationUtil.class);

    public LinkGenerationDto generateResultApiJson(List<List<String>> links){
        LinkGenerationDto linkGenerationDto = new LinkGenerationDto();
        linkGenerationDto.setLinks(links);
        return linkGenerationDto;
    }
}
