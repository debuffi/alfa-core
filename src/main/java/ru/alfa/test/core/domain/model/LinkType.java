package ru.alfa.test.core.domain.model;

import java.util.Arrays;

import ru.alfa.test.core.domain.exception.LinkTypeNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@Getter
@AllArgsConstructor
public enum LinkType {
    CLASSPATH("classpath"),
    FILE("file"),
    URL("url");

    private final String type;

    public static LinkType findByValue(final String value) {
        return Arrays.stream(values())
                .filter(x -> x.getType().equals(value))
                .findAny()
                .orElseThrow(LinkTypeNotFoundException::new);
    }
}
