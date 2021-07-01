package br.com.zupacademy.mauricio.casadocodigo.controller;

import br.com.zupacademy.mauricio.casadocodigo.form.AutorForm;
import br.com.zupacademy.mauricio.casadocodigo.model.Autor;
import br.com.zupacademy.mauricio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.mauricio.casadocodigo.validation.EmailUnicoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    private EmailUnicoValidator emailUnicoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailUnicoValidator);
    }

    @PostMapping("/api/criar")
    public ResponseEntity<?> criar(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
