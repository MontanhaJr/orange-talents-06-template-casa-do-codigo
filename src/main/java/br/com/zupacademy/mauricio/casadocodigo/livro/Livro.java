package br.com.zupacademy.mauricio.casadocodigo.livro;

import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    @Column(nullable = false)
    private String sumario;

    @Column(nullable = false) @Min(20)
    private Double preco;

    @Column(nullable = false) @Min(100)
    private Integer numeroDePaginas;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false) @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Long getId() {
        return id;
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Livro() {
    }

    public Livro(@NotBlank String titulo,
                 @NotBlank @Length(max = 500) String resumo,
                 @NotBlank String sumario,
                 @NotBlank @Min(20) Double preco,
                 @NotBlank @Min(100) Integer numeroDePaginas,
                 @NotBlank String isbn,
                 @NotBlank @Future LocalDate dataPublicacao,
                 @NotBlank Categoria categoria,
                 @NotBlank Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
