package com.example.studing.services;

import com.example.studing.entity.Strategy;
import com.example.studing.reposutory.StrategyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class ProcessService {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessService.class);

    private StrategyRepository strategyRepository;

    public ProcessService(StrategyRepository strategyRepository) {
        this.strategyRepository = strategyRepository;
    }

    public Strategy getProcessByID(String id) {
        return strategyRepository.getStrategiesByTestGUID(id);
    }

    public List<Strategy> getStrategyByTacticName(String tacticName) {
        return strategyRepository.getStrategiesByTactic(tacticName);
    }

    public String executeStrategy(String id) throws IOException {
        Strategy strategy = strategyRepository.getStrategiesByTestGUID(id);
        StringBuilder executeStrategy = executeService(strategy);
        return executeStrategy.toString();
    }


    private StringBuilder executeService(Strategy strategy) throws IOException {

        // Executing the command
        String command = "powershell.exe  Invoke-AtomicTest " + strategy.getTechniqueNumber() + " -showDetails";

        Process powerShellProcess = Runtime.getRuntime().exec(command);
        // Getting the results
        powerShellProcess.getOutputStream().close();
        String line;
        System.out.println("Standard Output:");
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
        StringBuilder str = new StringBuilder();
        while ((line = stdout.readLine()) != null) {
            str.append(line).append("\n");
            System.out.println(line);
        }
        stdout.close();
        LOG.info("done execute Atomic test, result: {}", str);
        System.out.println("Standard Error:");
        BufferedReader stderr = new BufferedReader(new InputStreamReader(
                powerShellProcess.getErrorStream()));
        while ((line = stderr.readLine()) != null) {
            System.out.println(line);
        }
        stderr.close();
        System.out.println("Done");

        return str;
    }
}
