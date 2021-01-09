package com.example.studing.controllers;

import com.example.studing.dto.TacticDto;
import com.example.studing.entity.Strategy;
import com.example.studing.services.TacticService;
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

    @GetMapping("/{tacticName}")
    public List<Strategy> getStrategiesByTactic(@PathVariable String tacticName) {
        return tacticService.getStrategiesByTactic(tacticName);
    }

    @GetMapping
    public List<TacticDto> getTacticUncialTactic() {
        return tacticService.getAllTacticsName();
    }
}
