package com.webhostapp.mantis_bugtracker.mantisbt.dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto {

    private String username;
    private String password;
    private String real_name;
    private String email;
    private NivelAcesoDto access_level;
    private Boolean enabled;
    @JsonProperty("protected")
    private Boolean _protected;
}
