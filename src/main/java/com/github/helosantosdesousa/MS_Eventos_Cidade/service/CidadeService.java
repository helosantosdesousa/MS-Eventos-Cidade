package com.github.helosantosdesousa.MS_Eventos_Cidade.service;

import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.CidadeDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoRequestDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.dto.EventoResponseDTO;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Cidade;
import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;
import com.github.helosantosdesousa.MS_Eventos_Cidade.exceptions.DatabaseException;
import com.github.helosantosdesousa.MS_Eventos_Cidade.exceptions.ResourceNotFoundException;
import com.github.helosantosdesousa.MS_Eventos_Cidade.repositories.CidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repository;

    @Transactional(readOnly = true)
    public List<CidadeDTO> findAll(){
        return repository.findAll().stream().map(CidadeDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CidadeDTO findById(Long id){
        Cidade entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. Id: " +id)
        );
        return new CidadeDTO(entity);
    }

    @Transactional
    public CidadeDTO create(CidadeDTO dto){
        Cidade entity = new Cidade();

        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CidadeDTO(entity);
    }

    private void copyDtoToEntity(CidadeDTO dto, Cidade entity){
        entity.setNome(dto.getNome());
        entity.setEstado(dto.getEstado());
        entity.setUf(dto.getUf());
    }

    @Transactional
    public CidadeDTO update(Long id, CidadeDTO dto){
        try{
            Cidade entity = repository.getReferenceById(id);
            copyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new CidadeDTO(entity);
        } catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException("Recurso não encontrado. Id: " + id);
        }
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. Id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar a cidade. " +
                    "Ela está sendo referenciada por um ou mais eventos.");
        }
    }

}
