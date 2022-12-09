package com.example.studing.reposutory;

import com.example.studing.entity.Strategy;
import com.example.studing.entity.StrategyInPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategyInPatternRepository extends JpaRepository<StrategyInPattern, Integer> {

    List<StrategyInPattern> getStrategyInPatternsByTestGUID(String testGUID);
}
