package com.webhostapp.mantis_bugtracker.mantisbt.stepdefinitions;

import com.webhostapp.mantis_bugtracker.mantisbt.utils.ParametrosGlobais;
import cucumber.api.java.pt.Dado;
import io.restassured.http.Header;
import net.serenitybdd.rest.SerenityRest;

public class PermissoesStepdefinitions {

    @Dado("que o usuário do sistema tenha gerado o token de acesso da API")
    public void queOUsuarioDoSistemaTenhaGeradoOTokenDeAcessoDaApi() {
        String apiToken = ParametrosGlobais.API_TOKEN;
        Header header = new Header("Authorization", apiToken);
        SerenityRest.given().header(header);
    }
}
