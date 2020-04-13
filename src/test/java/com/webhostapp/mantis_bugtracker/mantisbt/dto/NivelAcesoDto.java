package com.webhostapp.mantis_bugtracker.mantisbt.dto;

import lombok.Data;

@Data
public class NivelAcesoDto {

    private String name;

    public NivelAcesoDto() {
        name = "updater";
    }
}
