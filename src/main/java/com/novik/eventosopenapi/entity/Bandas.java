package com.novik.eventosopenapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bandas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private String empresario;
    private String estiloMusical;





}
