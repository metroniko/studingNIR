package com.example.studing.controllers;

import com.example.studing.entity.Strategy;
import com.example.studing.services.ProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/activate")
public class ProcessController {

    private ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
    public String executeStrategy(@RequestParam("strategyId") String strategyId) {
        return processService.executeStrategy(strategyId);
    }

    @GetMapping("/{tacticName}")
    public List<Strategy> getStrategiesByTactic(@PathVariable String tacticName) {
        return processService.getStrategyByTacticName(tacticName);
    }


}
