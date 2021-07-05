package br.com.zupacademy.mauricio.casadocodigo.livro.controller;

import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;
import br.com.zupacademy.mauricio.casadocodigo.livro.dto.request.LivroRequest;
import br.com.zupacademy.mauricio.casadocodigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/livro")
    public ResponseEntity<?> criar(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(entityManager);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }
}
