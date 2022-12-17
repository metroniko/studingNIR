package com.example.studing.services;

import com.example.studing.dto.PatternDTO;
import com.example.studing.dto.ResultDto;
import com.example.studing.entity.Pattern;
import com.example.studing.entity.Strategy;
import com.example.studing.entity.StrategyInPattern;
import com.example.studing.reposutory.PatternRepository;
import com.example.studing.reposutory.StrategyInPatternRepository;
import com.example.studing.reposutory.StrategyRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PatternService {

    private PatternRepository patternRepository;
    private StrategyRepository strategyRepository;
    private ProcessService processService;
    private StrategyInPatternRepository strategyInPatternRepository;

    public PatternService(PatternRepository patternRepository, StrategyRepository strategyRepository, ProcessService processService, StrategyInPatternRepository strategyInPatternRepository) {
        this.patternRepository = patternRepository;
        this.strategyRepository = strategyRepository;
        this.processService = processService;
        this.strategyInPatternRepository = strategyInPatternRepository;
    }

    public void createService(PatternDTO patternDTO) {
        Pattern pattern = new Pattern();
        pattern.setPatternName(patternDTO.getPatternName());
        List<StrategyInPattern> strategyInPatterns = new ArrayList<>();
        List<Strategy> strategies = patternDTO.getTacticNames().keySet().stream().map(strategyRepository::getStrategiesByTestGUID).collect(Collectors.toList());
        for (Strategy str : strategies) {
            String count = patternDTO.getTacticNames().get(str.getTestGUID());
            StrategyInPattern strategyInPattern = new StrategyInPattern();
            strategyInPattern.setCount(count);
            strategyInPattern.setStrategy(str);
            strategyInPattern.setTestGUID(String.valueOf(strategyInPattern.hashCode()));
            strategyInPattern.setPattern(pattern);
            strategyInPatterns.add(strategyInPattern);
        }
        pattern.setPatternGUID(String.valueOf(patternDTO.hashCode()));
        patternRepository.save(pattern);
        strategyInPatternRepository.saveAll(strategyInPatterns);
    }


    public List<PatternDTO> getAllPatterns() {
        List<Pattern> patterns = patternRepository.findAll();
        List<PatternDTO> patternDTOS = new ArrayList<>();
        patterns.forEach(el-> {
            PatternDTO patternDTO = new PatternDTO();
            patternDTO.setPatternName(el.getPatternName());
            LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
            for (StrategyInPattern strIn : el.getStrategiesInPattern()) {
                hashMap.put(strIn.getStrategy().getTestName(), strIn.getCount());
            }
            patternDTO.setTacticNames(hashMap);
            patternDTOS.add(patternDTO);
        });

        return patternDTOS;
    }

    public List<ResultDto> executePattern(PatternDTO patternDTO) {
        Pattern pattern = patternRepository.findByPatternName(patternDTO.getPatternName());
        Collection<StrategyInPattern> all = pattern.getStrategiesInPattern();
        List<ResultDto> results = new ArrayList<>();
        //TODO do execution
        int prevErrors = 0;
        for (StrategyInPattern strategyInPattern : all) {
            Strategy el = strategyInPattern.getStrategy();
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
