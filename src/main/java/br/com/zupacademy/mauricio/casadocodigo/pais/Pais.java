package br.com.zupacademy.mauricio.casadocodigo.pais;

import br.com.zupacademy.mauricio.casadocodigo.pais.dto.request.PaisRequest;

import javax.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public String getNome() {
        return nome;
    }

    @Deprecated
    public Pais() {
    }

    public Pais(PaisRequest paisRequest) {
        this.id = paisRequest.getId();
        this.nome = paisRequest.getNome();
    }
}
