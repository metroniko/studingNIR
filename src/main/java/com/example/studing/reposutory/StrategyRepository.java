package com.example.studing.reposutory;

import com.example.studing.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategyRepository extends JpaRepository<Strategy, Integer> {

    Strategy getStrategiesByTestGUID(String id);
    List<Strategy> getStrategiesByTactic(String tactic);

    @Query(value = "select distinct s.tactic from Strategy s")
    List<String> getAllTacticName();

    Strategy getStrategyByTechniqueNumber(String techniqueNumber);

    @Query(value = "select s from Strategy  s where s.techniqueNumber LIKE CONCAT('%',:techniqueNumber,'%')")
    List<Strategy> getTacticBySearch(@Param("techniqueNumber") String techniqueNumber);
}
