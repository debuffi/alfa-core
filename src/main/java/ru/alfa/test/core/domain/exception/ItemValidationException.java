package ru.alfa.test.core.domain.exception;

/**
 * @author Vyacheslav Savinov
 * @since 29.01.2021
 */
public class ItemValidationException extends ValidationException {
    private static final String OBJECT_NAME = "Item";

    public ItemValidationException(final Integer id) {
        super(OBJECT_NAME, id);
    }
}
