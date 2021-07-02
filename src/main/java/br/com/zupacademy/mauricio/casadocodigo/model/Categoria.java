package br.com.zupacademy.mauricio.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    Categoria() { }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
