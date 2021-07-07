package br.com.zupacademy.mauricio.casadocodigo.cliente;

import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import br.com.zupacademy.mauricio.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @NotNull @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cep;

    public Long getId() {
        return id;
    }

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

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Deprecated
    public Cliente() {
    }

    public Cliente(@NotBlank String email,
                   @NotBlank String nome,
                   @NotBlank String sobrenome,
                   @NotBlank String documento,
                   @NotBlank String complemento,
                   @NotBlank String cidade,
                   @NotNull Pais pais,
                   Estado estado,
                   @NotBlank String telefone,
                   @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }
}
