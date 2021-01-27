package ru.alfa.test.core.service.loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
public class UrlLoaderService implements XmlLoaderService {

    @Override
    public XmlFileContainer loadFile(final String file) throws IOException {
        final InputStream inputStream = new URL(file).openStream();
        final byte[] bytes = IOUtils.toByteArray(inputStream);
        final String xmlBody = new String(bytes, StandardCharsets.UTF_8);
        return XmlFileContainer.newInstance(xmlBody);
    }

    @Override
    public LinkType getLinkType() {
        return LinkType.URL;
    }
}
