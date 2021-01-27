package ru.alfa.test.core.service;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;
import ru.alfa.test.core.service.loader.XmlLoaderService;
import ru.alfa.test.core.service.util.TypeFilePair;

import lombok.RequiredArgsConstructor;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@Component
@RequiredArgsConstructor
public class AppStartProcessor {

    @Value("${link.type:file}")
    private String typeFile;

    private final Map<LinkType, XmlLoaderService> xmlLoaders;


    public void process() throws IOException {
        final Pair<String, String> typeFilePair = TypeFilePair.fromString(typeFile);
        final String type = typeFilePair.getKey();
        final String file = typeFilePair.getValue();

        final LinkType linkType = LinkType.findByValue(type);
        final XmlLoaderService xmlLoader = xmlLoaders.get(linkType);
        final XmlFileContainer xmlFileContainer = xmlLoader.loadFile(file);

        System.out.println("kek");
    }
}
