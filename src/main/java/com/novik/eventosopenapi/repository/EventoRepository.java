package com.lnovik.repository;

import com.lnovik.entity.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
}
