package com.webhostapp.mantis_bugtracker.mantisbt.apis;

public class UsuariosApi extends  BaseApi {

    public String recuperarInformacoesUsuarioLogado() {
        return  baseUrl + "/users/me";
    }

    public String incluirUsuario() {
        return baseUrl + "/users/";
    }
}
