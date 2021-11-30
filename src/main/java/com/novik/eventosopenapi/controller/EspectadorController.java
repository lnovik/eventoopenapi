package com.novik.eventosopenapi.controller;

import com.novik.eventosopenapi.entity.Espectador;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import com.novik.eventosopenapi.service.EspectadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/espectadores")
public class EspectadorController {


    @Autowired
    private EspectadorService espectadorService;


    @GetMapping
    public ResponseEntity<Iterable<Espectador>> buscarTodos(){
        return ResponseEntity.ok(espectadorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espectador> buscarPorId(@PathVariable  Long id){
        return ResponseEntity.ok(espectadorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Espectador> inserir(@RequestBody Espectador espectador){
        espectadorService.inserir(espectador);
        return ResponseEntity.ok(espectador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Espectador> atualizar(@PathVariable Long id, @RequestBody Espectador espectador){
        espectadorService.atualizar(id, espectador);
        return ResponseEntity.ok(espectador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        espectadorService.deletar(id);
        return ResponseEntity.ok().build();
    }



}
