package com.example.studing.reposutory;

import com.example.studing.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategyRepository extends JpaRepository<Strategy, Integer> {
    public Strategy getStrategiesByTestGUID(String id);
    public List<Strategy> getStrategiesByTactic(String tactic);
}
