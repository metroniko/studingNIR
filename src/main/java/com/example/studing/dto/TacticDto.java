package com.example.studing.dto;

import lombok.Data;

@Data
public class TacticDto {

    public TacticDto(String tacticName, String tacticId) {
        this.tacticName = tacticName;
        this.tacticId = tacticId;
    }

    private String tacticName;
    private String tacticId;
}
