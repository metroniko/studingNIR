package com.example.studing.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "strategy")
@Data
public class Strategy {

    @Column(name = "tactic")
    private String tactic;

    @Column(name = "technique_number")
    private String techniqueNumber;

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
}
