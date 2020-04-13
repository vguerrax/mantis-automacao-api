package com.webhostapp.mantis_bugtracker.mantisbt.apis;

import com.webhostapp.mantis_bugtracker.mantisbt.utils.ParametrosGlobais;

public class BaseApi {
    protected String baseUrl;

    public BaseApi() {
        this.baseUrl = ParametrosGlobais.BASE_URL;
    }
}
