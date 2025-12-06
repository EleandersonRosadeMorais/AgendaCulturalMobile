package com.ulbra.AgendaCulturalMobile.models;

public class Usuario {
    private int id_pk;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String tipo;

    // 🔹 Construtor vazio (necessário para Retrofit/Gson)
    public Usuario() {}

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters
    public int getId_pk() { return id_pk; }
    public String getNome() { return nome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTipo() { return tipo; }

    // Setters
    public void setId_pk(int id_pk) { this.id_pk = id_pk; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
