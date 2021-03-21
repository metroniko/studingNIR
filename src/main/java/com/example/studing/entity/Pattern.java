package com.example.studing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pattern")
@Data
public class Pattern {

    @Column(name = "pattern_name")
    private String patternName;

    @Id
    @Column(name = "pattern_GUID")
    private String patternGUID;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "strategy_in_pattern",
            joinColumns = {@JoinColumn(name = "pattern_GUID")},
            inverseJoinColumns = {@JoinColumn(name = "test_GUID")}
    )
    Collection<Strategy> strategies;
}
