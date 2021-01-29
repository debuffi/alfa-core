package ru.alfa.test.core.domain.dto;

import java.util.Map;

import org.springframework.stereotype.Component;

import ru.alfa.test.core.domain.entity.Box;
import ru.alfa.test.core.domain.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Getter
@Component
@AllArgsConstructor
public class StorageContainer {

    private final Map<Integer, Box> boxMap;

    private final Map<Integer, Item> itemMap;
}
