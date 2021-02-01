package ru.alfa.test.core.service.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vyacheslav Savinov
 * @since 26.01.2021
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TypePathPair {
    private static final String COLON = ":";

    public static Pair<String, String> fromString(final String typeFile) {
        final int colonIdx = typeFile.indexOf(COLON);
        if(colonIdx == -1){
            final String errorMessage = String.format("Incorrect type:path params: %s", typeFile);
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        final String type = typeFile.substring(0, colonIdx);
        final String file = typeFile.substring(colonIdx + NumberUtils.INTEGER_ONE);
        return Pair.of(type, file);
    }
}
