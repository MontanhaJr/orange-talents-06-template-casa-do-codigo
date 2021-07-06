package br.com.zupacademy.mauricio.casadocodigo.estado;

import br.com.zupacademy.mauricio.casadocodigo.estado.dto.request.EstadoRequest;
import br.com.zupacademy.mauricio.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
