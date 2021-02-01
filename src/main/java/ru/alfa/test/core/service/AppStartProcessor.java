package ru.alfa.test.core.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;
import ru.alfa.test.core.service.loader.XmlLoader;
import ru.alfa.test.core.service.util.TypePathPair;

import generated.Storage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AppStartProcessor {

    private final Map<LinkType, XmlLoader> xmlLoaders;
    private final StorageService storageService;


    public void process(final String typePath) throws IOException, URISyntaxException, JAXBException {
        if (Strings.isBlank(typePath)) {
            log.debug("Type:path is blank. No need to parse and insert data");
            return;
        }
        final Pair<String, String> typePathPair = TypePathPair.fromString(typePath);
        final String type = typePathPair.getKey();
        final String path = typePathPair.getValue();
        log.debug("Try to load data from XML with type: {} and path: {}", type, path);

        final LinkType linkType = LinkType.findByValue(type);
        final XmlLoader xmlLoader = xmlLoaders.get(linkType);
        final XmlFileContainer xmlFileContainer = xmlLoader.loadFile(path);
        final Storage storage = storageService.parse(xmlFileContainer);
        storageService.handle(storage);

        log.info("Loading data from XML was successful");
    }
}
