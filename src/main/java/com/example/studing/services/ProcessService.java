package com.example.studing.services;

import com.example.studing.entity.Strategy;
import com.example.studing.reposutory.StrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        Strategy strategy = strategyRepository.getStrategyByTechniqueNumber(id);
        StringBuilder executeStrategy = executeService(strategy);
        String s = executeStrategy.toString();
        return s;
    }

    public List<StringBuilder> executeTacticTest(String tacticName) {
        List<Strategy> strategiesByTactic = strategyRepository.getStrategiesByTactic(tacticName);
        List<StringBuilder> testResults = new ArrayList<>();
        strategiesByTactic.forEach(strategy -> {
            try {
                LOG.info("Tests number: {}", testResults.size());
                testResults.add(executeService(strategy));
            } catch (IOException e) {
                LOG.error("IOException", e);
                e.printStackTrace();
            }
        });
        return testResults;
    }


    private StringBuilder executeService(Strategy strategy) throws IOException {

        String techniqueNumber = strategy.getTechniqueNumber();

        LOG.info("number of technique: {}", techniqueNumber);
        String[] split = techniqueNumber.split("/.");

        String command;
        // Executing the command
        if (split.length == 1) {
            command = "powershell.exe Invoke-AtomicTest " + techniqueNumber;
        } else {
            //удаляю все нули, может сломаться на тесте номер 10
            String numberOfTest = split[1].replaceAll("0", "");
            command = "powershell.exe Invoke-AtomicTest " + techniqueNumber + " -TestNumbers " + numberOfTest;
        }


        Process powerShellProcess = Runtime.getRuntime().exec(command);
        // Getting the results
        powerShellProcess.getOutputStream().close();
        String line;
        System.out.println("Standard Output:");
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
        StringBuilder str = new StringBuilder();
        while ((line = stdout.readLine()) != null) {
            str.append(line).append("<br>");
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
