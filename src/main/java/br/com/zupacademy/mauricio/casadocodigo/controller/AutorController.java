package br.com.zupacademy.mauricio.casadocodigo.controller;

import br.com.zupacademy.mauricio.casadocodigo.form.AutorForm;
import br.com.zupacademy.mauricio.casadocodigo.model.Autor;
import br.com.zupacademy.mauricio.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping("/api/criar")
    public ResponseEntity<?> criar(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = new Autor(autorForm.getNome(), autorForm.getEmail(), autorForm.getDescricao());
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
