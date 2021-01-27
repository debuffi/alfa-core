package ru.alfa.test.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.alfa.test.core.domain.model.LinkType;
import ru.alfa.test.core.service.loader.XmlLoaderService;

/**
 * @author Vyacheslav Savinov
 * @since 26.01.2021
 */
@Configuration
public class XmlLoadersConfig {

    @Bean
    public Map<LinkType, XmlLoaderService> xmlLoaders(final List<XmlLoaderService> xmlLoaderServices) {
        final Map<LinkType, XmlLoaderService> xmlLoadersMap = new HashMap<>();

        for(XmlLoaderService xmlLoaderService: xmlLoaderServices){
            final LinkType linkType = xmlLoaderService.getLinkType();
            xmlLoadersMap.put(linkType, xmlLoaderService);
        }

        return xmlLoadersMap;
    }
}
