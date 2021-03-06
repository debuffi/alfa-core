package ru.alfa.test.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ru.alfa.test.core.domain.entity.Box;

/**
 * @author Vyacheslav Savinov
 * @since 29.01.2021
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoxMapper {
    Box toEntity(generated.Box box);
}
