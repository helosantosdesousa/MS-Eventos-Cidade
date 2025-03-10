package com.github.helosantosdesousa.MS_Eventos_Cidade.dto;

import java.time.LocalDate;

public record EventoRequestDTO(
        String nome,
        LocalDate data,
        String url
) {

}
