package com.novik.eventosopenapi.service.impl;


import com.novik.eventosopenapi.entity.Espectador;
import com.novik.eventosopenapi.entity.Evento;
import com.novik.eventosopenapi.repository.EventoRepository;
import com.novik.eventosopenapi.service.ViaCepService;
import com.novik.eventosopenapi.repository.EspectadorRepository;
import com.novik.eventosopenapi.service.EspectadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EspectadorServiceImpl implements EspectadorService {


    @Autowired
    private EspectadorRepository espectadorRepository;

    @Autowired
    private EventoRepository eventoRepository;


    @Autowired
    private ViaCepService viaCepService;



    @Override
    public Iterable<Espectador> buscarTodos() {
        return espectadorRepository.findAll();
    }

    @Override
    public Espectador buscarPorId(Long id) {
        Optional<Espectador> optionalEspectador = espectadorRepository.findById(id);
        return optionalEspectador.get();
    }

    @Override
    public void inserir(Espectador espectador) {
        salvarEspectadorComCep(espectador);
    }

    @Override
    public void atualizar(Long id, Espectador espectador) {
        Optional<Espectador> optionalEspectador = espectadorRepository.findById(id);
        if (optionalEspectador.isPresent()) {
            salvarEspectadorComCep(espectador);
        }
    }

    @Override
    public void deletar(Long id) {
        espectadorRepository.deleteById(id);
    }

    private void salvarEspectadorComCep(Espectador espectador) {
        String cep = espectador.getEventos().getCep();
        Evento evento = eventoRepository.findById(cep).orElseGet(() -> {
            Evento novoEvento = viaCepService.consultarCep(cep);
            eventoRepository.save(novoEvento);
            return novoEvento;
        });
        espectador.setEventos(evento);
        espectadorRepository.save(espectador);
    }
}
