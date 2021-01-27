package ru.alfa.test.core.domain.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Vyacheslav Savinov
 * @since 27.01.2021
 */
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class XmlFileContainer {

    private final String body;

    public static XmlFileContainer newInstance(final String body) {
        return new XmlFileContainer(body);
    }
}
