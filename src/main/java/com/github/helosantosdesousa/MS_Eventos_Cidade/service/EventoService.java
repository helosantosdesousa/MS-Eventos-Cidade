package com.github.helosantosdesousa.MS_Eventos_Cidade.service;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoRequestDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;
import com.github.helosantosdesousa.MS_Eventos_Cidade.repositories.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
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
    @Transactional(readOnly = true)
    public EventoResponseDTO findById(Long id){
        Evento entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado. Id: " + id)
        );
        return new EventoResponseDTO(entity);
    }

    @Transactional
    public EventoResponseDTO insert(EventoRequestDTO requestDTO){
        Evento entity = new Evento();

        toEntity(requestDTO, entity);
        entity = repository.save(entity);
        return new EventoResponseDTO(entity);
    }

    private void toEntity(EventoRequestDTO requestDTO, Evento entity){
        entity.setNome(requestDTO.nome());
        entity.setData(requestDTO.data());
        entity.setUrl(requestDTO.url());
    }

    @Transactional EventoResponseDTO update(Long id, EventoRequestDTO requestDTO){
        try{
            Evento entity = repository.getReferenceById(id);
            toEntity(requestDTO, entity);
            entity = repository.save(entity);
            return new EventoResponseDTO(entity);
        } catch (EntityNotFoundException ex){
            throw new EntityNotFoundException("Recurso não encontrado. Id: " + id);
        }
    }



}
