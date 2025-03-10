package com.github.helosantosdesousa.MS_Eventos_Cidade.dto;

import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record EventoResponseDTO(
        Long id,
        String nome,
        LocalDate data,
        String url
) {

    public static List<EventoResponseDTO> createMock(){
        //data para testes
        LocalDate dataTeste = LocalDate.of(2025, 3, 15);

        return List.of(
                new EventoResponseDTO(1L,"Night Run", dataTeste, "https://nighrtun.com"),
                new EventoResponseDTO(2L,"Meia maratona", dataTeste, "https://meiamaratona.com"),
                new EventoResponseDTO(3L,"Corrida feminina", dataTeste, "https://corridafeminina.com")
        );
    }

}
