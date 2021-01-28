package ru.alfa.test.core.service.loader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@Service
public class ClasspathXmlLoader implements XmlLoader {

    @Override
    public XmlFileContainer loadFile(final String file) throws IOException {
        final String xmlBody = IOUtils.toString(getClass().getResource(file), StandardCharsets.UTF_8.name());
        return XmlFileContainer.newInstance(xmlBody);
    }

    @Override
    public LinkType getLinkType() {
        return LinkType.CLASSPATH;
    }
}
