package ru.alfa.test.core.service.loader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@Service
public class FileXmlLoader implements XmlLoader {

    @Override
    public XmlFileContainer loadFile(final String file) throws IOException {
        final byte[] bytes = Files.readAllBytes(Paths.get(file));
        final String xmlBody = new String(bytes, StandardCharsets.UTF_8);
        return XmlFileContainer.newInstance(xmlBody);
    }

    @Override
    public LinkType getLinkType() {
        return LinkType.FILE;
    }
}
