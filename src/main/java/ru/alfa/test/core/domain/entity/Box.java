package ru.alfa.test.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.math.NumberUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "box")
@EqualsAndHashCode
public class Box {
    public static final Box EXTERNAL_BOX = new Box(NumberUtils.INTEGER_ZERO, null);

    @Id
    private Integer id;

    @Column(name = "contained_in")
    private Integer containedIn;
}
