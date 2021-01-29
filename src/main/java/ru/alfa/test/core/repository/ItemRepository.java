package ru.alfa.test.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.alfa.test.core.domain.entity.Item;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
