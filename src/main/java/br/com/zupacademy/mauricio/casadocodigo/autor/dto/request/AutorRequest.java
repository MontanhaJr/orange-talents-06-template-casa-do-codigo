package br.com.zupacademy.mauricio.casadocodigo.autor.dto.request;

import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.unique.IsUniqueValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @IsUniqueValidator(nomeAtributo = "email", classe = Autor.class)
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;

    public AutorRequest(@NotBlank String nome, @NotBlank @Email String email,
                        @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
