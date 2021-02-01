package ru.alfa.test.core.service;

import java.util.Set;

import ru.alfa.test.core.domain.entity.Item;

import generated.Storage;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
public interface StorageService extends XmlParser<Storage>, ParsingResultHandler<Storage> {
    Set<Item> findItemsInsideBoxByColor(final String color, final Integer boxId);
}
