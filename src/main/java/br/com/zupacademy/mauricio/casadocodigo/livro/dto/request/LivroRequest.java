package br.com.zupacademy.mauricio.casadocodigo.livro.dto.request;
import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;
import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.unique.IsUniqueValidator;

import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.exists.ExistsValidator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class LivroRequest {

    private Long id;

    @NotBlank @IsUniqueValidator(nomeAtributo = "titulo", classe = Livro.class)
    private String titulo;

    @NotBlank @Length(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull @Min(20)
    private Double preco;

    @NotNull @Min(100)
    private Integer numeroDePaginas;

    @NotBlank @IsUniqueValidator(nomeAtributo = "isbn", classe = Livro.class)
    private String isbn;

    @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull @ExistsValidator(nomeAtributo = "id", classe = Categoria.class)
    private Long id_categoria;

    @NotNull @ExistsValidator(nomeAtributo = "id", classe = Autor.class)
    private Long id_autor;

    public LivroRequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroRequest(@NotBlank String titulo,
                        @NotBlank @Length(max = 500) String resumo,
                        @NotBlank String sumario,
                        @NotNull @Min(20) Double preco,
                        @NotNull @Min(100) Integer numeroDePaginas,
                        @NotBlank String isbn,
                        @NotNull @Future LocalDate dataPublicacao,
                        @NotNull Long id_categoria,
                        @NotNull Long id_autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.id_categoria = id_categoria;
        this.id_autor = id_autor;
    }

    public Livro toModel(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, id_categoria);
        Autor autor = entityManager.find(Autor.class, id_autor);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn,
                this.dataPublicacao, categoria, autor);
    }
}
