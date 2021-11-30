package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.entity.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, String> {
}
