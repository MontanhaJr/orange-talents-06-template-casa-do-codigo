package br.com.zupacademy.mauricio.casadocodigo.livro.controller;

import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;
import br.com.zupacademy.mauricio.casadocodigo.livro.dto.response.LivroResponse;
import br.com.zupacademy.mauricio.casadocodigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
