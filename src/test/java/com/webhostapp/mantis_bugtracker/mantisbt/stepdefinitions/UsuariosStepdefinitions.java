package com.webhostapp.mantis_bugtracker.mantisbt.stepdefinitions;

import com.webhostapp.mantis_bugtracker.mantisbt.apis.UsuariosApi;
import com.webhostapp.mantis_bugtracker.mantisbt.dto.NivelAcesoDto;
import com.webhostapp.mantis_bugtracker.mantisbt.dto.UsuarioDto;
import com.webhostapp.mantis_bugtracker.mantisbt.enums.ChaveSessao;
import com.webhostapp.mantis_bugtracker.mantisbt.enums.FormatoData;
import com.webhostapp.mantis_bugtracker.mantisbt.utils.DateUtils;
import com.webhostapp.mantis_bugtracker.mantisbt.utils.JsonUtils;
import com.webhostapp.mantis_bugtracker.mantisbt.utils.ParametrosGlobais;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class UsuariosStepdefinitions {

    private String apiToken;

    @Steps
    UsuariosApi usuariosApi;

    private UsuarioDto usuario;

    @Quando("solicitar recuperar suas informações via API")
    public void solicitarRecuperarSuasInformacoesViaApi() {
        Map<String, String> headers = Serenity.sessionVariableCalled(ChaveSessao.HEADERS);
        SerenityRest.given().headers(headers);

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

    @Dado("informou os dados minimos do novo usuário")
    public void informouOsDadosMinimosDoNovoUsuario() {
        Map<String, String> headers = Serenity.sessionVariableCalled(ChaveSessao.HEADERS);
        headers.put("Content-Type", "application/json");
        usuario = new UsuarioDto();
        usuario.setUsername("Teste " + DateUtils.dataAtualFormatada(FormatoData.DIA_MES_ANO_HORA_MINUTO_SEGUNDO_MILESIMOS_SEM_SEPARADOR));
        String body = JsonUtils.objetoParaJson(usuario);
        SerenityRest.given().headers(headers).body(body);
    }

    @Quando("solicitar a inclusão de novo usuário via API")
    public void solicitarAInclusaoDeNovoUsuarioViaApi() {
        String urlApi = usuariosApi.incluirUsuario();
        SerenityRest.when().post(urlApi);
    }

    @Entao("o sistema deve sinalizar a inclusão com sucesso")
    public void oSistemaDeveSinalizarAInclusaoComSucesso() {
        SerenityRest.then().statusCode(201);
    }

    @Entao("deve retornar os dados do usuário")
    public void deveRetornarOsDadosDoUsuario(DataTable dadosUsuario) {
        for (String dadoUsuario : dadosUsuario.asList()) {
            SerenityRest.and().body("$." + dadoUsuario, not(empty()));
        }
    }
}
