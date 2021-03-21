package com.example.studing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultDto {
    private ArrayList<String> errorTechniques;
    private int countOfTechniques;

    public ResultDto() {
        errorTechniques = new ArrayList<>();
    }
}
