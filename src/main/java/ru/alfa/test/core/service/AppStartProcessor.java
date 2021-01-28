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
import ru.alfa.test.core.service.util.TypeFilePair;

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

    @Value("${link.type:file}")
    private String typeFile;

    private final Map<LinkType, XmlLoader> xmlLoaders;
    private final StorageService storageService;


    public void process() throws IOException, URISyntaxException, JAXBException {
        if (Strings.isBlank(typeFile)) {
            log.debug("Type:file is blank. No need to parse and insert data");
            return;
        }
        final Pair<String, String> typeFilePair = TypeFilePair.fromString(typeFile);
        final String type = typeFilePair.getKey();
        final String file = typeFilePair.getValue();

        final LinkType linkType = LinkType.findByValue(type);
        final XmlLoader xmlLoader = xmlLoaders.get(linkType);
        final XmlFileContainer xmlFileContainer = xmlLoader.loadFile(file);
        final Storage storage = storageService.parse(xmlFileContainer);
        storageService.handle(storage);

        System.out.println(storage);
        System.out.println(xmlFileContainer);
    }
}
