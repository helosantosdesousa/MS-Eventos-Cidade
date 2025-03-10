package com.github.helosantosdesousa.MS_Eventos_Cidade.controller;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoRequestDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")

public class EventoController {

@Autowired
    private EventoService service;

@GetMapping
    public ResponseEntity<List<EventoResponseDTO>> findAll(){
    List<EventoResponseDTO> dto = service.findAll();

    return ResponseEntity.ok(dto);
}
}
