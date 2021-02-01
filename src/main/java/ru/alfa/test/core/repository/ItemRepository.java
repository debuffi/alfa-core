package ru.alfa.test.core.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.alfa.test.core.domain.entity.Box;
import ru.alfa.test.core.domain.entity.Item;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Set<Item> findByContainedInInAndColor(final List<Box> innerBoxes, final String color);
}
