package ru.alfa.test.core.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.alfa.test.core.domain.entity.Item;
import ru.alfa.test.core.service.StorageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vyacheslav Savinov
 * @since 30.01.2021
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    public final StorageService storageService;

    @GetMapping("/boxes/{boxId}/items")
    public Set<Integer> findItemsInsideBoxByColor(@PathVariable("boxId") final Integer boxId,
                                                  @RequestParam("color") final String color) {
        log.debug("Accept request to get item ids inside box by params - boxId: {}, color: {}", boxId, color);
        return storageService.findItemsInsideBoxByColor(color, boxId)
                .stream()
                .map(Item::getId)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
