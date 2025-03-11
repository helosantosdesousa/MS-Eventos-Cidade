package com.github.helosantosdesousa.MS_Eventos_Cidade.controller;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoRequestDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/eventos")

public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> findAll() {
        List<EventoResponseDTO> dto = service.findAll();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> findById(@PathVariable Long id){
        EventoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> insert(@RequestBody EventoRequestDTO requestDTO){
        EventoResponseDTO dto = service.insert(requestDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> update(@PathVariable Long id, @RequestBody EventoRequestDTO requestDTO){
        EventoResponseDTO dto = service.update(id,requestDTO);
        return ResponseEntity.ok(dto);
    }

}
