package ru.alfa.test.core.domain.exception;

/**
 * @author Vyacheslav Savinov
 * @since 29.01.2021
 */
abstract class ValidationException extends RuntimeException {
    private static final String REASON = "Указанный XML файл не прошёл валидацию. Объект %s имеет несколько идентификаторов со значением %d";

    public ValidationException(final String objectName, final Integer id) {
        super(String.format(REASON, objectName, id));
    }
}
