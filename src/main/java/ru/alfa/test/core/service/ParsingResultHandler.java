package ru.alfa.test.core.service;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
public interface ParsingResultHandler<T> {

    void handle(T t);
}
