package br.com.zupacademy.mauricio.casadocodigo.estado.controller;

import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import br.com.zupacademy.mauricio.casadocodigo.estado.dto.request.EstadoRequest;
import br.com.zupacademy.mauricio.casadocodigo.estado.repository.EstadoRepository;
import br.com.zupacademy.mauricio.casadocodigo.validation.EstadoUnicoPorPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private EstadoUnicoPorPaisValidator estadoUnicoPorPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoUnicoPorPaisValidator);
    }

    @Transactional
    @PostMapping("/estado")
    public ResponseEntity<?> criar(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(entityManager);
        entityManager.persist(estado);
        return ResponseEntity.ok().build();
    }
}
