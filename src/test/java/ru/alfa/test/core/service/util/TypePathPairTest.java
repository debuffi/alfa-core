package ru.alfa.test.core.service.util;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vyacheslav Savinov
 * @since 01.02.2021
 */
class TypePathPairTest {
    private static final String COLON = ":";

    @Test
    void fromString(){
        final String type = "classpath";
        final String path = "/test.xml";
        final String typeFile = type.concat(COLON).concat(path);

        final Pair<String, String> stringStringPair = TypePathPair.fromString(typeFile);
        assertEquals(type, stringStringPair.getKey());
        assertEquals(path, stringStringPair.getValue());
    }

    @Test
    void fromStringShouldThrowIllegalArgumentException(){
        final String typePath = "invalid typePath";
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TypePathPair.fromString(typePath);
        });

        final String expectedMessage = "Incorrect type:path params: invalid typePath";
        final String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}