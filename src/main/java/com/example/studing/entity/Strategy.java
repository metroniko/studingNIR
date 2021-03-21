package com.example.studing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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


    @ManyToMany(mappedBy = "strategies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Pattern> patterns;
}
