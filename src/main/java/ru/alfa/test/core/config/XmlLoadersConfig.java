package ru.alfa.test.core.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        return xmlLoaders.stream()
                .collect(Collectors.toMap(XmlLoader::getLinkType, Function.identity()));
    }
}
