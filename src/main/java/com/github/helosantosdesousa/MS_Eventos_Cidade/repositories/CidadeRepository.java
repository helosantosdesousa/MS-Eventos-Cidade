package com.github.helosantosdesousa.MS_Eventos_Cidade.repositories;

import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
