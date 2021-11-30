package com.novik.eventosopenapi.repository;

import com.novik.eventosopenapi.entity.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
}
