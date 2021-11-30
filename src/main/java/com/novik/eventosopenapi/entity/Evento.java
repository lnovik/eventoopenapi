package com.novik.eventosopenapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    private String nomeEvento;

    private String Local;
    private String cep;
    private String horario;

    @OneToMany
    private List<Bandas>bandas;












}
