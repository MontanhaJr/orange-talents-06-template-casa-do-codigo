package br.com.zupacademy.mauricio.casadocodigo.categoria.dto.request;

import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;

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
