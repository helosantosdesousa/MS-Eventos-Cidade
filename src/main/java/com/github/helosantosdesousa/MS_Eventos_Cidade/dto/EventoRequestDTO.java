package com.github.helosantosdesousa.MS_Eventos_Cidade.dto;
<<<<<<< HEAD

=======
import com.fasterxml.jackson.annotation.JsonFormat;
>>>>>>> ac875f8e4cca8ac5ca110c01fcf36a28e630a7d3
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
<<<<<<< HEAD
        LocalDate data,

        @NotBlank(message = "Campo requerido!")
        @Size(min = 5, max = 255, message = "a url deve ter de 5 a 255 caracteres")
=======
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate data,

        @NotBlank(message = "Campo requerido!")
        @Size(min = 10, max = 255, message = "a url deve ter de 10 a 255 caracteres")
>>>>>>> ac875f8e4cca8ac5ca110c01fcf36a28e630a7d3
        String url,

        @NotNull(message = "Campo requerido")
        CidadeDTO cidade
) {

}
