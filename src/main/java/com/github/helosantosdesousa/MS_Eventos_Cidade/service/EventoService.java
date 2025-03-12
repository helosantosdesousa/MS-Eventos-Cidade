package com.github.helosantosdesousa.MS_Eventos_Cidade.service;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoRequestDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Cidade;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;
import com.github.helosantosdesousa.MS_Eventos_Cidade.exceptions.DatabaseException;
import com.github.helosantosdesousa.MS_Eventos_Cidade.exceptions.ResourceNotFoundException;
import com.github.helosantosdesousa.MS_Eventos_Cidade.repositories.CidadeRepository;
import com.github.helosantosdesousa.MS_Eventos_Cidade.repositories.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public List<EventoResponseDTO> findAll(){
        List<Evento> list = repository.findAll();

        return list.stream().map(EventoResponseDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public EventoResponseDTO findById(Long id){
        Evento entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. Id: " + id)
        );
        return new EventoResponseDTO(entity);
    }

    @Transactional
    public EventoResponseDTO insert(EventoRequestDTO requestDTO) {
        try {
            Evento entity = new Evento();
            toEntity(requestDTO, entity);
            entity = repository.save(entity);
            return new EventoResponseDTO(entity);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException("Violação de integridade referencial - Cidade ID: "
                    + requestDTO.cidade().getId());
        }
    }

    private void toEntity(EventoRequestDTO requestDTO, Evento entity){
        entity.setNome(requestDTO.nome());
        entity.setData(requestDTO.data());
        entity.setUrl(requestDTO.url());

        Cidade cidade = cidadeRepository.getReferenceById(requestDTO.cidade().getId());
        entity.setCidade(cidade);
    }

    @Transactional
    public EventoResponseDTO update(Long id, EventoRequestDTO requestDTO) {
        try {
            Evento entity = repository.getReferenceById(id);
            toEntity(requestDTO, entity);
            entity = repository.save(entity);
            return new EventoResponseDTO(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Recurso não encontrado. Id: " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. Id: " + id);
        }
        repository.deleteById(id);
    }

}
