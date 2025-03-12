package com.github.helosantosdesousa.MS_Eventos_Cidade.dto;

import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;

import java.time.LocalDate;

public record EventoResponseDTO(
        Long id,
        String nome,
        LocalDate data,
        String url,
        CidadeDTO cidade
) {

    public EventoResponseDTO(Evento entity) {
        this(entity.getId(),
                entity.getNome(),
                entity.getData(),
                entity.getUrl(),
                new CidadeDTO(entity.getCidade()));
    }

}
