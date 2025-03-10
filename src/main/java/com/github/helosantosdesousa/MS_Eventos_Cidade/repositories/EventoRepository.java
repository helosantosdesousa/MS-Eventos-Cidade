package com.github.helosantosdesousa.MS_Eventos_Cidade.repositories;

import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
