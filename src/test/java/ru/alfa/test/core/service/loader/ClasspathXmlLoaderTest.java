package ru.alfa.test.core.service.loader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.alfa.test.core.domain.model.LinkType;

/**
 * @author Vyacheslav Savinov
 * @since 01.02.2021
 */
@SpringBootTest
class ClasspathXmlLoaderTest {

    @Autowired
    private ClasspathXmlLoader classpathXmlLoader;

    @Test
    void loadFile() throws IOException {
        final String xmlPath = "/storage.xml";
        final String expected = IOUtils.toString(getClass().getResourceAsStream(xmlPath), StandardCharsets.UTF_8.name());
        final String actual = classpathXmlLoader.loadFile(xmlPath).getBody();
        assertEquals(expected, actual);
    }

    @Test
    void getLinkType() {
        final LinkType expected = LinkType.CLASSPATH;
        final LinkType actual = classpathXmlLoader.getLinkType();
        assertEquals(expected, actual);
    }
}