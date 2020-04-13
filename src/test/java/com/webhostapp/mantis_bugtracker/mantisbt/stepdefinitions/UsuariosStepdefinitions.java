package com.webhostapp.mantis_bugtracker.mantisbt.stepdefinitions;

import com.webhostapp.mantis_bugtracker.mantisbt.apis.UsuariosApi;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class UsuariosStepdefinitions {

    private String apiToken;

    @Steps
    UsuariosApi usuariosApi;

    @Quando("solicitar recuperar suas informações via API")
    public void solicitarRecuperarSuasInformacoesViaApi() {
        String urlApi = usuariosApi.recuperarInformacoesUsuarioLogado();
        SerenityRest.when().get(urlApi);
    }

    @Entao("o sistema deve retornar os dados do usuário que realizou a requisição")
    public void oSistemaDeveRetornarOsDadosDoUsuarioQueRealizouARequisicao(DataTable dadosUsuario) {
        SerenityRest.then().statusCode(200).and().body("$", not(empty()));
        for (String dadoUsuario : dadosUsuario.asList()) {
            SerenityRest.and().body("$." + dadoUsuario, not(empty()));
        }
    }
}
