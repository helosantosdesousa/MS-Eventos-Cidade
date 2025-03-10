package com.github.helosantosdesousa.MS_Eventos_Cidade.service;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;
import com.github.helosantosdesousa.MS_Eventos_Cidade.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Transactional(readOnly = true)
    public List<EventoResponseDTO> findAll(){
        List<Evento> list = repository.findAll();

        return list.stream().map(EventoResponseDTO::new).toList();
    }
}
