package com.webhostapp.mantis_bugtracker.mantisbt.utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private  JsonUtils() {
        throw new IllegalStateException("JsonUtils class");
    }

    public static String objetoParaJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
