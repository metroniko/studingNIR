package com.example.studing.controllers;

import com.example.studing.dto.PatternDTO;
import com.example.studing.dto.ResultDto;
import com.example.studing.entity.Pattern;
import com.example.studing.services.PatternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/pattern")
public class PatternController {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessController.class);

    private PatternService patternService;

    public PatternController(PatternService patternService) {
        this.patternService = patternService;
    }

    @PostMapping("/create")
    public void createPattern(@RequestBody PatternDTO patternDTO) {
        LOG.info("create service by DTO: {}", patternDTO);
        patternService.createService(patternDTO);
    }

    @GetMapping("/all")
    public List<PatternDTO> getAllPatterns() {
        List<PatternDTO> allPatterns = patternService.getAllPatterns();
        LOG.info("all patterns: {}", allPatterns);
        return allPatterns;
    }

    @PostMapping("/execute")
    public ResultDto executePattern(@RequestBody PatternDTO patternDTO) {
        LOG.info("execute pattern: {}", patternDTO);
        return patternService.executePattern(patternDTO);
    }
}
