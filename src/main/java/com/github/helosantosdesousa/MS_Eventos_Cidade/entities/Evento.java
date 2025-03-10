package com.github.helosantosdesousa.MS_Eventos_Cidade.entities;

import java.time.LocalDate;

public class Evento {
    private Long id;
    private String nome;
    private LocalDate data;
    private String url;

    public Evento() {

    }

    public Evento(Long id, String nome, LocalDate data, String url) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.url = url;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
