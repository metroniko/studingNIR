package com.example.studing.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "strategy_in_pattern")
public class StrategyInPattern {

    @Id
    @Column(name = "strategy_in_pattern_id")
    private String testGUID;

    @ManyToOne
    @JoinColumn(name = "test_GUID")
    private Strategy strategy;

    public String getTestGUID() {
        return testGUID;
    }

    public void setTestGUID(String testGUID) {
        this.testGUID = testGUID;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Column(name = "count")
    private String count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pattern_GUID")
    private Pattern pattern;

}
