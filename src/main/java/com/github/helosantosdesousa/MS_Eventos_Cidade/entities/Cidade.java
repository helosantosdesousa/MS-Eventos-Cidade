package com.github.helosantosdesousa.MS_Eventos_Cidade.entities;

public class Cidade {
    private Long id;
    private String nome;
    private String estado;
    private String uf;

    public Cidade() {
    }

    public Cidade(Long id, String nome, String estado, String uf) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
