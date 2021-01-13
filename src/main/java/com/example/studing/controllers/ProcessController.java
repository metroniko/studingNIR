package com.example.studing.controllers;

import com.example.studing.services.ProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RestController
@RequestMapping("/activate")
public class ProcessController {

    private ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
        public String executeStrategy(@RequestParam(value = "strategyId") String strategyId) throws IOException {
        return processService.executeStrategy(strategyId);
    }
}
