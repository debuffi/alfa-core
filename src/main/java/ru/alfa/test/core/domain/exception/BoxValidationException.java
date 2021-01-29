package ru.alfa.test.core.domain.exception;

/**
 * @author Vyacheslav Savinov
 * @since 29.01.2021
 */
public class BoxValidationException extends ValidationException {
    private static final String OBJECT_NAME = "Box";

    public BoxValidationException(final Integer id) {
        super(OBJECT_NAME, id);
    }
}
