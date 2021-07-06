package br.com.zupacademy.mauricio.casadocodigo.pais.dto.request;

import br.com.zupacademy.mauricio.casadocodigo.pais.Pais;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.unique.IsUniqueValidator;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    private Long id;

    @NotBlank
    @IsUniqueValidator(nomeAtributo = "nome", classe = Pais.class)
    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Deprecated
    public PaisRequest() {
    }

    public PaisRequest(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
