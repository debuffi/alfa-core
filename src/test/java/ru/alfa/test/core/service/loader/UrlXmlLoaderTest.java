package ru.alfa.test.core.service.loader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;

/**
 * @author Vyacheslav Savinov
 * @since 01.02.2021
 */
@SpringBootTest
class UrlXmlLoaderTest {

    @Autowired
    private UrlXmlLoader urlXmlLoader;

    @Test
    void loadFile() throws IOException {
        final String xmlPath = "/storage.xml";
        final String expected = IOUtils.toString(getClass().getResourceAsStream(xmlPath), StandardCharsets.UTF_8.name());

        final URL resource = getClass().getResource(xmlPath);
        final String actual = urlXmlLoader.loadFile(resource.toString()).getBody();

        assertEquals(expected, actual);
    }

    @Test
    void getLinkType() {
        final LinkType expected = LinkType.URL;
        final LinkType actual = urlXmlLoader.getLinkType();
        assertEquals(expected, actual);
    }
}