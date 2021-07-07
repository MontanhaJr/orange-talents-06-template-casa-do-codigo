package br.com.zupacademy.mauricio.casadocodigo.cliente.controller;

import br.com.zupacademy.mauricio.casadocodigo.cliente.Cliente;
import br.com.zupacademy.mauricio.casadocodigo.cliente.dto.request.ClienteRequest;
import br.com.zupacademy.mauricio.casadocodigo.estado.dto.response.ClienteResponse;
import br.com.zupacademy.mauricio.casadocodigo.validation.EstadoObrigatorioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class ClienteController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private EstadoObrigatorioValidator estadoObrigatorioValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoObrigatorioValidator);
    }

    @Transactional
    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponse> criar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(entityManager);
        entityManager.persist(cliente);
        return ResponseEntity.ok(new ClienteResponse(cliente.getId()));
    }
}
