package com.example.studing.reposutory;

import com.example.studing.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategyRepository extends JpaRepository<Strategy, Integer> {

    Strategy getStrategiesByTestGUID(String id);
    List<Strategy> getStrategiesByTactic(String tactic);

    @Query(value = "select distinct s.tactic from Strategy s")
    List<String> getAllTacticName();
}
