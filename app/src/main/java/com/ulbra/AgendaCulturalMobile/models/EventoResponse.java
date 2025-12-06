package com.ulbra.AgendaCulturalMobile.models;

public class EventoResponse {
    private boolean sucesso;
    private String mensagem;
    private Evento dados;
    private String timestamp;

    // Construtor vazio (necessário para Retrofit/Gson)
    public EventoResponse() {}

    // Getters
    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public Evento getDados() { return dados; }
    public String getTimestamp() { return timestamp; }

    // Setters
    public void setSucesso(boolean sucesso) { this.sucesso = sucesso; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public void setDados(Evento dados) { this.dados = dados; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    // Para facilitar debug/logs
    @Override
    public String toString() {
        return "EventoResponse{" +
                "sucesso=" + sucesso +
                ", mensagem='" + mensagem + '\'' +
                ", dados=" + (dados != null ? dados.getTitulo() : "null") +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
