package com.example.studing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pattern")
public class Pattern {

    @Column(name = "pattern_name")
    private String patternName;

    @Id
    @Column(name = "pattern_GUID")
    private String patternGUID;

    @OneToMany(mappedBy = "pattern",  fetch = FetchType.EAGER)
    Collection<StrategyInPattern> strategiesInPattern;

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getPatternGUID() {
        return patternGUID;
    }

    public void setPatternGUID(String patternGUID) {
        this.patternGUID = patternGUID;
    }

    public Collection<StrategyInPattern> getStrategiesInPattern() {
        return strategiesInPattern;
    }

    public void setStrategiesInPattern(Collection<StrategyInPattern> strategiesInPattern) {
        this.strategiesInPattern = strategiesInPattern;
    }
}
