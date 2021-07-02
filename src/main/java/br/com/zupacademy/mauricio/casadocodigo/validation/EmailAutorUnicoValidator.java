package br.com.zupacademy.mauricio.casadocodigo.validation;

import br.com.zupacademy.mauricio.casadocodigo.autor.dto.request.AutorRequest;
import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import br.com.zupacademy.mauricio.casadocodigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailAutorUnicoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AutorRequest request = (AutorRequest) target;

        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
        if (autor.isPresent()) {
            errors.rejectValue("email", "EmailAutorNaoUnico");
        }
    }
}
