package br.com.zupacademy.mauricio.casadocodigo.pais.controller;

import br.com.zupacademy.mauricio.casadocodigo.pais.Pais;
import br.com.zupacademy.mauricio.casadocodigo.pais.dto.request.PaisRequest;
import br.com.zupacademy.mauricio.casadocodigo.pais.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping("/pais")
    public ResponseEntity<?> criar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = new Pais(paisRequest);
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }

}
