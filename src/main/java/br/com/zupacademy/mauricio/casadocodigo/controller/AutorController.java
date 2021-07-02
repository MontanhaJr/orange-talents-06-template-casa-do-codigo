package br.com.zupacademy.mauricio.casadocodigo.controller;

import br.com.zupacademy.mauricio.casadocodigo.controller.request.AutorRequest;
import br.com.zupacademy.mauricio.casadocodigo.model.Autor;
import br.com.zupacademy.mauricio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.mauricio.casadocodigo.validation.EmailAutorUnicoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    private EmailAutorUnicoValidator emailUnicoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailUnicoValidator);
    }

    @PostMapping("/autor")
    public ResponseEntity<?> criar(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
