package com.example.studing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "strategy")
public class Strategy {

    @Column(name = "tactic")
    private String tactic;

    @Column(name = "technique_number")
    private String techniqueNumber;

    public String getTactic() {
        return tactic;
    }

    public void setTactic(String tactic) {
        this.tactic = tactic;
    }

    public String getTechniqueNumber() {
        return techniqueNumber;
    }

    public void setTechniqueNumber(String techniqueNumber) {
        this.techniqueNumber = techniqueNumber;
    }

    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestGUID() {
        return testGUID;
    }

    public void setTestGUID(String testGUID) {
        this.testGUID = testGUID;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public Collection<StrategyInPattern> getStrategyInPattern() {
        return strategyInPattern;
    }

    public void setStrategyInPattern(Collection<StrategyInPattern> strategyInPattern) {
        this.strategyInPattern = strategyInPattern;
    }

    @Column(name = "technique_name")
    private String techniqueName;

    @Column(name = "test_number")
    private Integer testNumber;

    @Column(name = "test_name")
    private String testName;

    @Id
    @Column(name = "test_GUID")
    private String testGUID;

    @Column(name = "executor_name")
    private String executorName;

    @OneToMany(mappedBy = "strategy", fetch = FetchType.LAZY)
    Collection<StrategyInPattern> strategyInPattern;
}
