package com.webhostapp.mantis_bugtracker.mantisbt.stepdefinitions;

import com.webhostapp.mantis_bugtracker.mantisbt.enums.ChaveSessao;
import com.webhostapp.mantis_bugtracker.mantisbt.utils.ParametrosGlobais;
import cucumber.api.java.pt.Dado;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.Header;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.LinkedHashMap;
import java.util.Map;

public class PermissoesStepdefinitions {

    @Dado("que o usuário do sistema tenha gerado o token de acesso da API")
    public void queOUsuarioDoSistemaTenhaGeradoOTokenDeAcessoDaApi() {
        String apiToken = ParametrosGlobais.API_TOKEN;
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Authorization", apiToken);
        Serenity.setSessionVariable(ChaveSessao.HEADERS).to(headers);
    }
}
