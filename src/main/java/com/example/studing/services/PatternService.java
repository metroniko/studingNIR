package com.example.studing.services;

import com.example.studing.dto.PatternDTO;
import com.example.studing.dto.ResultDto;
import com.example.studing.entity.Pattern;
import com.example.studing.entity.Strategy;
import com.example.studing.reposutory.PatternRepository;
import com.example.studing.reposutory.StrategyRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PatternService {

    private PatternRepository patternRepository;
    private StrategyRepository strategyRepository;
    private ProcessService processService;

    public PatternService(PatternRepository patternRepository, StrategyRepository strategyRepository, ProcessService processService) {
        this.patternRepository = patternRepository;
        this.strategyRepository = strategyRepository;
        this.processService = processService;
    }

    public void createService(PatternDTO patternDTO) {
        Pattern pattern = new Pattern();
        pattern.setPatternName(patternDTO.getPatternName());
        List<Strategy> strategies = patternDTO.getTacticNames().stream().map(strategyRepository::getStrategiesByTestGUID).collect(Collectors.toList());
        pattern.setStrategies(strategies);
        pattern.setPatternGUID(String.valueOf(patternDTO.hashCode()));
        patternRepository.save(pattern);
    }


    public List<PatternDTO> getAllPatterns() {
        List<Pattern> patterns = patternRepository.findAll();
        List<PatternDTO> patternDTOS = new ArrayList<>();
        patterns.forEach(el-> {
            PatternDTO patternDTO = new PatternDTO();
            patternDTO.setPatternName(el.getPatternName());
            List<String> collect = el.getStrategies().stream().map(Strategy::getTestName).collect(Collectors.toList());
            patternDTO.setTacticNames(collect);
            patternDTOS.add(patternDTO);
        });

        return patternDTOS;
    }

    public List<ResultDto> executePattern(PatternDTO patternDTO) {
        Pattern pattern = patternRepository.findByPatternName(patternDTO.getPatternName());
        List<ResultDto> results = new ArrayList<>();
        Set<Strategy> objects = new HashSet<>(pattern.getStrategies());
        int prevErrors = 0;
        for (Strategy el : objects) {
            ResultDto resultDto = new ResultDto();
            resultDto.setTechniqueName(el.getTestName());
            if(!el.getExecutorName().equals("powershell")) {
                resultDto.setResultCode(2);
            } else {
                try {
                    StringBuilder stringBuilder = processService.executeService(el);
                    int errorCount = Integer.parseInt(stringBuilder.toString());
                    if (errorCount != prevErrors) {
                        resultDto.setResultCode(0);

                    } else {
                        resultDto.setResultCode(1);
                    }
                    prevErrors = errorCount;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            results.add(resultDto);
        }
        return results;
    }
}
