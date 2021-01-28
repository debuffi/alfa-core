package ru.alfa.test.core.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import ru.alfa.test.core.domain.dto.XmlFileContainer;

import generated.Storage;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Override
    public Storage parse(final XmlFileContainer xmlFileContainer) throws JAXBException {
        final String xmlBody = xmlFileContainer.getBody();
        final InputStream inputStream = new ByteArrayInputStream(xmlBody.getBytes());

        final JAXBContext jaxbContext = JAXBContext.newInstance(StorageServiceImpl.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Storage) jaxbUnmarshaller.unmarshal(inputStream);
    }

    @Override
    public void handle(final Storage storage) {

    }
}
