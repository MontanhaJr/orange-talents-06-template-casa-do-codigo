package br.com.zupacademy.mauricio.casadocodigo.livro.controller;

import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;
import br.com.zupacademy.mauricio.casadocodigo.livro.dto.response.LivroDetalhesResponse;
import br.com.zupacademy.mauricio.casadocodigo.livro.dto.response.LivroResponse;
import br.com.zupacademy.mauricio.casadocodigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ListarLivrosController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livro")
    public List<LivroResponse> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroResponse> response = LivroResponse.converter(livros);
        return response;
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<LivroDetalhesResponse> buscarPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isPresent()) {
            return ResponseEntity.ok().body(new LivroDetalhesResponse(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
