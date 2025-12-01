package com.ulbra.myapplication.models;

public class Noticia {
    private String titulo;
    private String corpo;
    private String dataPostagem;
    private String dataEvento;
    private String local;

    // Construtor
    public Noticia(String titulo, String corpo, String dataPostagem, String dataEvento, String local) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.dataPostagem = dataPostagem;
        this.dataEvento = dataEvento;
        this.local = local;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(String dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", corpo='" + corpo + '\'' +
                ", dataPostagem='" + dataPostagem + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}

