package com.ulbra.AgendaCulturalMobile.models;

public class Evento {
    private int id_pk;
    private String titulo;
    private String data;          // data do evento
    private String hora;
    private String local;
    private String descricao;
    private String tipoEvento;
    private String responsavel;
    private String banner;
    private String categoria;
    private String criador;
    private String banner_url;

    private boolean favoritado;

    // Construtor vazio (necessário para Retrofit/Gson)
    public Evento() {}

    // Construtor básico
    public Evento(String titulo, String descricao, String dataPostagem, String dataEvento, String local, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = dataEvento;
        this.local = local;
        this.responsavel = responsavel;
        this.favoritado = false; // por padrão não favoritado
    }

    // Getters
    public int getId_pk() { return id_pk; }
    public String getTitulo() { return titulo; }
    public String getData() { return data; }
    public String getHora() { return hora; }
    public String getLocal() { return local; }
    public String getDescricao() { return descricao; }
    public String getTipoEvento() { return tipoEvento; }
    public String getResponsavel() { return responsavel; }
    public String getBanner() { return banner; }
    public String getCategoria() { return categoria; }
    public String getCriador() { return criador; }
    public String getBanner_url() { return banner_url; }

    public boolean isFavoritado() { return favoritado; }

    // Aliases para evitar erros no Adapter
    public String getCorpo() { return descricao; }
    public String getDataEvento() { return data; }
    public String getDataPostagem() { return hora != null ? hora : data; }
    // 🔹 aqui você pode ajustar conforme o JSON (timestamp ou outro campo)

    // Setters
    public void setFavoritado(boolean favoritado) { this.favoritado = favoritado; }
    public void setId_pk(int id_pk) { this.id_pk = id_pk; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setData(String data) { this.data = data; }
    public void setHora(String hora) { this.hora = hora; }
    public void setLocal(String local) { this.local = local; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public void setBanner(String banner) { this.banner = banner; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setCriador(String criador) { this.criador = criador; }
    public void setBanner_url(String banner_url) { this.banner_url = banner_url; }
}
