package com.github.helosantosdesousa.MS_Eventos_Cidade.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EventoRequestDTO(
        @NotBlank(message = "Campo requerido!")
        @Size(min = 3, max = 100, message = "O nome deve ter de 3 a 100 caracteres")
        String nome,

        @NotNull(message = "A data é obrigatória!")
        @FutureOrPresent(message = "A data deve ser no presente ou futuro!")
        LocalDate data,

        @NotBlank(message = "Campo requerido!")
        @Size(min = 5, max = 255, message = "a url deve ter de 5 a 255 caracteres")
        String url,

        @NotNull(message = "Campo requerido")
        CidadeDTO cidade
) {

}
