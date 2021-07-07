package br.com.zupacademy.mauricio.casadocodigo.cliente.dto.request;

import br.com.zupacademy.mauricio.casadocodigo.cliente.Cliente;
import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import br.com.zupacademy.mauricio.casadocodigo.pais.Pais;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.document.DocumentValidator;
import br.com.zupacademy.mauricio.casadocodigo.validation.annotation.unique.IsUniqueValidator;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    private Long id;
    @NotBlank @Email
    private String email;
    @NotBlank @IsUniqueValidator(nomeAtributo = "nome", classe = Cliente.class)
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @DocumentValidator @IsUniqueValidator(nomeAtributo = "documento", classe = Cliente.class)
    private String documento;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long pais_id;

    private Long estado_id;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public Long getEstado_id() {
        return estado_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Deprecated
    public ClienteRequest() {
    }

    public ClienteRequest(Long id, String email, String nome, String sobrenome, String documento, String complemento, String cidade, Long pais_id, Long estado_id, String telefone, String cep) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais_id = pais_id;
        this.estado_id = estado_id;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.pais_id);
        Estado estado = this.estado_id != null ? entityManager.find(Estado.class, this.estado_id) : null;

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
    }
}
