package com.example.studing.services;

import com.example.studing.dto.TacticDto;
import com.example.studing.entity.Strategy;
import com.example.studing.reposutory.StrategyRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TacticService {
    private StrategyRepository strategyRepository;

    public TacticService(StrategyRepository processService) {
        this.strategyRepository = processService;
    }

    public List<TacticDto> getAllTacticsName() {
        List<String> allTacticName = strategyRepository.getAllTacticName();
        List<TacticDto> tacticDtos = new ArrayList<>();
        allTacticName.forEach(tactic -> {
            String capitalize = WordUtils.capitalize(tactic.replace("-", " "));
            tacticDtos.add(new TacticDto(capitalize, tactic));
        });
        return tacticDtos;
    }

    public List<Strategy> getStrategiesByTactic(String tacticName) {
        return strategyRepository.getStrategiesByTactic(tacticName);
    }
}
