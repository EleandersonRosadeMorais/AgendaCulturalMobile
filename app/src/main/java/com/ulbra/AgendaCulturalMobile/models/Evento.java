package com.ulbra.AgendaCulturalMobile.models;

public class Evento {
    private String titulo;
    private String corpo;
    private String dataPostagem;
    private String dataEvento;
    private String local;
    private String responsavel;   // 🔹 novo campo
    private boolean favoritado;   // campo já existente

    // 🔹 Construtor atualizado com responsável
    public Evento(String titulo, String corpo, String dataPostagem, String dataEvento, String local, String responsavel) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.dataPostagem = dataPostagem;
        this.dataEvento = dataEvento;
        this.local = local;
        this.responsavel = responsavel;
        this.favoritado = false; // padrão
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getCorpo() { return corpo; }
    public void setCorpo(String corpo) { this.corpo = corpo; }

    public String getDataPostagem() { return dataPostagem; }
    public void setDataPostagem(String dataPostagem) { this.dataPostagem = dataPostagem; }

    public String getDataEvento() { return dataEvento; }
    public void setDataEvento(String dataEvento) { this.dataEvento = dataEvento; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getResponsavel() { return responsavel; }   // 🔹 getter
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }   // 🔹 setter

    public boolean isFavoritado() { return favoritado; }
    public void setFavoritado(boolean favoritado) { this.favoritado = favoritado; }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", corpo='" + corpo + '\'' +
                ", dataPostagem='" + dataPostagem + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", local='" + local + '\'' +
                ", responsavel='" + responsavel + '\'' +   // 🔹 incluído no toString
                ", favoritado=" + favoritado +
                '}';
    }
}
