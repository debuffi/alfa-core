package ru.alfa.test.core.service.loader;

import org.springframework.stereotype.Service;

import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.model.LinkType;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@Service
public class FileLoaderService implements XmlLoaderService {

    @Override
    public XmlFileContainer loadFile(final String file) {
        return null;
    }


    @Override
    public LinkType getLinkType() {
        return LinkType.FILE;
    }
}
