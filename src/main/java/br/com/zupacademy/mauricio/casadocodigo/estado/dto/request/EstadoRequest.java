package br.com.zupacademy.mauricio.casadocodigo.estado.dto.request;

import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import br.com.zupacademy.mauricio.casadocodigo.pais.Pais;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private Long id_pais;

    public String getNome() {
        return nome;
    }

    public Long getId_pais() {
        return id_pais;
    }

    @Deprecated
    public EstadoRequest() {
    }

    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.id_pais);

        return new Estado(this.nome, pais);
    }
}
