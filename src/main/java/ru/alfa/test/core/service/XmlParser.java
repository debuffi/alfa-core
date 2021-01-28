package ru.alfa.test.core.service;

import javax.xml.bind.JAXBException;

import ru.alfa.test.core.domain.dto.XmlFileContainer;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
public interface XmlParser<T> {
    T parse(final XmlFileContainer xmlFileContainer) throws JAXBException;
}
