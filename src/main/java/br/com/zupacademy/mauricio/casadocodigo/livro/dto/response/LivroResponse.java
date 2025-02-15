package br.com.zupacademy.mauricio.casadocodigo.livro.dto.response;

import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private Long id;
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Deprecated
    public LivroResponse() {
    }

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static List<LivroResponse> converter(List<Livro> livros) {
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }
}
