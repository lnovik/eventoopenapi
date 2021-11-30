package one.digitalinnovation.gof.service;


import one.digitalinnovation.gof.entity.Espectador;


public interface EspectadorService {

    Iterable<Espectador> buscarTodos();

    Espectador buscarPorId(Long id);

    void inserir(Espectador espectador);

    void atualizar(Long id, Espectador espectador);

    void deletar(Long id);


}
