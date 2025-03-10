package com.github.helosantosdesousa.MS_Eventos_Cidade.controller;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoRequestDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventos")

public class EventoController {

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> getEvento(){

        //data para testes
        /*LocalDate dataTeste = LocalDate.of(2025, 3, 15);

        ArrayList<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento(1L,"Night Run", dataTeste, "https://nighrtun.com"));
        eventos.add(new Evento(2L,"Meia maratona", dataTeste, "https://meiamaratona.com"));
        eventos.add(new Evento(3L,"Corrida feminina", dataTeste, "https://corridafeminina.com"));*/

        List<EventoResponseDTO> dto = EventoResponseDTO.createMock();

        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity<EventoResponseDTO> createProduto(
            @RequestBody EventoRequestDTO dto){
        EventoResponseDTO eventoDTO = new EventoResponseDTO(10L,
                dto.nome(),
                dto.data(),
                dto.url());

        return ResponseEntity.created(null).body(eventoDTO);
    }
}
