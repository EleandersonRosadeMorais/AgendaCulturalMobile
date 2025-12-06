package com.ulbra.AgendaCulturalMobile.models;

public class LoginResponse {
    private boolean sucesso;
    private String msg;
    private Usuario usuario;

    public boolean isSucesso() { return sucesso; }
    public String getMsg() { return msg; }
    public Usuario getUsuario() { return usuario; }
}
