package com.example.studing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class PatternDTO {
    private String patternName;
    private Map<String, String> tacticNames;
}
