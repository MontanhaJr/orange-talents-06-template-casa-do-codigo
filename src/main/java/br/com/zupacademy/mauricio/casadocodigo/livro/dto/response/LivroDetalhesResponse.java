package br.com.zupacademy.mauricio.casadocodigo.livro.dto.response;

import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;
import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.exists.ExistsValidator;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.unique.IsUniqueValidator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class LivroDetalhesResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private String categoria;
    private String autor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    @Deprecated
    public LivroDetalhesResponse() {
    }

    public LivroDetalhesResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria().getNome();
        this.autor = livro.getAutor().getNome();
    }
}
