package ru.alfa.test.core.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.math.NumberUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Data
@Entity

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

@Table(name = "box")

public class Box {
    public static final Box EXTERNAL_BOX = new Box(NumberUtils.INTEGER_ZERO, null);

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contained_in", referencedColumnName = "id")
    private Box containedIn;

    @OneToMany(mappedBy = "containedIn")
    @ToString.Exclude
    private List<Box> containerOut;

    public Box(final Integer id, final Box containedIn) {
        this.id = id;
        this.containedIn = containedIn;
    }
}
