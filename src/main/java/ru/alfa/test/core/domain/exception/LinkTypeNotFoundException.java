package ru.alfa.test.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vyacheslav Savinov
 * @since 25.01.2021
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = LinkTypeNotFoundException.REASON)
public class LinkTypeNotFoundException extends RuntimeException{
    public static final String REASON = "Указанного типа ссылки не существует";
}
