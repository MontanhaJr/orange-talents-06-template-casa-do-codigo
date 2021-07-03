package br.com.zupacademy.mauricio.casadocodigo.autor.controller;

import br.com.zupacademy.mauricio.casadocodigo.autor.dto.request.AutorRequest;
import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import br.com.zupacademy.mauricio.casadocodigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping("/autor")
    public ResponseEntity<?> criar(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
