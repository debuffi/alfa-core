package ru.alfa.test.core.service.loader;

import java.io.IOException;
import java.net.URISyntaxException;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
public interface XmlLoaderService {
    LinkType getLinkType();

    XmlFileContainer loadFile(final String file) throws IOException, URISyntaxException;
}
