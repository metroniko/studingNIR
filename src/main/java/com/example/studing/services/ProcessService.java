package com.example.studing.services;

import com.example.studing.entity.Strategy;
import com.example.studing.reposutory.StrategyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    private StrategyRepository strategyRepository;

    public ProcessService(StrategyRepository strategyRepository) {
        this.strategyRepository = strategyRepository;
    }

    public Strategy getProcessByID(String id) {
        return strategyRepository.getStrategiesByTestGUID(id);
    }

    public List<Strategy> getStrategyByTacticName(String tacticName) {
        return strategyRepository.getStrategiesByTactic(tacticName);
    }
    public String executeStrategy(String id) {
        Strategy strategy = strategyRepository.getStrategiesByTestGUID(id);
        strategy.getTestGUID();
        return strategy.toString();
    }
}
