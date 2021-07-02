package br.com.zupacademy.mauricio.casadocodigo.controller.request;

import br.com.zupacademy.mauricio.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    private Long id;
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
