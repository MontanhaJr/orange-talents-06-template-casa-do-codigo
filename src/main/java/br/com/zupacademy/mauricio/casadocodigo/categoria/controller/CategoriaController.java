package br.com.zupacademy.mauricio.casadocodigo.categoria.controller;

import br.com.zupacademy.mauricio.casadocodigo.categoria.dto.request.CategoriaRequest;
import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;
import br.com.zupacademy.mauricio.casadocodigo.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public ResponseEntity<?> criar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
