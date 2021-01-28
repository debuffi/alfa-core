package ru.alfa.test.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.alfa.test.core.domain.model.LinkType;
import ru.alfa.test.core.service.loader.XmlLoader;

/**
 * @author Vyacheslav Savinov
 * @since 26.01.2021
 */
@Configuration
public class XmlLoadersConfig {

    @Bean
    public Map<LinkType, XmlLoader> xmlLoaders(final List<XmlLoader> xmlLoaders) {
        return new HashMap<LinkType, XmlLoader>() {{
            xmlLoaders.forEach(xmlLoader -> put(xmlLoader.getLinkType(), xmlLoader));
        }};
    }
}
