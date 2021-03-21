package com.example.studing.controllers;

import com.example.studing.dto.TacticDto;
import com.example.studing.entity.Strategy;
import com.example.studing.services.TacticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/tactic")
public class TacticController {

    private TacticService tacticService;

    public TacticController(TacticService tacticService) {
        this.tacticService = tacticService;
    }

    private static final Logger LOG = LoggerFactory.getLogger(ProcessController.class);

    @GetMapping("/{tacticName}")
    public List<Strategy> getStrategiesByTactic(@PathVariable String tacticName) {
        return tacticService.getStrategiesByTactic(tacticName);
    }

    @GetMapping
    public List<TacticDto> getTacticUncialTactic() {
        return tacticService.getAllTacticsName();
    }

    @GetMapping("/search/{tacticSearch}")
    public List<TacticDto> getStrategiesBySearch(@PathVariable String tacticSearch) {
        List<TacticDto> search = tacticService.findBySearch(tacticSearch);
        LOG.info("searched tactics: {}", search);
        return search;
    }
}
