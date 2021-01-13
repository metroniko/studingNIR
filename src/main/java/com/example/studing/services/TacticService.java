package com.example.studing.services;

import com.example.studing.dto.TacticDto;
import com.example.studing.entity.Strategy;
import com.example.studing.reposutory.StrategyRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        List<Strategy> strategiesByTactic = strategyRepository.getStrategiesByTactic(tacticName);
        Set<String> collect = new HashSet<>();

        List<Strategy> strategyList = strategiesByTactic.stream()
                .filter(el -> collect.add(el.getTechniqueNumber()
                        .split("\\.")[0]))
                .collect(Collectors.toList());


        return strategyList;
    }
}
