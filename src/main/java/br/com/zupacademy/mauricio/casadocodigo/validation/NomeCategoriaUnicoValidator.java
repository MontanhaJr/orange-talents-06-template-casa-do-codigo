package br.com.zupacademy.mauricio.casadocodigo.validation;

import br.com.zupacademy.mauricio.casadocodigo.categoria.dto.request.CategoriaRequest;
import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;
import br.com.zupacademy.mauricio.casadocodigo.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaUnicoValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaRequest request = (CategoriaRequest) target;

        Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());

        if (categoria.isPresent()) {
            errors.rejectValue("nome", "NomeCategoriaNaoUnico");
        }
    }
}
