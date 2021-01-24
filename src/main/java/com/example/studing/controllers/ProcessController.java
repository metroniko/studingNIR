package com.example.studing.controllers;

import com.example.studing.dto.ExecutionResultDto;
import com.example.studing.services.ProcessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/activate")
public class ProcessController {

    private ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
    public ExecutionResultDto executeStrategy(@RequestParam(value = "strategyId") String strategyId) throws IOException {
        ExecutionResultDto resultDto = new ExecutionResultDto();
        resultDto.setResult(processService.executeStrategy(strategyId));
        return resultDto;
    }
}
