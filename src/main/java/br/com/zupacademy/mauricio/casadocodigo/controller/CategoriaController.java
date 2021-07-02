package br.com.zupacademy.mauricio.casadocodigo.controller;

import br.com.zupacademy.mauricio.casadocodigo.controller.request.CategoriaRequest;
import br.com.zupacademy.mauricio.casadocodigo.model.Categoria;
import br.com.zupacademy.mauricio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.mauricio.casadocodigo.validation.NomeCategoriaUnicoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    private NomeCategoriaUnicoValidator nomeCategoriaUnicoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeCategoriaUnicoValidator);
    }

    @PostMapping("/categoria")
    public ResponseEntity<?> criar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
