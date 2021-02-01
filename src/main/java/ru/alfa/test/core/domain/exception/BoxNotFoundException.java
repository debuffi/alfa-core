package ru.alfa.test.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vyacheslav Savinov
 * @since 30.01.2021
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = BoxNotFoundException.REASON)
public class BoxNotFoundException extends RuntimeException{
    public static final String REASON = "Ящика с указанным идентификатором не существует";
}
