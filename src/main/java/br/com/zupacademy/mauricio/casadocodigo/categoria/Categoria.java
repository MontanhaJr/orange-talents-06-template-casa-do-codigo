package br.com.zupacademy.mauricio.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public String getNome() {
        return nome;
    }

    @Deprecated
    Categoria() { }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
